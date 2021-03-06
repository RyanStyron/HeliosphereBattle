package mc.rysty.heliospherebattle.utils.filemanagers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PlayerDataFileManager {

    private static PlayerDataFileManager instance = new PlayerDataFileManager();

    public static PlayerDataFileManager getInstance() {
        return instance;
    }

    private FileConfiguration data;
    private File dataFile;

    public void setup(Plugin plugin) {
        if (!plugin.getDataFolder().exists())
            plugin.getDataFolder().mkdir();
        dataFile = new File(plugin.getDataFolder(), "playerdata.yml");

        if (!dataFile.exists())
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
            }
        data = YamlConfiguration.loadConfiguration(dataFile);
    }

    public FileConfiguration getData() {
        return data;
    }

    public void saveData() {
        try {
            data.save(dataFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save playerdata.yml!");
        }
    }

    public void reloadData() {
        data = YamlConfiguration.loadConfiguration(dataFile);
    }
}