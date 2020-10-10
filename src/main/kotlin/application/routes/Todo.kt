package application.routes

import application.controller.TodoController
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class TodoRouter(private val todoController: TodoController) {
    fun todoRouter() = router {
        ("/todos" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", todoController::findAll)
            GET("/{id}", todoController::findById)
            POST("/", todoController::create)
        }
    }
}
