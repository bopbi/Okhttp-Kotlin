package com.bobbyprabowo.okhttpkotlin

import com.bobbyprabowo.okhttpkotlin.extension.httpGet
import com.bobbyprabowo.okhttpkotlin.extension.httpPost
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
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
        val expectedRequestLine = "GET /dummy HTTP/1.1"
        val expectedBody = "hello Dummy!!"
        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)
        val url = baseUrl.toString()

        val response = url.httpGet().execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)

        server.shutdown()
    }

    @Test
    fun httpGetWithClient_shouldReturnCallThatCanPerformGetRequest() {

        val path = "/dummy"
        val expectedRequestLine = "GET /dummy HTTP/1.1"
        val expectedBody = "hello Dummy!!"
        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)
        val url = baseUrl.toString()

        val client = OkHttpClient()
        val response = url.httpGet(client).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        server.shutdown()
    }

    @Test
    fun httpPost_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val call = baseUrl.httpPost(jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpPostWithClient_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val client = OkHttpClient()
        val call = baseUrl.httpPost(client, jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpPost_shouldReturnCallThatCanPerformPostRequest() {

        val path = "/dummy"
        val expectedRequestLine = "POST /dummy HTTP/1.1"
        val expectedBody = "hello Dummy!!"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)
        val url = baseUrl.toString()

        val response = url.httpPost(jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }

    @Test
    fun httpPostWithClient_shouldReturnCallThatCanPerformPostRequest() {

        val path = "/dummy"
        val expectedRequestLine = "POST /dummy HTTP/1.1"
        val expectedBody = "hello Dummy!!"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)
        val url = baseUrl.toString()

        val client = OkHttpClient()
        val response = url.httpPost(client, jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"));
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }
}