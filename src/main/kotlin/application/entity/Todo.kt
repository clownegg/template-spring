package application.entity

import org.seasar.doma.*
import java.time.LocalDateTime

@Entity(immutable = true)
@Table(name = "t_todos")
data class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int,

        @Column(name = "title")
        val title: String,

        @Column(name = "done")
        val done: Boolean,

        @Column(name = "is_enabled")
        val isEnabled: Boolean,

        @Column(name = "is_deleted")
        val isDeleted: Boolean,

        @Column(name = "created_at")
        val createdAt: LocalDateTime,

        @Column(name = "updated_at")
        val updated_at: LocalDateTime
)
