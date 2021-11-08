package tv.yunxi.jetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tv.yunxi.lifecycle.LifecycleMainActivity
import tv.yunxi.navigation.NavigationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAction()
    }

    private fun initAction() {

        btn_life_cycle.setOnClickListener {
            startActivity(Intent(this@MainActivity, LifecycleMainActivity::class.java))
        }

        btn_navigation.setOnClickListener {
            startActivity(Intent(this@MainActivity, NavigationActivity::class.java))
        }
    }
}