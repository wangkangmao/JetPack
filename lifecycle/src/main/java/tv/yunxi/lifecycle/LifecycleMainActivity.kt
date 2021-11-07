package tv.yunxi.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lifecycle_main.*
import tv.yunxi.lifecycle.activity.LifeCycleActivity
import tv.yunxi.lifecycle.service.LifecycleServiceActivity

class LifecycleMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_main)
        initAction()
    }

    // Lifecycle组件存在的主要意义时帮助我们解耦，让自定义组件也能够感受到生命周期的变化。
    private fun initAction() {
        btn_life_cycle.setOnClickListener {
            startActivity(Intent(this@LifecycleMainActivity, LifeCycleActivity::class.java))
        }
        btn_service.setOnClickListener {
            startActivity(Intent(this@LifecycleMainActivity, LifecycleServiceActivity::class.java))

        }
    }
}