package application.controller

import application.entity.Todo
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import application.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import application.vo.Message
import application.vo.TodoVo
import org.springframework.web.reactive.function.server.bodyToMono

class TodoController(private val todoService: TodoService) {
    fun findAll(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(Mono.just(todoService.findAll()))

    fun findById(request: ServerRequest): Mono<ServerResponse> {
        val todo = todoService.findById(request.pathVariable("id").toInt())

        return if (todo != null)
            ServerResponse.ok().body(Mono.just(todo))
        else
            ServerResponse.status(HttpStatus.NOT_FOUND).body(
                    Mono.just(Message(code = 404, message = "the specified id can not be found"))
            )
    }

    fun create(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono<TodoVo>().doOnNext {
            println(it)
        }.flatMap {
            val todo = Todo(it.id, it.title, it.done, it.isEnabled, it.isDeleted, it.createdAt, it.updatedAt)
            val ok = todoService.create(todo)

            println(ok)

             if (ok.count > 0)
                ServerResponse.ok().body(
                        Mono.just(Message(code=200, message = "success"))
                )
            else
                ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        Mono.just(Message(code = 500, message = "some error has appeared"))
                )
        }
    }
}
