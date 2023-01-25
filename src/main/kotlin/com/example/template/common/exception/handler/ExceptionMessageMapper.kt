package com.example.template.common.exception.handler

import kotlin.reflect.KClass
import org.springframework.beans.TypeMismatchException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.server.MethodNotAllowedException
import com.example.template.common.exception.BaseException
import com.example.template.common.exception.data.NoDataException
import com.example.template.common.exception.data.NotAvailableDataException
import com.example.template.common.exception.data.NotAvailablePasswordException
import com.example.template.common.exception.request.NotFoundRequestException
import com.example.template.common.exception.security.*
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException

@Component("messageMapper")
class ExceptionMessageMapper(
    private val messageItems: List<MessageItem>
) {
    constructor(): this(
        listOf(
            MessageItem(ErrorCode.INVALID_PARAMETER, BindException::class),
            MessageItem(ErrorCode.INVALID_PARAMETER, HttpMessageNotReadableException::class),
            MessageItem(ErrorCode.INVALID_PARAMETER, MethodArgumentNotValidException::class),
            MessageItem(ErrorCode.INVALID_PARAMETER, TypeMismatchException::class),
            MessageItem(ErrorCode.INVALID_PARAMETER, MethodArgumentTypeMismatchException::class),
//            MessageItem(ErrorCode.ACCESS_DENIED, AccessDeniedException::class),
//            MessageItem(ErrorCode.NOT_FOUND, NoHandlerFoundException::class),
            MessageItem(ErrorCode.METHOD_NOT_ALLOWED, MethodNotAllowedException::class),
//            MessageItem(ErrorCode.BAD_CREDENTIALS, BadCredentialsException::class),
            MessageItem(ErrorCode.DUPLICATE_KEY, DuplicateKeyException::class),
            MessageItem(ErrorCode.DATA_INTEGRITY_VIOLATION, DataIntegrityViolationException::class),

            /* JWT Exception */
            MessageItem(ErrorCode.EXPIRED_TOKEN, ExpiredJwtException::class),      // 만료된 JWT 토큰
            MessageItem(ErrorCode.INVALID_TOKEN, UnsupportedJwtException::class),  // 지원하지 않는 JWT 토큰
            MessageItem(ErrorCode.INVALID_TOKEN, SecurityException::class),        // 잘못된 JWT 서명
            MessageItem(ErrorCode.INVALID_TOKEN, MalformedJwtException::class),    // 잘못된 JWT 서명
            MessageItem(ErrorCode.INVALID_TOKEN, IllegalArgumentException::class), // 잘못된 JWT 서명
            MessageItem(ErrorCode.INVALID_TOKEN, JwtException::class),

            /* Custom Exception */
            MessageItem(ErrorCode.NO_DATA, NoDataException::class),
            MessageItem(ErrorCode.BAD_CREDENTIALS, LoginException::class), // ID/PW 로그인 실패
            MessageItem(ErrorCode.EMPTY_TOKEN, EmptyTokenException::class),
            MessageItem(ErrorCode.EXPIRED_TOKEN, ExpiredTokenException::class),
            MessageItem(ErrorCode.INVALID_TOKEN, InvalidTokenException::class),
            MessageItem(ErrorCode.NOT_FOUND, NotFoundRequestException::class),
            MessageItem(ErrorCode.NOT_ACCEPTABLE, NotAvailableDataException::class),
            MessageItem(ErrorCode.NOT_ACCEPTABLE, NotAvailablePasswordException::class),

            MessageItem(ErrorCode.INTERNAL_SERVER_ERROR, Exception::class),
       )
   )

    fun getMessageItem(exception: KClass<out Exception>): MessageItem {
        for (messageItem in messageItems) {
            if (messageItem.exception == exception) {
                return messageItem
            }
        }
        return MessageItem(ErrorCode.INTERNAL_SERVER_ERROR, BaseException::class)
    }
}
