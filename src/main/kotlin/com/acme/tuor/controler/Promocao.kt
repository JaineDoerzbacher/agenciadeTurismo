package com.acme.tuor.controler

import com.acme.tuor.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {
    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

    @RequestMapping(
        value = ["/sayHello"],
        method = arrayOf(RequestMethod.GET)
    )
    fun sayHello(): String {
        return "Hello world"
    }

    @RequestMapping(
        value = ["/promocoes"],
        method = arrayOf(RequestMethod.GET)
    )
    fun getPromocao() = promocoes[3]
}