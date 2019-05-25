package com.aicoder.pushdemo.receiver

import android.content.Context
import com.aicoder.pushdemo.logd
import com.xiaomi.mipush.sdk.MiPushCommandMessage
import com.xiaomi.mipush.sdk.MiPushMessage
import com.xiaomi.mipush.sdk.PushMessageReceiver

/**
 * <p>作者：AiCoder  5/22/2019 4:10 PM
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：小米推送接收处理
 *
 * 这些方法运行在非 UI 线程中
 */
class MiPushReceiver : PushMessageReceiver() {

    /***  接收到穿透消息*/
    override fun onReceivePassThroughMessage(context: Context?, msg: MiPushMessage?) {
        super.onReceivePassThroughMessage(context, msg)

        logd("onReceivePassThroughMessage：$msg")
    }

    /***  接收到通知栏消息*/
    override fun onNotificationMessageArrived(context: Context?, msg: MiPushMessage?) {
        super.onNotificationMessageArrived(context, msg)

        logd("onNotificationMessageArrived：$msg")
    }

    /*** 点击通知栏消息*/
    override fun onNotificationMessageClicked(context: Context?, msg: MiPushMessage?) {
        super.onNotificationMessageClicked(context, msg)

        logd("onNotificationMessageClicked：$msg")
    }

    /*** 用来接收客户端向服务器发送命令后的响应结果*/
    override fun onCommandResult(context: Context?, msg: MiPushCommandMessage?) {
        super.onCommandResult(context, msg)

        logd("onCommandResult：$msg")
    }

    /*** 用来接收客户端向服务器发送注册命令后的响应结果*/
    override fun onReceiveRegisterResult(context: Context?, msg: MiPushCommandMessage?) {
        super.onReceiveRegisterResult(context, msg)

        logd("onReceiveRegisterResult：$msg")
    }
}