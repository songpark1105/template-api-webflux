package com.example.template.common.exception.handler

import kotlin.reflect.KClass

class MessageItem(
    val status: Int,
    val errorCode: ErrorCode,
    val exception: KClass<out Exception>
) {
    constructor(errorCode: ErrorCode, exception: KClass<out Exception>) : this(
        errorCode.status,
        errorCode,
        exception
   )
}
