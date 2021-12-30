package com.airliftcasestudy.photogallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airliftcasestudy.photogallery.R
import com.airliftcasestudy.photogallery.extension.gotoActivityWithNoHistory

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class SplashScreen : BaseActivity() {
    private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler(Looper.getMainLooper())

    }

    override fun onResume() {
        super.onResume()

        handler?.postDelayed({
            gotoActivityWithNoHistory(MainActivity::class.java)
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)
    }
}