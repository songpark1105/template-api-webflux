package com.example.template.config.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class NoticeRouter(
    private val noticeHandler: NoticeHandler
) {

    @Bean
    fun noticeRoutes() = router {
        ("/notice" and accept(MediaType.APPLICATION_JSON) and contentType(MediaType.APPLICATION_JSON)).nest {
            GET("/{id}", noticeHandler::getById)
            GET("", noticeHandler::getAll)
        }
    }
}