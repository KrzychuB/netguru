package com.kb.netguru.di

import android.app.Application
import com.kb.netguru.NetguruApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: NetguruApplication)
}