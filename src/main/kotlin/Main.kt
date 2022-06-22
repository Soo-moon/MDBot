import net.dv8tion.jda.api.JDABuilder

fun main(args: Array<String>) {
    var token : String = "OTM5OTEwMzA5MDAxNDM3MjU0.GoBiXv.PiWwvoVHakwZi31U523gbw8X-bq0su6OqqAlsY"
    val jda = JDABuilder.createDefault(token).build()
    jda.addEventListener(MessageListener())
}