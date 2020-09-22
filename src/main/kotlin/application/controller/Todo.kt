package application.controller

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import application.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import application.vo.Exception

class TodoController(private val todoService: TodoService) {
    fun findAll(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(Mono.just(todoService.findAll()))

    fun findById(request: ServerRequest): Mono<ServerResponse> {
        val todo = todoService.findById(request.pathVariable("id").toInt())

        return if (todo != null)
            ServerResponse.ok().body(Mono.just(todo))
        else
            ServerResponse.status(HttpStatus.NOT_FOUND).body(
                    Mono.just(Exception(message = "not found"))
            )
    }
}
