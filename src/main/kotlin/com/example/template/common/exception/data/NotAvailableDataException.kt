package com.example.template.common.exception.data

import com.example.template.common.exception.MessageException

class NotAvailableDataException(
    override val message: String
): MessageException(message) {
}