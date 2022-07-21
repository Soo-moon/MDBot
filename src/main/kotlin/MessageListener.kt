import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class MessageListener : ListenerAdapter() {
    private val tag: String = "myLog//MessageListener"
    private val log = Mlog()
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val msg = event.message
        val channel = event.channel
        val user = event.author

        if (msg.contentRaw[0] == '!') {
            val args = msg.contentRaw.substring(1).split(" ")
            //log
            print("$tag || ${log.time()} || username : ${user.name} message : ${msg.contentRaw} \n")
            if (user.name != "MDBot") {
                if (args[0] == "경매" || args[0] == "ㄱㅁ" || args[0] == "rudao" || args[0] == "ra") {
                    val data = args[1].toInt()
                    val eb = EmbedBuilder()

                    eb.setTitle("경매 계산기")
                    eb.addField("4인N빵", "${(data * 0.7215).toInt()}gold", true)
                    eb.addField("4인선점", "${(data * 0.64772).toInt()}gold", true)
                    eb.addBlankField(false)
                    eb.addField("8인N빵", "${(data * 0.83125).toInt()}gold", true)
                    eb.addField("8인선점", "${(data * 0.75568).toInt()}gold", true)

                    channel.sendMessageEmbeds(eb.build()).queue()
                } else if (args[0] == "?" || args[0] == "도움" || args[0] == "help") {
                    channel.sendMessage("명령어 리스트 ").queue()
                    channel.sendMessage("!경매, !ㄱㅁ  ==> 경매분배금 계산 기능(4인,8인)").queue()
                } else {
                    print("$tag || ${log.time()} || er : ${user.name} //")
                    channel.sendMessage("명령어리스트는 !?, !도움, !help 을 입력하세요.").queue()
                }
            }
        }
    }
}