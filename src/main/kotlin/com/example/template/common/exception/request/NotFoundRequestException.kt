package com.example.template.common.exception.request

import com.example.template.common.exception.BaseException

class NotFoundRequestException(
    override val message: String,
): BaseException(message)