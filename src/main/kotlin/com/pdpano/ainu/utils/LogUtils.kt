package com.pdpano.ainu.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogUtils {
    fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)
}