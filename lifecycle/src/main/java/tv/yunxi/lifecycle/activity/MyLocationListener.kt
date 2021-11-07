package tv.yunxi.lifecycle.activity

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author: created by wangkm
 * @time: 2021/11/07 23:32
 * @desc：自定义组件，让组件实现LifecycleObserver接口。
 * 与获取地理位置相关的代码在该类中完成
 * 对于组件中那些需要在页面周期发生变化时得到通知的方法，我们需要在这些方法上使用@OnLifecycleEvent(Lifecycle.Event.On_XXX)标签进行标识。
 * 这样，当页面生命周期发生变化时，这些被标识过的方法便会被自动调用
 * @email: 1240413544@qq.com
 */

open class MyLocationListener: LifecycleObserver {

    private val TAG = "MyLocationListener"

    private var mOnLocationChangedListener: OnLocationChangedListener? = null

    constructor(context: Context,onLocationChangedListener: OnLocationChangedListener){
        this.mOnLocationChangedListener = onLocationChangedListener

        initLocationManager()
    }

    private fun initLocationManager() {

    }


    /**
     * 当Activity执行onResume()方法时，该方法会被自动调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startGetLocation() {
        Log.d(TAG, "startGetLocation: ")
        mOnLocationChangedListener?.onChanged(0.0, 0.0)
    }

    /**
     * 当Activity执行onPause()方法时，该方法会被自动调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopGetLocation() {
        Log.d(TAG, "stopGetLocation: ")
        mOnLocationChangedListener?.onChanged(0.0, 0.0)
    }


    /**
     * 当地理位置发生变化时，通过该接口通知调用者
     */
    interface OnLocationChangedListener {
        /**
         * 地理位置发生变化
         * @param latitude 纬度
         * @param longitude 经度
         */
        fun onChanged(latitude: Double, longitude: Double)
    }
}