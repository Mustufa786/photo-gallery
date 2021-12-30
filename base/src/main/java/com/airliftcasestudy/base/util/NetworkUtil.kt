package com.airliftcasestudy.base.util

import android.os.Build
import android.util.Log
import com.airliftcasestudy.base.BuildConfig
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller

import okhttp3.OkHttpClient
import okhttp3.Request
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext

object NetworkUtil {

    /**
     * Enable TLS v1.2 Support For Pre Lolliop Version
     */
    fun enableTls12OnPreLollipop(): OkHttpClient.Builder {
        /*val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }*/
        val client: OkHttpClient.Builder = OkHttpClient.Builder().apply {
            connectTimeout(1, TimeUnit.MINUTES)
            readTimeout(1, TimeUnit.MINUTES)
            writeTimeout(1, TimeUnit.MINUTES)
            addNetworkInterceptor {
                val requestBuilder: Request.Builder = it.request().newBuilder()
//                requestBuilder.header("Content-Type", "application/json");
                it.proceed(requestBuilder.build())
            }
            if (BuildConfig.DEBUG) addNetworkInterceptor(LoggingInterceptor())
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            try {
                try {
                    ProviderInstaller.installIfNeeded(InjectUtils.appContext)
                    val sslContext: SSLContext = SSLContext.getInstance("TLSv1.2")
                    sslContext.init(null, null, null)
                    sslContext.createSSLEngine()
                } catch (e: GooglePlayServicesRepairableException) {
                    e.printStackTrace()
                } catch (e: GooglePlayServicesNotAvailableException) {
                    e.printStackTrace()
                } catch (e: NoSuchAlgorithmException) {
                    e.printStackTrace()
                } catch (e: KeyManagementException) {
                    e.printStackTrace()
                }
            } catch (exc: Exception) {
                Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc)
            }
        }
        return client
    }
}
