package org.rofu.nighthubeffects;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public final class NightHubEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("Запущен");

        new BukkitRunnable() {

            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, true, false));
                });
            }

        }.runTaskTimer(this,0,20);

    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Выключен");
    }
}
