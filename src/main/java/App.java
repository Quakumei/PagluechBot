import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        Path fileName = Path.of("target/classes/PagluechBot_token.txt");
        String BOT_TOKEN = Files.readString(fileName);

        JDA jda = JDABuilder.createDefault(BOT_TOKEN).addEventListeners(new EchoListener()).build();
//        jda.awaitRead().getCategories().get(0).sendMessage("Паглюч активейтед.")
//                .timeout(5, TimeUnit.SECONDS)
//                .submit();
    }
}

