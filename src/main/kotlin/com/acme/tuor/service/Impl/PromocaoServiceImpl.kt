package com.acme.tuor.service.Impl

import com.acme.tuor.model.Promocao
import com.acme.tuor.repository.PromocaoREpository
import com.acme.tuor.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl : PromocaoService {


    @Autowired
    lateinit var promocaoRepository: PromocaoREpository

    override fun create(promocao: Promocao) {
        this.promocaoRepository.save(promocao)
    }


    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findById(id).orElseGet(null)
    }

    override fun delete(id: Long) {
        this.promocaoRepository.delete(Promocao(id= id))
    }

    override fun update(id: Long, promocao: Promocao) {
       create(promocao)
    }

    override fun searchByLocal(local: String): List<Promocao> =
        listOf()

    override fun getAll(): List<Promocao> {
       return this.promocaoRepository.findAll()
    }

}