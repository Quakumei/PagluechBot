import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.api.utils.AttachmentOption;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Locale;

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
        if (content.equals("!info") ) {
            TextChannel tc = event.getTextChannel();


            EmbedBuilder EB = new EmbedBuilder();
            EB.setThumbnail("https://github.com/Quakumei/PagluechBot/raw/main/src/main/resources/pagluech.png");
            EB.setTitle("PagluechBot", "https://github.com/Quakumei/PagluechBot/");
            EB.setAuthor("Quakumei", "https://github.com/Quakumei", "https://avatars.githubusercontent.com/u/53406289?v=4");
            EB.setDescription("PagluechBot is a discord bot to test Discord API and everything I can imagine. Will become a DJ.");
            EB.setFooter("PagluechBot", "https://github.com/Quakumei/PagluechBot/raw/main/src/main/resources/pagluech.png");
            MessageEmbed build = EB.build();
            tc.sendMessageEmbeds(build).queue();

//            if (event.getGuild().getSelfMember().hasPermission(tc, Permission.MESSAGE_EMBED_LINKS)) {
//                File f = new File("target/classes/pagluech.png");
//                tc.sendFile(f, "pagluech.png").queue();
//            }
        }
        if (content.equals("!join")) {
            Guild guild = event.getGuild();
            Member member = event.getMember();
//            VoiceChannel myChannel = guild.getVoiceChannelById();
        }
        
        if (content.split(" ")[0].equals("!show")) {
            TextChannel tc = event.getTextChannel();
            try{
                URL url = new URL(content.split(" ")[1]);
                BufferedImage img = ImageIO.read(url);
                String imgFormat = url.toString().replaceAll(".*\\.", "").toLowerCase(Locale.ROOT);
                if (!imgFormat.equals("jpg") && !imgFormat.equals("png")){
                    throw new Exception("wrong format (got: "+imgFormat+")");
                }
                File file = new File("temp."+imgFormat);
                ImageIO.write(img, imgFormat, file);
                tc.sendFile(file).append("Success! :)").queue();


            } catch (Exception e) {

                tc.sendMessage("Error while fetching image: ").append(e.toString()).queue();
            }


        }
    }
}
