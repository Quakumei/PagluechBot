import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        String BOT_TOKEN = "OTQ1Mzc5NTUzMTQ3MjUyNzQ2.YhPTUQ.B13N400DciojUWtSFvU8rTIp53E";
        JDA jda = JDABuilder.createDefault(BOT_TOKEN).addEventListeners(new EchoListener()).build();
//        jda.awaitRead().getCategories().get(0).sendMessage("Паглюч активейтед.")
//                .timeout(5, TimeUnit.SECONDS)
//                .submit();
    }
}

