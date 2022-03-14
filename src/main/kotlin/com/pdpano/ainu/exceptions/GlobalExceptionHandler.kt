package com.pdpano.ainu.exceptions

import com.pdpano.ainu.utils.ResponseMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
@ResponseBody
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(req: HttpServletRequest, e: Exception): ResponseMessage {
        return ResponseMessage(false, e.cause.toString(), e.message!!, null)
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleResourceNotFoundException(req: HttpServletRequest, e: Exception): ResponseMessage {
        return ResponseMessage(false, e.cause.toString(), e.message!!, null)
    }
}