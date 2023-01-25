package com.example.template.common.exception

open class BaseException(
    override val message: String?,
    throwable: Throwable?,
): Exception(message, throwable) {

    constructor(): this("", null)
    constructor(message: String?): this(message, null)
    constructor(throwable: Throwable?): this(null, throwable)

}
