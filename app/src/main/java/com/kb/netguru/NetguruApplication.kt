package com.kb.netguru

import android.app.Activity
import android.app.Application
import com.kb.netguru.di.DaggerAppComponent
import com.kb.netguru.helper.Navigator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class NetguruApplication @Inject constructor() : Application(), HasActivityInjector
{
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var navigator: Navigator

    override fun onCreate()
    {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}