package net.kidkoder.allergies.data;

import net.kidkoder.allergies.AllergiesMod;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.AsthmaSeverity;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;
import net.kidkoder.allergies.system.pack.SingleAllergiesAsthmaPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataConfig {

    public DataConfig() {}

    public static void createConfigFileForPlayer(String playerName, World world) {
        //DO NOT Delete: value = im[i,j,k]
       File worldDir = getConfigFile(world, playerName.toLowerCase());
        String worldPath = worldDir.getAbsolutePath();
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
    }

    public static void setFileContents(File file, String[] contents) throws IOException {
        FileWriter writer = new FileWriter(file.getAbsolutePath());
        writer.write(contents[0]);
        writer.write(contents[1]);
        writer.write(contents[2]);
        writer.write(contents[3]);
        writer.write(contents[4]);
    }

    public static File getConfigFile(World world, String playerNameLower) {
        //Get ServerWorld
        ServerWorld serverWorld = world.getServer().func_71218_a(DimensionType.OVERWORLD);
        //Get saves dir
        File worldDir = serverWorld.getSaveHandler().getWorldDirectory();
        //Get world config file
        File configFile = new File(worldDir + "/aaconfig/" + playerNameLower + ".aaconfig");

        return configFile;
    }


    public static SingleAllergiesAsthmaPack decodeConfig(File config, PlayerEntity player) {

        boolean asthmaBool = false;


        PlayerAsthma asthma;

        PlayerAllergies allergies;

        ArrayList<Allergen> allergensArrayList = new ArrayList<>();

        Scanner reader = null;
        try {
            reader = new Scanner(config);
        } catch (FileNotFoundException e) {
            System.err.println("For some reason, the config file could not be found, read the information below.");
            e.printStackTrace();
        }

        if(reader.nextLine().equals("asthma=true")) {
            asthmaBool = true;
        }
        if(asthmaBool) {
            asthma = new PlayerAsthma(player, AsthmaSeverity.INTERMEDIATE);
        } else {
            asthma = new PlayerAsthma(player, AsthmaSeverity.NULL);
        }

        if(reader.nextLine().equals("wheat=true")) {
            allergensArrayList.add(Allergen.WHEAT);
        }
        if(reader.nextLine().equals("gold=true")) {
            allergensArrayList.add(Allergen.GOLD);
        }
        if(reader.nextLine().equals("eggs=true")) {
            allergensArrayList.add(Allergen.EGGS);
        }
        if(reader.nextLine().equals("milk=true")) {
            allergensArrayList.add(Allergen.MILK);
        }

        Allergen[] allergens = new Allergen[]{};

        allergens = allergensArrayList.toArray(allergens);

        allergies = new PlayerAllergies(player, allergens);

        return new SingleAllergiesAsthmaPack(allergies, asthma);
    }

}
