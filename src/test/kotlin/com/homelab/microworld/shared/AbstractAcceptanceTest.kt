package com.homelab.microworld.shared

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbstractAcceptanceTest {

    @LocalServerPort
    private val port = 0

    @Autowired
    protected lateinit var restTemplate: TestRestTemplate

    protected fun local() = "http://localhost:$port"

    protected fun postRequest(body:String, path: String){
        val headers = HttpHeaders().also { it.contentType = MediaType.APPLICATION_JSON }
        val request = HttpEntity(body, headers)

        restTemplate.postForObject(
            "${local()}$path",
            request,
            Unit::class.java
        )
    }
}
