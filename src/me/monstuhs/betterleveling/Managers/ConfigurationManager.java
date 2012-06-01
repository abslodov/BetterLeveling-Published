/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import me.monstuhs.betterleveling.Utilities.PlugginLogging;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class ConfigurationManager {
    private static JavaPlugin _plugin;
    private static FileConfiguration _configFile;

    /**
     * @return the _configFile
     */
    public FileConfiguration getConfigFile() {
        return _configFile;
    }
    
    public ConfigurationManager(JavaPlugin thisPlugin){
        _plugin = thisPlugin;
        _configFile = _plugin.getConfig();
        createOrLoadConfig();
    }
    
    private void createOrLoadConfig() {
        PlugginLogging.WriteMessageToConsole("Creating/loading config");        
        _configFile.options().copyDefaults(true);
        
        _configFile.addDefault(ConfigConstants.GlobalSettings.WORLD_NAME, _plugin.getServer().getWorlds().get(0).getName());

        _configFile.addDefault(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_DOUBLE_DROP, 1.0);
        _configFile.addDefault(ConfigConstants.MiningActivities.ACTIVITY_MINING_PpL_INSTABREAK, 1.0);
        
        _configFile.addDefault(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_DODGE, 2.0);
        _configFile.addDefault(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_CRIT, 2.0);
        
        _configFile.addDefault(ConfigConstants.PassiveActivities.ACTIVITY_PASSIVE_REGEN_DELAY, 20);
        _configFile.addDefault(ConfigConstants.PassiveActivities.ACTIVITY_PASSIVE_REGEN_HH_PER_LEVEL, 0.5);
        
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_DODGE_MODIFIER, 75);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_CRIT_MODIFIER, 200);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_HEADSHOT_MODIFIER, 200);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_CRIT_CHANCE, 75.0);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_DODGE_CHANCE, 75.0);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTING_DEATH_PERCENTAGE_XP_DROPPED, 100);
        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTING_DEATH_PERCENTAGE_XP_RETAINED, 0);
        
        
        _configFile.addDefault(ConfigConstants.LocalizedMessages.CHANCE_TO_CRIT, "Chance To Crit");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.CHANCE_TO_DODGE, "Chance To Dodge");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.CHANCE_TO_DOUBLEDROP, "Chance To Double-Drop");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.CHANCE_TO_INSTABREAK, "Chance To Insta-Break");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.EXTRA_REGEN, "Extra Regen Per Second");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.CRITICAL_HIT, "Critical Hit!");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.DODGE, "Dodge!");
        _configFile.addDefault(ConfigConstants.LocalizedMessages.HEADSHOT, "Headshot!");
        
        _plugin.saveConfig();
    }
}
