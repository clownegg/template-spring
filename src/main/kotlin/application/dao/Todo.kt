package application.dao

import application.entity.Todo
import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result
import org.springframework.transaction.annotation.Transactional

@Dao
@ConfigAutowireable
interface TodoDao {
    @Sql("""
        select * from t_todos
        where is_enabled= true and is_deleted = false
    """)
    @Select
    @Transactional
    fun selectAll(): List<Todo>

    @Sql("""
        select * from t_todos 
        where is_enabled= true and is_deleted = false
        and id = /* id */1
    """)
    @Select
    @Transactional
    fun selectById(id: Int): Todo?

    @Sql("""
        insert into t_todos (title, done) 
        values (
            /* todo.title */'test',
            /* todo.done */0
        )
    """)
    @Insert
    @Transactional
    fun create(todo: Todo): Result<Todo>

    @Sql("""
        update t_todos
        set title = /* todo.title */'title', done=/* todo.done */0
        where id = /* id */0
        and is_enabled = true and is_deleted = false
    """)
    @Update
    @Transactional
    fun update(id: Int, todo: Todo): Result<Todo>

    @Sql("""
        delete from t_todos
        where id = /* id */0
    """)
    @Delete
    @Transactional
    fun delete(id: Int): Result<Todo>
}
