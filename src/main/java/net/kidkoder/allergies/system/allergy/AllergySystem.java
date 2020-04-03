package net.kidkoder.allergies.system.allergy;

import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.Random;

public class AllergySystem {

    ArrayList<PlayerAllergies> playerAllergies = new ArrayList<>();
    ArrayList<PlayerAsthma> playerAsthma = new ArrayList<>();

    public void roll(PlayerEntity player) {
        Random r = new Random();
        String playerName = player.getName().getString();
        int allergyInt = r.nextInt(14);
        int asthmaInt = r.nextInt(13);
        boolean hasAllergys = false;
        boolean hasAsthma = false;

        if(allergyInt == 1) {
            hasAllergys = true;
        }
        if(asthmaInt == 1) {
            hasAsthma = true;
        }
    }

}
