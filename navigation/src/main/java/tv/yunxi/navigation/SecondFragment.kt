package tv.yunxi.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * @author: created by wangkm
 * @time: 2021/11/08 08:37
 * @desc：
 * @email: 1240413544@qq.com
 */

class SecondFragment:Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)
        val tvUserName = view.findViewById<TextView>(R.id.tv_user_name)
        val tvAge = view.findViewById<TextView>(R.id.tv_age)
        val arguments = arguments
        if (arguments != null) {
            // 常见的接收参数方式
//            String userName = arguments.getString("user_name");
//            int age = arguments.getInt("age");

            // 使用 safe args 接收参数方式
            val secondFragmentArgs: SecondFragmentArgs = SecondFragmentArgs.fromBundle(arguments)
            val userName: String = secondFragmentArgs.userName
            val age: Int = secondFragmentArgs.age
            tvUserName.text = userName
            tvAge.text = age.toString()
        }
        return view
    }

}