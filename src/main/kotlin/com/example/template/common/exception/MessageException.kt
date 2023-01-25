package com.example.template.common.exception

open class MessageException(
    override val message: String
): BaseException(message) {
}
