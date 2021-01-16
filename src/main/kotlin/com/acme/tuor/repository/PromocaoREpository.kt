package com.acme.tuor.repository

import com.acme.tuor.model.Promocao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoREpository: JpaRepository<Promocao, Long> {
}