package com.example.template.common.dto

import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Order
import org.springframework.util.MultiValueMap
import com.google.common.base.CaseFormat

data class PageRequest(
    val page: Int = 1,
    val size: Int = 20,
    val sortBy: List<String> = mutableListOf(),
    val sortDesc: List<String> = mutableListOf()
) {
    companion object {
        fun of(params: MultiValueMap<String, String?>): PageRequest {
            return PageRequest(
                page = (params.getFirst("page") ?: "1").toInt(),
                size = (params.getFirst("size") ?: "20").toInt()
            )
        }
    }

    fun toPageable(): org.springframework.data.domain.PageRequest {
        val sort = if (sortBy.isEmpty() || sortDesc.isEmpty()) {
            Sort.by(
                Order(Sort.Direction.DESC, "createdDatetime")
           )
        } else {
            Sort.by(sortBy.mapIndexed { index, it ->
                Order(
                    Sort.Direction.valueOf(sortDesc[index].uppercase()),
                    CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, it)
               )
            })
        }

        return org.springframework.data.domain.PageRequest.of((page - 1) * size, size, sort)
    }
}
