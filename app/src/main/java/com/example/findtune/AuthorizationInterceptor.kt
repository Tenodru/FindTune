package com.example.findtune

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().signedRequest()
        return chain.proceed(newRequest)
    }

    /**
     * Uses Alex's personal account OAuth token for now.
     */
    private fun Request.signedRequest(): Request {
        return newBuilder()
            .header("Authorization", "Bearer BQA8NRihLD5rux7sThtUmyEQFqWJO_UGzARGj2wyS-5q5Fue2XmI7SvC09tznSIpQXMikwsZvbXwfnFHccoinbYcAaARIQbGz_YIQdCG1fbdiY7Zulatt613_yqceEOWpXG5mtK31WZYSJks_QDYeZf9Ir4anL4F4tM")
            .build()
    }
}