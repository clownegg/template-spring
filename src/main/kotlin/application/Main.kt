package application

import application.bean.todoBeans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Main

fun main(args: Array<String>) {
	runApplication<Main>(*args) {
		addInitializers(todoBeans())
	}
}
