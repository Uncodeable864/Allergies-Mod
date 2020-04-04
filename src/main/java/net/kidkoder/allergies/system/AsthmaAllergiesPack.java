package net.kidkoder.allergies.system;

import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;

import java.util.ArrayList;

public class AsthmaAllergiesPack {

    ArrayList<PlayerAllergies> playerAllergies = new ArrayList<>();
    ArrayList<PlayerAsthma> playerAsthma = new ArrayList<>();

    public AsthmaAllergiesPack(ArrayList<PlayerAllergies> playerAllergies, ArrayList<PlayerAsthma> playerAsthma) {
        this.playerAllergies = playerAllergies;
        this.playerAsthma = playerAsthma;
    }

    public ArrayList<PlayerAllergies> getPlayerAllergies() {
        return playerAllergies;
    }

    public void setPlayerAllergies(ArrayList<PlayerAllergies> playerAllergies) {
        this.playerAllergies = playerAllergies;
    }

    public ArrayList<PlayerAsthma> getPlayerAsthma() {
        return playerAsthma;
    }

    public void setPlayerAsthma(ArrayList<PlayerAsthma> playerAsthma) {
        this.playerAsthma = playerAsthma;
    }
}
