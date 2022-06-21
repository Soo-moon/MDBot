import net.dv8tion.jda.api.JDABuilder

fun main(args: Array<String>) {
    var token : String = ""
    val jda = JDABuilder.createDefault(token).build()
    jda.addEventListener(MessageListener())
}