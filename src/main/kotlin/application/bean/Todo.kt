package application.bean

import application.controller.TodoController
import application.routes.TodoRouter
import application.service.TodoService
import org.springframework.context.support.beans

fun todoBeans() = beans {
    bean<TodoRouter>()
    bean {ref<TodoRouter>().todoRouter()}
    bean<TodoController>()
    bean<TodoService>()
}
