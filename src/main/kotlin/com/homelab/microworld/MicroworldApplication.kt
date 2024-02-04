package com.homelab.microworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroworldApplication

fun main(args: Array<String>) {
	runApplication<MicroworldApplication>(*args)
}
