package se.treehou.newsreader

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import se.treehou.newsreader.koin.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupDependencyInjection()
    }

    /**
     * Setup dependency injection framework.
     */
    private fun setupDependencyInjection() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    newsManagerModule,
                    themeManagerModule,
                    settingsScreenModule,
                    magazineBrowserScreenModule,
                    readerScreenScreenModule,
                    articleModule
                )
            )
        }
    }
}