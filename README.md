# Okhttp-Kotlin

[![CircleCI](https://circleci.com/gh/bopbi/Okhttp-Kotlin.svg?style=svg)](https://circleci.com/gh/bopbi/Okhttp-Kotlin)

OkHttp Kotlin Extension for Kotlin, Java, and Android

# How to Use

## GET Request with default OkHttpClient
```
val call = "https://httpbin.org/get".httpGet()
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async GET Request with default OkHttpClient
```
val call = "https://httpbin.org/get".httpGet()
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## GET Request with custom OkHttpClient
```
val client = OkHttpClient()
val call = "https://httpbin.org/get".httpGet(client)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async GET Request with custom OkHttpClient
```
val client = OkHttpClient()
val call = "https://httpbin.org/get".httpGet(client)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## POST Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/post".httpPost(jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async POST Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/post".httpPost(jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## POST Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/post".httpPost(client, jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async POST Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/post".httpPost(client, jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## PUT Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/put".httpPut(jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async PUT Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/put".httpPut(jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## PUT Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/put".httpPut(client, jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async PUT Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/put".httpPut(client, jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## DELETE Request with default OkHttpClient
```
val call = "https://httpbin.org/delete".httpDelete()
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async DELETE Request with default OkHttpClient
```
val call = "https://httpbin.org/delete".httpDelete()
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## DELETE Request with custom OkHttpClient
```
val client = OkHttpClient()
val call = "https://httpbin.org/delete".httpDelete(client)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async DELETE Request with custom OkHttpClient
```
val client = OkHttpClient()
val call = "https://httpbin.org/delete".httpDelete(client)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## DELETE Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/delete".httpDelete(jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async DELETE Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/delete".httpDelete(jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```

## DELETE Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/delete".httpDelete(client, jsonBody)
val response = call.execute()
val responseBody = response.body()?.string()
```

## Async DELETE Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val call = "https://httpbin.org/delete".httpDelete(client, jsonBody)
call.enqueue(
    object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            // when failure
        }

        override fun onResponse(call: Call?, response: Response?) {
            // when response is coming
        }
    })
```


License
--------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.