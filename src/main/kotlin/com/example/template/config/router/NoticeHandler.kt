package com.example.template.config.router

import java.net.URI
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import com.example.template.common.dto.PageRequest
import com.example.template.domain.entity.Notice
import com.example.template.domain.repository.NoticeRepository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class NoticeHandler(
    private val noticeRepository: NoticeRepository
) {
    fun getAll(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParams() as PageRequest
        return ServerResponse.ok().body(noticeRepository.findAll(), Notice::class.java)
    }

    fun getById(request: ServerRequest): Mono<ServerResponse> {
        return noticeRepository.findById(request.pathVariable("id").toLong())
            .flatMap { ServerResponse.ok().body(Mono.just(it), Notice::class.java) }
            .switchIfEmpty { ServerResponse.noContent().build() }
    }

    fun create(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(Notice::class.java)
            .flatMap { noticeRepository.save(it) }
            .flatMap { ServerResponse.created(URI.create("/posts/${it.noticeId}")).build() }
    }
}