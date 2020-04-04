package net.kidkoder.allergies.system.data.parser;

import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;
import net.kidkoder.allergies.system.data.DataConfig;
import net.kidkoder.allergies.system.data.parser.file.ConfigFileContents;
import net.minecraft.entity.player.PlayerEntity;

import java.io.File;
import java.util.UUID;

public class DataParser {

    File configLocation;
    PlayerEntity player;
    String playerName;
    UUID uuid;

    public DataParser(File configLocation, PlayerEntity player, String playerName, UUID uuid) {
        this.configLocation = configLocation;
        this.player = player;
        this.playerName = playerName;
        this.uuid = uuid;
    }

    public File getConfigLocation() {
        return configLocation;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public DataConfig parseData() {
        return null;
    }

    public static String[] createFileContent(PlayerAllergies allergies, PlayerAsthma asthma) {
        return new ConfigFileContents(asthma, allergies).createNewFileContents();
    }

}
