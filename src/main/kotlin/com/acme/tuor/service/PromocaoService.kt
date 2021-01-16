package com.acme.tuor.service

import com.acme.tuor.model.Promocao

interface PromocaoService {
    fun create(promocao: Promocao)
    fun getById(id: Long): Promocao?
    fun delete(id: Long)
    fun update(id: Long, promocao: Promocao)
    fun searchByLocal(local: String): List<Promocao>
    fun getAll(start: Int, size: Int): List<Promocao>
    fun count(): Long
    fun getAllSortedByLocal(): List<Promocao>
    fun getAllByPrecoMenorQue9000(): List<Promocao>
}