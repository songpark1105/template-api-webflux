package com.example.template.domain.entity.common

import java.time.LocalDateTime

open class CommonModified: CommonCreated() {
    open var lastModifiedDatetime: LocalDateTime? = null
    open var lastModifiedId: Long? = null
    open var lastModifiedName: String? = null
}
