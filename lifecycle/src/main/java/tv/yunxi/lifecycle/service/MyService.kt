package tv.yunxi.lifecycle.service

class MyService : LifecycleService() {

    private var myServiceObserver: MyServiceObserver = MyServiceObserver()

    init {
        // 将观察者和被观察者绑定
        lifecycle.addObserver(myServiceObserver)
    }
}