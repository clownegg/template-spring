package application.vo

import java.time.LocalDateTime

data class TodoVo(
        var id: Int? = null,
        val title: String,
        var done: Boolean = false,
        var isEnabled: Boolean = true,
        var isDeleted: Boolean = false,
        var createdAt: LocalDateTime? = null,
        var updatedAt: LocalDateTime? = null,
)
