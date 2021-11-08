package tv.yunxi.lifecycle.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * @author: created by wangkm
 * @time: 2021/11/08 07:59
 * @desc：
 * @email: 1240413544@qq.com
 */

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // ProcessLifecycleOwner是针对整个应用程序的监听，与Activity数量无关
        // Lifecycle.Event.ON_CREATE 只会被调用一次，而Lifecycle.Event.ON_DESTROY永远不会被调用
        // 当应用程序从后台回到前台，或者应用程序被首次打开时，会依次调用Lifecycle.Event.ON_START和Lifecycle.Event.ON_RESUME
        // 当应用程序从前台回到后台（用户按下Home键或任务菜单键），会依次调用Lifecycle.Event.ON_PAUSE和Lifecycle.Event.ON_STOP
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}