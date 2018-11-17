package com.bobbyprabowo.okhttpkotlin.extension

import okhttp3.*

val JSON = MediaType.parse("application/json; charset=utf-8")

fun String.httpGet(): Call {
    val request = Request.Builder()
        .url(this)
        .get()
        .build()

    val client = OkHttpClient()
    return client.newCall(request)
}

fun String.httpGet(client: OkHttpClient): Call {
    val request = Request.Builder()
        .url(this)
        .get()
        .build()

    return client.newCall(request)
}

fun String.httpPost(jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .post(body)
        .build()
    val client = OkHttpClient()
    return client.newCall(request)
}

fun String.httpPost(client: OkHttpClient, jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .post(body)
        .build()
    return client.newCall(request)
}

fun String.httpPut(jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .put(body)
        .build()
    val client = OkHttpClient()
    return client.newCall(request)
}

fun String.httpPut(client: OkHttpClient, jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .put(body)
        .build()
    return client.newCall(request)
}

fun String.httpDelete(): Call {
    val request = Request.Builder()
        .url(this)
        .delete()
        .build()

    val client = OkHttpClient()
    return client.newCall(request)
}

fun String.httpDelete(client: OkHttpClient): Call {
    val request = Request.Builder()
        .url(this)
        .delete()
        .build()

    return client.newCall(request)
}

fun String.httpDelete(jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .delete(body)
        .build()
    val client = OkHttpClient()
    return client.newCall(request)
}

fun String.httpDelete(client: OkHttpClient, jsonString: String): Call {
    val body = RequestBody.create(JSON, jsonString)
    val request = Request.Builder()
        .url(this)
        .delete(body)
        .build()
    return client.newCall(request)
}