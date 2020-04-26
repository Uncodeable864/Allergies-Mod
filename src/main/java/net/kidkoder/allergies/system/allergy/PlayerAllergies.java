package net.kidkoder.allergies.system.allergy;

import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerAllergies {

    ArrayList<Allergen> allergens = new ArrayList<>();
    String playerName;

    public PlayerAllergies(PlayerEntity player, Allergen... allergen) {
        Collections.addAll(allergens, allergen);
        playerName = player.getName().getString();
    }

    public ArrayList<Allergen> getAllergens() {
        return allergens;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Allergen getAllergen(int index) {
        return allergens.get(index);
    }

    public boolean hasAllergen(Allergen allergen) {
        return allergens.contains(allergen);
    }

    public int allergenAmount() {
        return allergens.size();
    }

    public boolean hasAllergies() {
        ArrayList<Allergen> allergenNulled = new ArrayList<>();

        allergenNulled.add(0, Allergen.NULL);

        if (allergens.equals(allergenNulled)) {
            return false;
        } else {
            return true;
        }
    }


}
