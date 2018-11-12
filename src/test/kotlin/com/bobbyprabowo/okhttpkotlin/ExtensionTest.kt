package com.bobbyprabowo.okhttpkotlin

import com.bobbyprabowo.okhttpkotlin.extension.httpGet
import com.bobbyprabowo.okhttpkotlin.extension.httpPost
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ExtensionTest {

    @Test
    fun httpGet_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"

        val call = baseUrl.httpGet()
        assertNotNull(call)
    }

    @Test
    fun httpGetWithClient_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"

        val client = OkHttpClient()
        val call = baseUrl.httpGet(client)
        assertNotNull(call)
    }

    @Test
    fun httpGet_shouldReturnCallThatCanPerformGetRequest() {

        val path = "/dummy"
        val expectedBody = "hello Dummy!!"
        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)

        val response = baseUrl.toString().httpGet().execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)
        server.shutdown()
    }

    @Test
    fun httpGetWithClient_shouldReturnCallThatCanPerformGetRequest() {

        val path = "/dummy"
        val expectedBody = "hello Dummy!!"
        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)

        val client = OkHttpClient()
        val response = baseUrl.toString().httpGet(client).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)
        server.shutdown()
    }

    @Test
    fun httpPost_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonUrl = """"
            {
            name="hello"
            }
            """

        val client = OkHttpClient()
        val call = baseUrl.httpPost(client, jsonUrl)
        assertNotNull(call)
    }
}