package com.acme.tuor.model

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Cliente(
    @JsonProperty("Matricula") val id: Long, val nome: String,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "dd/mm/yyyy"
    ) val dataNascimento: Date, var telefone: Telefone?
)


data class Telefone(val ddd: String = "", val numero: String = "", @JsonIgnore val tipo: String = "")