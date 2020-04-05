package net.kidkoder.allergies.system.data;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class DataConfig {

    public DataConfig() {}

    public static File createConfigFileForPlayer(String playerName, String worldID) {
        //DO NOT Delete: value = im[i,j,k]
        Path loc = Minecraft.getInstance().getSaveLoader().getBackupsFolder();
        File savesFolder = loc.toFile();
        File worldFolder = new File(savesFolder.getAbsolutePath() + "/" + worldID);
        String worldPath = worldFolder.getAbsolutePath();
        File configLocationFolder = new File(worldPath + "/aaconfig");
        if (configLocationFolder.mkdir()) {
        try {
            configLocationFolder.createNewFile();
        } catch (IOException e) {
            AllergiesMod.LOGGER.error("mkdir() failed!");
            AllergiesMod.LOGGER.error("Game may crash! Beware");
            e.printStackTrace();
        }
        }
        String playerNameLower = playerName.toLowerCase();
        String configFolderPath = configLocationFolder.getAbsolutePath();
        File playerConfig = new File(configFolderPath + "/"+ playerNameLower + ".aaconfig");
        try {
            playerConfig.createNewFile();
        } catch (IOException e) {
            AllergiesMod.LOGGER.error("createNewFile() failed!");
            AllergiesMod.LOGGER.error("Game may crash! Beware");
            e.printStackTrace();
        }
        return playerConfig;
    }

    public static void setFileContents(File file, String[] contents) throws IOException {
        FileWriter writer = new FileWriter(file.getAbsolutePath());
        writer.write(contents[0]);
        writer.write(contents[1]);
        writer.write(contents[2]);
        writer.write(contents[3]);
        writer.write(contents[4]);
    }

}
