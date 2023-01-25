package com.example.template.common.exception.security

import com.example.template.common.exception.BaseException

class EmptyTokenException(
    override val message: String?,
    throwable: Throwable?,
): BaseException(message, throwable) {

    constructor(): this("", null)
    constructor(message: String?): this(message, null)
    constructor(throwable: Throwable?): this(null, throwable)
}
