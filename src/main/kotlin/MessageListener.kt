import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class MessageListener : ListenerAdapter() {
    private val tag : String ="myLog//MessageListener"
    private val log = Mlog()
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val msg = event.message
        val channel = event.channel
        val user = event.author

        if(msg.contentRaw[0] == '!'){
            val args = msg.contentRaw.substring(1).split(" ")
            //log
            print("$tag || ${log.getTime()} || username : ${user.name} message : $msg \n")
            if (args[0] == "경매" || args[0] == "ㄱㅁ"){
                val data = args[1].toInt()
                val eb = EmbedBuilder()

                eb.setTitle("경매 계산기")
                eb.addField("4인N빵" , "${(data * 0.7215).toInt()}gold" , true)
                eb.addField("4인선점" , "${(data * 0.64772).toInt()}gold" , true)
                eb.addBlankField(false)
                eb.addField("8인N빵" , "${(data * 0.83125).toInt()}gold" , true)
                eb.addField("8인선점" , "${(data * 0.75568).toInt()}gold" , true)

                channel.sendMessageEmbeds(eb.build()).queue()
            }
        }
    }
}