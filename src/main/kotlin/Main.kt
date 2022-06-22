import net.dv8tion.jda.api.JDABuilder
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {
    val tokenfile = FileReader(File("./token")).readLines().toString()
    val token = tokenfile.substring(1,tokenfile.length-1)
    val jda = JDABuilder.createDefault(token).build()
    jda.addEventListener(MessageListener())
}