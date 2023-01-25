package com.example.template.common.constant

enum class PasswordErrorCode(val message: String) {
    CHARACTER_PATTERN_ERROR("문자 패턴을 확인해주세요."),
    SAME_USERNAME_4("아이디와 동일한 문자 4자리가 입력되었습니다."),
    SAME_CHARACTER_3("같은 문자가 3번 입력되었습니다."),
    CONSECUTIVE_CHARACTERS_3("연속된 문자 3자리가 입력되었습니다."),
    CONSECUTIVE_CHARACTERS_IN_QWERTY_3("쿼티 패턴의 연속 문자 3자리가 입력되었습니다."),
    UNAVAILABLE_WORDS("사용할 수 없는 단어가 포함되어 있습니다."),
    ;
}