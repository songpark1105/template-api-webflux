package com.example.template.common.exception.security

import com.example.template.common.constant.LoginStatus
import com.example.template.common.exception.BaseException

class LoginException(
    val loginStatus: LoginStatus,
    override val message: String?,
    throwable: Throwable?,
): BaseException(message, throwable) {

    constructor(loginStatus: LoginStatus): this(loginStatus, loginStatus.desc, null)
//    constructor(loginStatus: LoginStatus, message: String?): this(loginStatus, message, null)
//    constructor(loginStatus: LoginStatus, throwable: Throwable?): this(loginStatus, loginStatus.desc, throwable)
}
