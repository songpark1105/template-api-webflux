package com.example.template.common.constant

import com.example.template.common.exception.handler.ErrorCode

enum class LoginStatus(val code: ErrorCode, val desc: String) {
    SUCCESS                (ErrorCode.SUCCESS, "성공"),
    SUCCESS_AUTO           (ErrorCode.SUCCESS, "성공(자동로그인)"),
    SUCCESS_REFRESH        (ErrorCode.SUCCESS, "성공(토큰 리프레시)"),
    EXPIRED_TOKEN          (ErrorCode.EXPIRED_TOKEN, "토큰 만료"),
    INVALID_TOKEN          (ErrorCode.INVALID_TOKEN, "토큰 인증 실패"),
    USER_NOT_FOUND         (ErrorCode.BAD_CREDENTIALS, "사용자를 찾을 수 없음"),
    LOGIN_FAILURE          (ErrorCode.BAD_CREDENTIALS, "실패"),
    LOGIN_FAILURE_EXCEEDED (ErrorCode.LOGIN_FAILURE_EXCEEDED, "로그인 실패 횟수 초과"),
    ACCOUNT_INACTIVE       (ErrorCode.ACCOUNT_INACTIVE, "사용 불가"),
    ACCOUNT_LOCKED         (ErrorCode.ACCOUNT_LOCKED, "잠긴 계정"),
    PASSWORD_EXPIRED       (ErrorCode.PASSWORD_EXPIRED, "비밀번호 변경일 초과"),
    PASSWORD_TEMP          (ErrorCode.PASSWORD_TEMP, "임시 비밀번호로 로그인 시도"),
    ABNORMAL               (ErrorCode.BAD_CREDENTIALS, "비정상 계정"),
    EXCEPTION              (ErrorCode.INTERNAL_SERVER_ERROR, ""),


    ;

    fun toMap() = mapOf(
        Pair("code", this.code.code),
        Pair("status", this.name),
   )
}
