package com.example.template.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import com.example.template.domain.entity.common.CommonModified

@Table("notices")
class Notice: CommonModified() {
    @Id
    var noticeId: Long? = null
    var title: String? = null
    var content: String? = null
    var readCount: Int? = null
    var filePid: String? = null

    fun changeFields(
        title: String? = null,
        content: String? = null,
        readCount: Int? = null,
        filePid: String? = null,
    ) {
        title?.let { this.title = it }
        content?.let { this.content = it }
        readCount?.let { this.readCount = it }
        filePid?.let { this.filePid = it }
    }
}