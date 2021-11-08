package tv.yunxi.navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

/**
 * @author: created by wangkm
 * @time: 2021/11/08 08:27
 * @desc：
 * @email: 1240413544@qq.com
 */

class MainFragment: Fragment() {

    private val CHANNEL_ID = "1"
    private val notificationId = 8


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        // 跳转页面方法1
        view.findViewById<View>(R.id.btn_to_second_fragment_1)
            .setOnClickListener { v -> // 常见的传递参数方式
                //                Bundle bundle = new Bundle();
                //                bundle.putString("user_name", "Michael");
                //                bundle.putInt("age", 30);
                //                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment, bundle);

                // 使用 safe args 传递参数 写法一
                var secondFragmentArgs = SecondFragmentArgs("Michael",30)
                val bundle  = secondFragmentArgs.toBundle()
                Navigation.findNavController(v)
                    .navigate(R.id.action_mainFragment_to_secondFragment, bundle)
            }

        // 跳转页面方法二
        view.findViewById<View>(R.id.btn_to_second_fragment_2)
            .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_secondFragment))
        view.findViewById<View>(R.id.btn_send_notification)
            .setOnClickListener { sendNotification() }
        return view
    }

    /**
     * 向通知栏发送一条通知，模拟用户收到一条推送的情况
     */
    private fun sendNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importanceDefault = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(CHANNEL_ID, "ChannleName", importanceDefault)
            channel.description = "description"
            val notificationManager: NotificationManager? =
            activity?.let {
                it.getSystemService(NotificationManager::class.java)
            }
            notificationManager?.createNotificationChannel(channel)
        }
        val builder =
            activity?.let {
                NotificationCompat.Builder(it, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("DeepLinkDemo")
                    .setContentText("Test")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 设置 PendingIntent
                    .setContentIntent(getPendingIntent())
                    .setAutoCancel(true)
            }
        val notificationManagerCompat =
            activity?.let { NotificationManagerCompat.from(it) }
        notificationManagerCompat?.notify(notificationId, builder!!.build())
    }

    /**
     * 构建PendingIntent对象
     * 在其中其中设置，当通知被点击时需要跳转到的目的地（destination），以及传递的参数
     * @return PendingIntent
     */
    private fun getPendingIntent(): PendingIntent? {
        val bundle = Bundle()
        bundle.putString("userName", "Michael")
        bundle.putInt("age", 30)
        return Navigation
            .findNavController(requireActivity(), R.id.btn_send_notification)
            .createDeepLink()
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.secondFragment)
            .setArguments(bundle)
            .createPendingIntent()
    }

}