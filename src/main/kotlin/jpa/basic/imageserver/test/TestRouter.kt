package jpa.basic.imageserver.test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class TestRouter {
    val basePath = "/server"

    @Bean
    fun testRoute(handler: TestHandler) = coRouter {
        path(basePath).nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("", handler::get)
                POST("", handler::create)

            }
        }
    }
}