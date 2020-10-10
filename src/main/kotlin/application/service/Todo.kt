package application.service

import application.entity.Todo
import application.repository.TodoRepository
import application.vo.TodoVo

class TodoService(private val todoRepository: TodoRepository) {
    fun findAll() = todoRepository.findAll()

    fun findById(id: Int) = todoRepository.findById(id)

    fun create(todo: Todo) = todoRepository.create(todo)

    fun update(id: Int, todo: Todo) = todoRepository.update(id, todo)

    fun delete(id: Int) = todoRepository.delete(id)
}
