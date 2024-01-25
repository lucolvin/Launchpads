package me.Phoenix;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.List;

public class Launchpads extends JavaPlugin implements Listener, CommandExecutor {
    private Material mat;
    private double height;
    private double distance;
    private List<String> enabledWorlds;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        mat = Material.getMaterial(getConfig().getString("material").toUpperCase());
        height = getConfig().getDouble("height");
        distance = getConfig().getDouble("distance");
        enabledWorlds = getConfig().getStringList("enabledWorlds");
        Bukkit.getLogger().info("---------------------------");
        Bukkit.getLogger().info("         Launchpads v0.2    ");
        Bukkit.getLogger().info("---------------------------");
        // Metrics metrics = new Metrics(this);
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("Launchpads").setExecutor(this);
        getCommand("Launchpads-reload").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Launchpads")) {
            sender.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Launchpads");
            sender.sendMessage(ChatColor.AQUA.toString() + "Version" + ChatColor.WHITE + ": " + ChatColor.GRAY + "v0.2");
            sender.sendMessage(ChatColor.AQUA.toString() + "Developer" + ChatColor.WHITE + ": " + ChatColor.GRAY + "PhoenixL3ader");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("Launchpads-reload")) {
            if (sender.hasPermission("lps.reload")) {
                enabledWorlds.clear();
                reloadConfig();
                enabledWorlds = getConfig().getStringList("enabledWorlds");
                mat = Material.getMaterial(this.getConfig().getString("material").toUpperCase());
                height = this.getConfig().getDouble("height");
                distance = this.getConfig().getDouble("distance");
                sender.sendMessage(ChatColor.GREEN + "Launchpads Configuration Reloaded.");
            }
            return true;
        }
        return true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(enabledWorlds.contains(p.getLocation().getWorld().getName())){
            if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == mat) {
                p.setVelocity(e.getPlayer().getLocation().getDirection().multiply(distance));
                p.setVelocity(new Vector(e.getPlayer().getVelocity().getX(), height, e.getPlayer().getVelocity().getZ()));
            }
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("---------------------------");
        Bukkit.getLogger().info("         Launchpads v0.2     ");
        Bukkit.getLogger().info("---------------------------");
        mat = null;
        height = null;
        distance = null;
        enabledWorlds = null;
    }
}
