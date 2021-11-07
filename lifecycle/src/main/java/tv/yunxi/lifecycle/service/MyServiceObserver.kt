package tv.yunxi.lifecycle.service

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author: created by wangkm
 * @time: 2021/11/07 23:42
 * @desc：
 * @email: 1240413544@qq.com
 */

class MyServiceObserver: LifecycleObserver {

    private val TAG = "MyServiceObserver"

    /**
     * 当Service的onCreate()方法被调用时，该方法会被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun startGetLocation() {
        Log.d(TAG, "startGetLocation: 开始获取地理位置")
    }

    /**
     * 当Service的onDestroy()方法被调用时，该方法会被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation() {
        Log.d(TAG, "stopGetLocation: 停止获取地理位置")
    }
}