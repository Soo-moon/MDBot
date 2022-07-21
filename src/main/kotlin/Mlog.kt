import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Mlog {

    fun time(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd / HH.mm.ss")
        return current.format(formatter)
    }


}