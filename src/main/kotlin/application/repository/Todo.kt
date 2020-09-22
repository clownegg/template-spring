package application.repository

import application.dao.TodoDao
import application.entity.Todo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TodoRepository(private val todoDao: TodoDao) {
    fun findAll(): List<Todo> = todoDao.selectAll()

    fun findById(id: Int): Todo? = todoDao.selectById(id)
}
