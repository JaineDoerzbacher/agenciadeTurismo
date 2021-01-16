package com.acme.tuor.service.Impl

import com.acme.tuor.model.Promocao
import com.acme.tuor.service.PromocaoService
import java.util.concurrent.ConcurrentHashMap

class PromocaoServiceImpl : PromocaoService {

    companion object {

        val initialPromocoes = arrayOf(
            Promocao(1, "Maravilhosa viagem a Cancun", "Cancun", true, 7, 4328.99),
            Promocao(2, "Viagem radical com rapel e escalada", "Nova Zelândia", false, 12, 12000.0),
            Promocao(3, "Viagem espiritual", "Thailandia", false, 17, 15000.0),
            Promocao(4, "Viagem para a família", "Gramado", false, 5, 3499.99)

        )
    }

    var promocoes = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

    override fun create(promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }


    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }

    override fun delete(id: Long) {
        promocoes.remove(id)
    }

    override fun update(id: Long, promocao: Promocao) {
        delete(id)
        promocoes[id] = promocao
    }

    override fun searchByLocal(local: String): List<Promocao> =
        promocoes.filter {
            it.value.local.contains(local, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()

}