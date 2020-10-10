package application.repository

import application.dao.TodoDao
import application.entity.Todo
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Repository
import application.vo.TodoVo

@Repository
class TodoRepository(private val todoDao: TodoDao) {
    fun findAll() = todoDao.selectAll()

    fun findById(id: Int) = todoDao.selectById(id)

    fun create(todo: Todo) = todoDao.create(todo)

    fun update(id: Int, todo: Todo) = todoDao.update(id, todo)

    fun delete(id: Int) = todoDao.delete(id)
}
