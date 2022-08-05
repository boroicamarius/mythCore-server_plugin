package com.myth.mythologicalcore;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public final class MythologicalCore extends JavaPlugin implements Listener {

    Random random = new Random();
    private ArrayList<String> MythColors = new ArrayList<String>(){{
        add("#845ec2");
        add("#d65db1");
        add("#ff6f91");
        add("#ff9671");
        add("#ffc75f");
        add("#f9f871");
    }};
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("summonmjolnir").setExecutor(new summonMjolnir());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    private void onMjolnirAttack(EntityDamageByEntityEvent event){

        if (((event.getDamager() instanceof Player)) && ((event.getEntity() instanceof Player))) {
            Player attacker = ((Player) event.getDamager()).getPlayer();
            Player defender = ((Player) event.getEntity()).getPlayer();

            if(!attacker.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("Myth--Mjolnir"))
                return;

            defender.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*3 , 5));
            defender.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20*3 , 5));
            defender.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3 , 5));

            Bukkit.getWorld(defender.getWorld().getName()).spawnParticle(Particle.EXPLOSION_LARGE,defender.getLocation(),3);
            Bukkit.getWorld(defender.getWorld().getName()).spawnEntity(defender.getLocation(), EntityType.LIGHTNING);
        }
    }
}
