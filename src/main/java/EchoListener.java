import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EchoListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        if (content.equals("!avatar")) {
            Guild guild = event.getGuild();
            MessageChannel channel = event.getChannel();
            GuildChannel gchannel = event.getGuildChannel();
            Member member = event.getMember();
            if (guild.getSelfMember().hasPermission(gchannel, (Permission.MESSAGE_SEND, Permission.VIEW_CHANNEL) ) {
                String avatarUrl = member.AVATAR_URL;
                channel.sendMessage(avatarUrl).queue();
            } else {
                channel.sendMessage("[Ошибка]: Не могу отправить сюда картинку!").queue();
            }

        }
        if (content.equals("!join")) {
            Guild guild = event.getGuild();
            Member member = event.getMember();
//            VoiceChannel myChannel = guild.getVoiceChannelById();
        }
    }
}
