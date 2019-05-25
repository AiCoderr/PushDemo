package com.aicoder.pushdemo.receiver

import android.content.Context
import com.aicoder.pushdemo.logd
import com.meizu.cloud.pushsdk.MzPushMessageReceiver
import com.meizu.cloud.pushsdk.handler.MzPushMessage
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus

/**
 * <p>作者：AiCoder  5/25/2019 9:41 AM
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：魅族消息推送
 */
class MzPushReceiver : MzPushMessageReceiver() {

    /*** 设备注册回调*/
    override fun onRegister(context: Context?, pushId: String?) {

        logd("push id：$pushId")
    }

    /*** 接收到服务器推送消息回调*/
    override fun onMessage(context: Context?, msg: String?) {
        super.onMessage(context, msg)

        logd("onMessage：$msg")
    }

    /*** 通知栏消息到达*/
    override fun onNotificationArrived(p0: Context?, p1: MzPushMessage?) {
        super.onNotificationArrived(p0, p1)

        logd("onNotificationArrived：$p1")
    }

    /*** 通知栏消息点击*/
    override fun onNotificationClicked(p0: Context?, p1: MzPushMessage?) {
        super.onNotificationClicked(p0, p1)

        logd("onNotificationClicked：$p1")
    }

    /*** 通知栏消息删除*/
    override fun onNotificationDeleted(p0: Context?, p1: MzPushMessage?) {
        super.onNotificationDeleted(p0, p1)

        logd("onNotificationDeleted：$p1")
    }

    /*** 取消注册回调*/
    override fun onUnRegister(context: Context?, isUnRegist: Boolean) {

        logd("onUnRegister：$isUnRegist")
    }

    /*** 设置通知栏小图标*/
    override fun onUpdateNotificationBuilder(builder: PushNotificationBuilder?) {
        super.onUpdateNotificationBuilder(builder)

        logd("onUpdateNotificationBuilder")
    }

    /*** 检查通知栏和透传消息开关状态回调*/
    override fun onPushStatus(context: Context?, switchStatus: PushSwitchStatus?) {
        logd("onPushStatus：$switchStatus")
    }

    /*** 新版订阅回调*/
    override fun onRegisterStatus(context: Context?, registerStatus: RegisterStatus?) {

        logd("onRegisterStatus：$registerStatus")
    }

    /*** 新版反订阅回调*/
    override fun onUnRegisterStatus(context: Context?, registerStatus: UnRegisterStatus?) {

        logd("onUnRegisterStatus：$registerStatus")
    }

    /*** 标签回调*/
    override fun onSubTagsStatus(p0: Context?, p1: SubTagsStatus?) {

        logd("onSubTagsStatus：$p1")
    }

    /*** 别名回调*/
    override fun onSubAliasStatus(p0: Context?, p1: SubAliasStatus?) {

        logd("onSubAliasStatus：$p1")
    }
}