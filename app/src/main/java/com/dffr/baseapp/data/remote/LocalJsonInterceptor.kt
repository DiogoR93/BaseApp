package com.dffr.baseapp.data.remote

import android.content.Context
import com.dffr.baseapp.R
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class LocalJsonInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val rawId = when (path) {
            "/cards" -> R.raw.packs
            else -> null
        }

        return if (rawId != null) {
            val json = context.resources.openRawResource(rawId)
                .bufferedReader().use { it.readText() }

            Response.Builder()
                .request(request)
                .protocol(chain.connection()?.protocol() ?: okhttp3.Protocol.HTTP_1_1)
                .code(200)
                .message("OK")
                .body(json.toResponseBody("application/json".toMediaType()))
                .build()
        } else {
            Response.Builder()
                .request(request)
                .protocol(chain.connection()?.protocol() ?: okhttp3.Protocol.HTTP_1_1)
                .code(404)
                .message("Not Found")
                .body("{\"error\":\"not found\"}".toResponseBody("application/json".toMediaType()))
                .build()
        }
    }
}
