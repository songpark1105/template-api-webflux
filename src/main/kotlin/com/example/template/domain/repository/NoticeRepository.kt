package com.example.template.domain.repository

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import com.example.template.domain.entity.Notice
import reactor.core.publisher.Flux

interface NoticeRepository: ReactiveCrudRepository<Notice, Long> {
    fun findAllBy(pageRequest: PageRequest): Flux<Notice>
}