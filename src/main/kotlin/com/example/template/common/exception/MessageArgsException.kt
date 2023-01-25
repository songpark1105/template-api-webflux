package com.example.template.common.exception

open class MessageArgsException(
    vararg val messageArgs: String
): BaseException() {
}
