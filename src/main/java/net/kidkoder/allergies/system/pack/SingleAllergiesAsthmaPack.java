/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.system.pack;

import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;

public class SingleAllergiesAsthmaPack {

    private PlayerAllergies allergies;

    private PlayerAsthma asthma;

    public SingleAllergiesAsthmaPack(PlayerAllergies allergies, PlayerAsthma asthma) {
        this.allergies = allergies;
        this.asthma = asthma;
    }

    public PlayerAllergies getAllergies() {
        return allergies;
    }

    public PlayerAsthma getAsthma() {
        return asthma;
    }
}
