package com.bobbyprabowo.okhttpkotlin

import com.bobbyprabowo.okhttpkotlin.extension.httpDelete
import com.bobbyprabowo.okhttpkotlin.extension.httpGet
import com.bobbyprabowo.okhttpkotlin.extension.httpPost
import com.bobbyprabowo.okhttpkotlin.extension.httpPut
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

    // POST

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
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
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
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }

    // PUT
    @Test
    fun httpPut_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val call = baseUrl.httpPut(jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpPutWithClient_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val client = OkHttpClient()
        val call = baseUrl.httpPut(client, jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpPut_shouldReturnCallThatCanPerformPutRequest() {

        val path = "/dummy"
        val expectedRequestLine = "PUT /dummy HTTP/1.1"
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

        val response = url.httpPut(jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }

    @Test
    fun httpPutWithClient_shouldReturnCallThatCanPerformPutRequest() {

        val path = "/dummy"
        val expectedRequestLine = "PUT /dummy HTTP/1.1"
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
        val response = url.httpPut(client, jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }

    // DELETE

    @Test
    fun httpDelete_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"

        val call = baseUrl.httpDelete()
        assertNotNull(call)
    }

    @Test
    fun httpDeleteWithClient_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"

        val client = OkHttpClient()
        val call = baseUrl.httpDelete(client)
        assertNotNull(call)
    }

    @Test
    fun httpDelete_shouldReturnCallThatCanPerformDeleteRequest() {

        val path = "/dummy"
        val expectedRequestLine = "DELETE /dummy HTTP/1.1"
        val expectedBody = "hello Dummy!!"
        val server = MockWebServer()

        // Schedule some responses.
        server.enqueue(MockResponse().setBody(expectedBody))

        // Start the server.
        server.start()

        // Ask the server for its URL. You'll need this to make HTTP requests.
        val baseUrl = server.url(path)
        val url = baseUrl.toString()

        val response = url.httpDelete().execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)

        server.shutdown()
    }

    @Test
    fun httpDeleteWithClient_shouldReturnCallThatCanPerformDeleteRequest() {

        val path = "/dummy"
        val expectedRequestLine = "DELETE /dummy HTTP/1.1"
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
        val response = url.httpDelete(client).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        server.shutdown()
    }

    @Test
    fun httpDelete_withBody_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val call = baseUrl.httpDelete(jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpDeleteWithClientAndBody_shouldReturnCall() {

        val baseUrl = "http://dummy.com/dumbCall"
        val jsonBody = """"
            {
            name="hello"
            }
            """

        val client = OkHttpClient()
        val call = baseUrl.httpDelete(client, jsonBody)
        assertNotNull(call)
    }

    @Test
    fun httpPutWIthBody_shouldReturnCallThatCanPerformDeleteRequest() {

        val path = "/dummy"
        val expectedRequestLine = "DELETE /dummy HTTP/1.1"
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

        val response = url.httpDelete(jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }

    @Test
    fun httpDeleteWithClientAndBody_shouldReturnCallThatCanPerformDeleteRequest() {

        val path = "/dummy"
        val expectedRequestLine = "DELETE /dummy HTTP/1.1"
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
        val response = url.httpDelete(client, jsonBody).execute()
        val bodyResult = response.body()?.string()
        assertEquals(bodyResult, expectedBody)

        val request = server.takeRequest()
        val resultRequestLine = request.requestLine
        assertEquals(resultRequestLine, expectedRequestLine)
        assertEquals("application/json; charset=utf-8", request.getHeader("Content-Type"))
        assertEquals(jsonBody, request.body.readUtf8())
        server.shutdown()
    }
}