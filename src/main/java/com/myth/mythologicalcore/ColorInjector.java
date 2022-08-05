package com.myth.mythologicalcore;

import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorInjector {

    private static Pattern pattern = Pattern.compile("<@([-#a-zA-Z0-9]+)\\/(.+?(?=\\())\\((.+?(?=\\)\\/>))\\)\\/>");
    public static String inject(String string){
        Matcher match = pattern.matcher(string);

        while(match.find()){
            String color = match.group(0);
            String _final = ChatColor.of(match.group(1)).toString();
            if(match.group(2).contains("B")) _final +=ChatColor.BOLD.toString();
            if(match.group(2).contains("I")) _final +=ChatColor.ITALIC.toString();
            if(match.group(2).contains("S")) _final +=ChatColor.STRIKETHROUGH.toString();
            if(match.group(2).contains("U")) _final +=ChatColor.UNDERLINE.toString();
            if(match.group(2).contains("M")) _final +=ChatColor.MAGIC.toString();
            string = string.replace(color, _final+match.group(3)+ ChatColor.RESET.toString());
            match = pattern.matcher(string);
        }

        return ChatColor.translateAlternateColorCodes('&',string);
    };

}
