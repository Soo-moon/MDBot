import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Mlog {

    fun time(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
        return current.format(formatter)
    }
}