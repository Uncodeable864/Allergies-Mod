/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.system.pack;

import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;

import java.util.ArrayList;

public class AsthmaAllergiesPack {

    ArrayList<PlayerAllergies> playerAllergies;
    ArrayList<PlayerAsthma> playerAsthma;
    int indexAl, indexAs;

    public AsthmaAllergiesPack(ArrayList<PlayerAllergies> playerAllergies, ArrayList<PlayerAsthma> playerAsthma, int indexAl, int indexAs) {
        this.playerAllergies = playerAllergies;
        this.playerAsthma = playerAsthma;
        this.indexAl = indexAl;
        this.indexAs = indexAs;
    }

    public int getIndexAl() {
        return indexAl;
    }

    public int getIndexAs() {
        return indexAs;
    }

    public ArrayList<PlayerAllergies> getPlayerAllergies() {
        return playerAllergies;
    }

    public void setPlayerAllergies(ArrayList<PlayerAllergies> playerAllergies, int index) {
        this.playerAllergies = playerAllergies;
        this.indexAl = index;

    }

    public ArrayList<PlayerAsthma> getPlayerAsthma() {
        return playerAsthma;

    }

    public void setPlayerAsthma(ArrayList<PlayerAsthma> playerAsthma, int index) {
        this.playerAsthma = playerAsthma;
        this.indexAs = index;
    }

    public PlayerAllergies getPlayerAllergiesClass() {
        return playerAllergies.get(indexAl);
    }
    public PlayerAsthma getPlayerAsthmaClass() {
        return playerAsthma.get(indexAs);
    }
}
