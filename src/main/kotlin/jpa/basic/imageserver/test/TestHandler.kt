package jpa.basic.imageserver.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

private val log = KotlinLogging.logger {}

@Component
class TestHandler(
    private val testRepository: TestRepository,
) {
    suspend fun get(request: ServerRequest): ServerResponse {
        log.info { "]-----] TestHandler::create [-----[ call " }
        val findAll = withContext(Dispatchers.IO) {
            testRepository.findAll()
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(findAll)
    }

    suspend fun create(request: ServerRequest): ServerResponse {
        log.info { "]-----] TestHandler::create [-----[ call " }
        val user = request.awaitBody<User>()
        val result = testRepository.save(user)
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(result)

    }
}