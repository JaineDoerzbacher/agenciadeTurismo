package com.acme.tuor.controller

import com.acme.tuor.excepcion.PromocaoNotFoundExcepcion
import com.acme.tuor.model.ErrorMessage
import com.acme.tuor.model.Promocao
import com.acme.tuor.model.RespostaJSON
import com.acme.tuor.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

    @Autowired

    lateinit var promocaoService: PromocaoService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {

        var promocao = this.promocaoService.getById(id)

        return if (promocao != null)
            return ResponseEntity(promocao, HttpStatus.OK)
        else return ResponseEntity(
            ErrorMessage("Promocao nao localizada", "Promocao ${id} nao localizada"),
            HttpStatus.NOT_FOUND
        )
    }


    @PostMapping()
    fun create(@RequestBody promocao: Promocao): ResponseEntity<RespostaJSON> {
        this.promocaoService.create(promocao)
        val respostaJSON = RespostaJSON("Ok", Date())
        return ResponseEntity(respostaJSON, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            this.promocaoService.delete(id)

        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getById(id) != null) {
            this.promocaoService.update(id, promocao)
            status = HttpStatus.ACCEPTED
        }

        return ResponseEntity(Unit, status)
    }

    @GetMapping()
    fun getAll(@RequestParam(required = false, defaultValue = "") localFilter: String): ResponseEntity<List<Promocao>> {

        var status = HttpStatus.OK
        var listaPromocoes = this.promocaoService.searchByLocal(localFilter)
        if (listaPromocoes.size == 0) {

            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity(listaPromocoes, status)
    }
}