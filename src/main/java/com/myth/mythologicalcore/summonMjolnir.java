package com.myth.mythologicalcore;

import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataContainer;


import java.util.*;

public class summonMjolnir implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack mjolnir= new ItemStack(Material.GOLDEN_AXE);
            ItemMeta meta = mjolnir.getItemMeta();


            meta.setLocalizedName("Myth--Mjolnir");
            meta.setDisplayName(ColorInjector.inject("<@#C0C0C0/M/([)/>"+
                    "<@#e46581/IB/(M)/>" +
                    "<@#f37378/IB/(y)/>" +
                    "<@#fc7b73/IB/(t)/>" +
                    "<@#ff8e6b/IB/(h)/>" +
                    "<@#C0C0C0/M/(])/> <@#FFFFFF//(Mjölnir)/>"));

            meta.setUnbreakable(true);
            meta.addEnchant(Enchantment.LOYALTY,7,true);
            meta.addEnchant(Enchantment.BINDING_CURSE,7,true);
            meta.addEnchant(Enchantment.VANISHING_CURSE,7,true);

            meta.setLore(new ArrayList<String>(){{
                add("Came from the Dwaves.For Odin.");
                add("Whosoever holds this hammer,");
                add("if he be worthy,");
                add("Shall possess the power of Thor");
            }});
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            mjolnir.setItemMeta(meta);

            player.getInventory().addItem(mjolnir);

        }
        return true;
    }

}
