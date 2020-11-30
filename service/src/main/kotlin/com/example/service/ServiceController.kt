package com.example.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.sleep

@RestController("/")
class ServiceController {

	@Value("\${eureka.instance.instance-id}")
	var instanceId : String = ""

	@RequestMapping(path = ["/"], method = [ RequestMethod.GET ], produces = ["application/json"])
	fun hello() = Greeting(text = "Hello from $instanceId", language = "en")

	@RequestMapping(path = ["/slow"], method = [ RequestMethod.GET ], produces = ["application/json"])
	fun slow(@RequestParam("time", defaultValue = "10000") time : Long) {
		sleep(time)
		Greeting(text = "Hello from $instanceId", language = "en")
	}

}
