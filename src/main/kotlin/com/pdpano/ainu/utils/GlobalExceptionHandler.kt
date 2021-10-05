package com.pdpano.ainu.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleException(req: HttpServletRequest, e: Exception): ResponseEntity<ResponseMessage> {
        return ResponseEntity(ResponseMessage(400, e.cause.toString(), e.message!!, null), HttpStatus.BAD_REQUEST)
    }
}