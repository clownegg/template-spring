package application.dao

import application.entity.Todo
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.Sql
import org.seasar.doma.boot.ConfigAutowireable

@Dao
@ConfigAutowireable
interface TodoDao {
    @Sql("""
        select * from t_todos
        where is_enabled= true and is_deleted = false
    """)
    @Select
    fun selectAll(): List<Todo>

    @Sql("""
        select * from t_todos 
        where is_enabled= true and is_deleted = false
        and id = /* id */1
    """)
    @Select
    fun selectById(id: Int): Todo?
}
