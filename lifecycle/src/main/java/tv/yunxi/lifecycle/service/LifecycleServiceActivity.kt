package tv.yunxi.lifecycle.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lifecycle_service.*
import tv.yunxi.lifecycle.R

class LifecycleServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_service)

        initAction()
    }

    private fun initAction() {
        btn_start_service.setOnClickListener {
            // 启动服务
            val intent = Intent(this@LifecycleServiceActivity, MyService::class.java)
            startService(intent)
        }

        btn_stop_service.setOnClickListener {
            // 停止服务
            val intent = Intent(this@LifecycleServiceActivity, MyService::class.java)
            stopService(intent)
        }

    }
}