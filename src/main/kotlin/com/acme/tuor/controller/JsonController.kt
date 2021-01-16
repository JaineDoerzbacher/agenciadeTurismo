package com.acme.tuor.controller

import com.acme.tuor.model.Cliente
import com.acme.tuor.model.SimpleObject
import com.acme.tuor.model.Telefone
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class JsonController {

    @RequestMapping("/Json")
    fun getJson() = SimpleObject()

    @GetMapping("/cliente")
    fun getCliente(): Cliente {

        var telefone = Telefone("21", "92019201", "Fixo")
        var cliente = Cliente(1, "Bruna", Date(), telefone)
        return cliente
    }

}