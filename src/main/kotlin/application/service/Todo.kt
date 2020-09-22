package application.service

import application.entity.Todo
import application.repository.TodoRepository
import java.time.LocalDateTime

class TodoService(private val todoRepository: TodoRepository) {
    fun findAll() = todoRepository.findAll()

    fun findById(id: Int) = todoRepository.findById(id)
}
