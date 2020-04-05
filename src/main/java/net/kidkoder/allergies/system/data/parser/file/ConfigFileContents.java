package net.kidkoder.allergies.system.data.parser.file;

import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.asthma.PlayerAsthma;

public class ConfigFileContents{

     String[] lines = new String[]{};

     PlayerAsthma asthma;
     PlayerAllergies allergies;

    public ConfigFileContents(PlayerAsthma asthma, PlayerAllergies allergies) {
        this.asthma = asthma;
        this.allergies = allergies;
    }

    public String[] createNewFileContents() {
        boolean hasAsthma = asthma.hasAsthma();
        String asthma = "asthma=false\n";
        String wheat = "wheat=false\n";
        String gold = "gold=false\n";
        String milk = "milk=false\n";
        String eggs = "eggs=false";
        //Generate lines
        if(allergies.hasAllergen(Allergen.WHEAT)) {
            wheat = "wheat=true\n";
        }
        if(allergies.hasAllergen(Allergen.GOLD)) {
            gold = "golf=true\n";
        }
        if(allergies.hasAllergen(Allergen.MILK)) {
            milk = "milk=true\n";
        }
        if(allergies.hasAllergen(Allergen.EGGS)) {
            eggs = "eggs=true\n";
        }
        if(hasAsthma) {
            asthma = "asthma=true";
        }
        //Build file contents
        lines[0] = asthma;
        lines[1] = wheat;
        lines[2] = gold;
        lines[3] = milk;
        lines[4] = eggs;
        return lines;
    }
}
