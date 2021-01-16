package com.acme.tuor.advice

import com.acme.tuor.excepcion.PromocaoNotFoundExcepcion
import com.acme.tuor.model.ErrorMessage
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Error
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExcepcionHandler(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ): ResponseEntity<ErrorMessage> {

        return ResponseEntity(ErrorMessage("JSON ERROR", exception.message ?: "Invalid JSON"), HttpStatus.BAD_REQUEST)

    }

    @ExceptionHandler(PromocaoNotFoundExcepcion::class)
    fun PromocaoNotFoundExcepcionHandler(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("Promocao nao localizada", exception.message!!), HttpStatus.NOT_FOUND)
    }
}