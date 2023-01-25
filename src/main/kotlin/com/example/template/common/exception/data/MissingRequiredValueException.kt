package com.example.template.common.exception.data

import com.example.template.common.exception.MessageException

class MissingRequiredValueException(
    override val message: String
): MessageException(message) {
}