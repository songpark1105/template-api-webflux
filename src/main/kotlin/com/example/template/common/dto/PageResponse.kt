package com.example.template.common.dto

import kotlin.math.ceil
import org.springframework.data.domain.Page

data class PageResponse<T>(
    val content: MutableList<T>,
    val first: Boolean,
    val last: Boolean,
    val totalPages: Int,
    val totalElements: Long,
    val page: Int,
    val size: Int,
) {
    companion object {
        fun <T> of(page: Page<T>): PageResponse<T> {
            return PageResponse(
                content = page.content,
                first = page.isFirst,
                last = page.isLast,
                totalPages = page.totalPages,
                totalElements = page.totalElements,
                page = page.number + 1,
                size = page.size,
           )
        }

        fun <T> of(list: MutableList<T>, totalElements: Long, pageRequest: PageRequest): PageResponse<T> {
            val page = pageRequest.page
            val size = pageRequest.size
            val totalPages = if (totalElements > 0) ceil(totalElements.toDouble() / size).toInt() else 1
            val first = page == 1
            val last = totalPages == page
            return PageResponse(
                list,
                first,
                last,
                totalPages,
                totalElements,
                page,
                size
            )
        }
    }
}
