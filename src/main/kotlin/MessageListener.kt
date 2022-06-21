import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class MessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf(
                "[PM] %s: %s\n", event.author.name,
                event.message.contentDisplay
            )
        } else {
            System.out.printf(
                "[%s][%s] %s: %s\n", event.guild.name,
                event.textChannel.name, event.member!!.effectiveName,
                event.message.contentDisplay
            )
        }
    }
}