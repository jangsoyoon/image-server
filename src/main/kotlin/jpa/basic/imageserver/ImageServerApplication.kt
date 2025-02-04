package jpa.basic.imageserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImageServerApplication

fun main(args: Array<String>) {
    runApplication<ImageServerApplication>(*args)
}
