# Okhttp-Kotlin

[![CircleCI](https://circleci.com/gh/bopbi/Okhttp-Kotlin.svg?style=svg)](https://circleci.com/gh/bopbi/Okhttp-Kotlin)  [ ![Download](https://api.bintray.com/packages/bopbi/maven/okhttpkotlin/images/download.svg) ](https://bintray.com/bopbi/maven/okhttpkotlin/_latestVersion)

OkHttp Kotlin Extension for Kotlin, Java, and Android

the library is hosted on jcenter, to use it please add dependency

    compile 'com.bobbyprabowo.okhttp-kotlin:okhttpkotlin:latest-version'

# How to Use

## GET Request with default OkHttpClient
```
val response = "https://httpbin.org/get".httpGet().execute()
val responseBody = response.body()?.string()
```
## GET Request with custom OkHttpClient
```
val client = OkHttpClient()
val response = "https://httpbin.org/get".httpGet(client).execute()
val responseBody = response.body()?.string()
```

## POST Request with default OkHttpClient
```
val jsonBody = "{ \"foo\" : \"bar\" }"
val ersponse = "https://httpbin.org/post".httpPost(jsonBody).execute()
val responseBody = response.body()?.string()
```

## POST Request with custom OkHttpClient
```
val client = OkHttpClient()
val jsonBody = "{ \"foo\" : \"bar\" }"
val ersponse = "https://httpbin.org/post".httpPost(jsonBody).execute()
val responseBody = response.body()?.string()
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