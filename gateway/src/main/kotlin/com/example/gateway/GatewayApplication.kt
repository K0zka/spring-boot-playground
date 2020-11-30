package com.example.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.hystrix.EnableHystrix

@EnableHystrix
@SpringBootApplication
class GatewayApplication {

}

fun main(args: Array<String>) {
	runApplication<GatewayApplication>(*args)
}
