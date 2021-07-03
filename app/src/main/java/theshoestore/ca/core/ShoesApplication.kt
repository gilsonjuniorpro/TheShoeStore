package theshoestore.ca.core

import android.app.Application
import android.content.ContentResolver

class ShoesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var resolver: ContentResolver

        fun setContentResolver(contentResolver: ContentResolver?) {
            if (contentResolver != null) {
                resolver = contentResolver
            }
        }

        fun getResolver() = resolver

        private val TAG = ShoesApplication::class.java.simpleName

        @get:Synchronized
        var instance: ShoesApplication? = null
            private set
    }
}