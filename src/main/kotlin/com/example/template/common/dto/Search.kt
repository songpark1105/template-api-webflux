package com.example.template.common.dto

import java.time.LocalDate

open class Search {
    val keywordType: String? = null
    val keyword: String? = null
    val dateType: String? = null
    val fromDate: LocalDate? = null
    val toDate: LocalDate? = null
}
