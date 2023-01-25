package com.example.template.common.exception.handler

enum class ErrorCode(
    val status: Int,
    val code: String,
    val message: String
) {
    INVALID_PARAMETER        (400, "400",    "잘못된 파라미터"),
    UNAUTHORIZED             (401, "401",    "인증 필요"),
    BAD_CREDENTIALS          (401, "401-10", "로그인 실패"),
    LOGIN_FAILURE_EXCEEDED   (401, "401-11", "로그인 실패 횟수 초과"),
    ACCOUNT_INACTIVE         (401, "401-12", "비활성화 계정"),
    ACCOUNT_LOCKED           (401, "401-13", "잠긴 계정"),
    PASSWORD_EXPIRED         (401, "401-14", "비밀번호 사용 기간 만료"),
    PASSWORD_TEMP            (401, "401-15", "임시 비밀번호로 로그인 시도"),
    EMPTY_TOKEN              (401, "401-21", "토큰값 없음"),
    EXPIRED_TOKEN            (401, "401-22", "토큰 유효기간 만료"),
    INVALID_TOKEN            (401, "401-23", "잘못된 토큰"),
    ACCESS_DENIED            (403, "403",    "접근 권한 없음"),
    NOT_FOUND                (404, "404",    "찾을 수 없는 요청"),
    METHOD_NOT_ALLOWED       (405, "405",    "지원하지 않는 메소드"),
    NOT_ACCEPTABLE           (406, "406",    "접근할 수 없음"),
    UNSUPPORTED_MEDIA_TYPE   (415, "415",    "지원하지 않는 미디어 타입"),

    INTERNAL_SERVER_ERROR    (500, "500", "서버 에러"),
    DUPLICATE_KEY            (500, "921", "중복 키 발생"),
    DATA_INTEGRITY_VIOLATION (500, "922", "데이터 무결성 위반"),

    NO_DATA(200, "924", "데이터 없음"),
    SUCCESS(200, "200", "성공"),
}
