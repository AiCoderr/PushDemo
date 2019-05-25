package com.aicoder.pushdemo

import android.util.Log

/**
 * <p>作者：AiCoder  5/22/2019 4:18 PM
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：全局扩展
 */

/*** debug日志打印*/
fun logd(msg: String, tag: String = "hsc") {
    if (BuildConfig.DEBUG) {
        Log.d(tag, msg)
    }
}

fun loge(msg: String, error: Throwable?, tag: String = "hsc") {
    if (BuildConfig.DEBUG) {
        Log.e(tag, msg, error)
    }
}