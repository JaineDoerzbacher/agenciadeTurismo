package com.acme.tuor.service.Impl

import com.acme.tuor.model.Promocao
import com.acme.tuor.repository.PromocaoREpository
import com.acme.tuor.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
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
        this.promocaoRepository.deleteById(id)
    }

    override fun update(id: Long, promocao: Promocao) {
       create(promocao)
    }

    override fun searchByLocal(local: String): List<Promocao> =
        listOf()

    override fun getAll(start: Int, size: Int): List<Promocao> {
        val pages: Pageable = PageRequest.of(start, size, Sort.by("locak").ascending())
        return this.promocaoRepository.findAll(pages).toList()
    }

    override fun count(): Long =
        this.promocaoRepository.count()

    override fun getAllSortedByLocal(): List<Promocao> =
        this.promocaoRepository.findAll(Sort.by("local" ).descending()).toList()



}