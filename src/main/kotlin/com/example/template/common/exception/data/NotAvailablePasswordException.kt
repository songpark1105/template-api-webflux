package com.example.template.common.exception.data

import com.example.template.common.constant.PasswordErrorCode
import com.example.template.common.exception.MessageException

class NotAvailablePasswordException(
    errorCode: PasswordErrorCode
): MessageException(errorCode.message) {
}