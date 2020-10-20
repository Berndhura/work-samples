package com.example.guitest

import java.net.HttpURLConnection
import java.net.URL

fun sendGet() {
    val url = URL("http://www.google.com/")

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                println(line)
            }
        }
    }
}