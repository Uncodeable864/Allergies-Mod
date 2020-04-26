package net.kidkoder.allergies.system;

import net.kidkoder.allergies.data.DataConfig;
import net.kidkoder.allergies.data.parser.file.ConfigFileContents;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.AsthmaSeverity;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;
import net.kidkoder.allergies.system.pack.AsthmaAllergiesPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SystemAssignment {

    ArrayList<PlayerAllergies> playerAllergies = new ArrayList<>();
    ArrayList<PlayerAsthma> playerAsthma = new ArrayList<>();
    AsthmaAllergiesPack pack;
    Allergen[] allergens = new Allergen[3];


    public void roll(PlayerEntity player, World world, File configFile) {
        PlayerAsthma asthma;
        PlayerAllergies allergies;
        Random r = new Random();
        String playerName = player.getName().getString();
        int allergyInt = r.nextInt(14);
        int asthmaInt = r.nextInt(13);
        boolean hasAllergy = false;
        boolean hasAsthma = false;

        if(allergyInt == 1) {
            hasAllergy = true;
        }
        if(asthmaInt == 1) {
            hasAsthma = true;
        }
        if(hasAllergy) {
            int hasMultipleInt = r.nextInt(11);
            boolean hasMultipleAllergens = false;
            if(hasMultipleInt == 0 || hasMultipleInt == 1 || hasMultipleInt == 2 || hasMultipleInt == 3) {
                hasMultipleAllergens = true;
            }
            int allergensAmount = r.nextInt(3) + 1;
            for (int i = 0; i < allergensAmount; i++) {
                int index = r.nextInt(5);
                Allergen allergen = getAllergenFromIndex(index);
                if(!allergenIsUsed(allergens, allergen)){
                    allergens[i] = allergen;
                }
            }
            allergies = new PlayerAllergies(player, allergens);
        } else {
            allergies = new PlayerAllergies(player, Allergen.NULL);
        }
        if(hasAsthma) {
            int index = r.nextInt(4);
            AsthmaSeverity severity = getSeverityFromIndex(index);
            asthma = new PlayerAsthma(player, severity);
        } else {
            asthma = new PlayerAsthma(player, AsthmaSeverity.NULL);
        }
        ConfigFileContents contentsObj = new ConfigFileContents(asthma, allergies);
        String[] contentList = contentsObj.createNewFileContents();
        try {
            DataConfig.setFileContents(configFile, contentList);
        } catch (IOException e) {
            System.err.println("roll() Failed!");
        }
    }

    public Allergen getAllergenFromIndex(int index) {
        if(index == 0){
            return Allergen.GOLD;
        } else if(index == 1) {
            return Allergen.EGGS;
        } else if(index == 2) {
            return Allergen.WHEAT;
        } else {
            return Allergen.MILK;
        }
    }
    public AsthmaSeverity getSeverityFromIndex(int index) {
        if(index == 0) {
            return AsthmaSeverity.PERSISTENT_MILD;
        } else if(index == 1) {
            return AsthmaSeverity.PERSISTENT_MED;
        } else if(index == 2) {
            return AsthmaSeverity.PERSISTENT_SEVERE;
        } else {
            return AsthmaSeverity.INTERMEDIATE;
        }
    }
    public boolean allergenIsUsed(Allergen[] list, Allergen allergen) {
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(allergen)) {
                return true;
            }
        }
        return false;
    }

}
