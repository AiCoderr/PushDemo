package com.aicoder.pushdemo

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process
import com.meizu.cloud.pushsdk.PushManager
import com.meizu.cloud.pushsdk.util.MzSystemUtils
import com.xiaomi.channel.commonutils.logger.LoggerInterface
import com.xiaomi.mipush.sdk.Logger
import com.xiaomi.mipush.sdk.MiPushClient


/**
 * <p>作者：AiCoder  5/22/2019 4:25 PM
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：全局Application
 */
class APP : Application() {
    override fun onCreate() {
        super.onCreate()

        initMiPush()

        initMzPush()

        initLog()
    }

    private fun initMzPush() {
        if (MzSystemUtils.isBrandMeizu(this)) {
            PushManager.register(this, MEIZU_APP_ID, MEIZU_APP_KEY)
        }
    }

    private fun initMiPush() {
        if (shouldInit()) {
            MiPushClient.registerPush(this, XIAOMI_APP_ID, XIAOMI_APP_KEY)
        }
    }

    private fun initLog() {
        val logger = object : LoggerInterface {
            override fun setTag(p0: String?) {
                p0?.let { logd(it) }
            }

            override fun log(p0: String?) {
                p0?.let { logd(it) }
            }

            override fun log(p0: String?, p1: Throwable?) {
                p0?.let { loge(it, p1) }
            }
        }

        Logger.setLogger(this, logger)
    }

    private fun shouldInit(): Boolean {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processInfos = am.runningAppProcesses
        val mainProcessName = packageName
        val myPid = Process.myPid()
        for (info in processInfos) {
            if (info.pid == myPid && mainProcessName == info.processName) {
                return true
            }
        }
        return false
    }

    fun reInitPush(ctx: Context) {
        MiPushClient.registerPush(ctx.applicationContext, XIAOMI_APP_ID, XIAOMI_APP_KEY)
    }

    companion object {
        private const val XIAOMI_APP_ID = "2882303761518009755"
        private const val XIAOMI_APP_KEY = "5721800962755"

        private const val MEIZU_APP_ID = "120895"
        private const val MEIZU_APP_KEY = "300d90d120dc4d659be963e83944bf79"
    }
}