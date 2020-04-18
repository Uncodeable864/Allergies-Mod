/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.capability.allergies;

import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class AllergiesStorage implements Capability.IStorage<IAllergies> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IAllergies> capability, IAllergies instance, Direction side) {

        CompoundNBT tag = new CompoundNBT();
        
        tag.putBoolean("gold", instance.getAllergens().hasAllergen(Allergen.GOLD));

        tag.putBoolean("eggs", instance.getAllergens().hasAllergen(Allergen.EGGS));

        tag.putBoolean("wheat", instance.getAllergens().hasAllergen(Allergen.WHEAT));

        tag.putBoolean("milk", instance.getAllergens().hasAllergen(Allergen.MILK));
        
        return tag;
    }

    @Override
    public void readNBT(Capability<IAllergies> capability, IAllergies instance, Direction side, INBT nbt) {

        CompoundNBT tag = (CompoundNBT) nbt;

        PlayerAllergies allergies;

        Allergen[] allergens = new Allergen[]{};

        boolean gold = tag.getBoolean("gold");

        boolean eggs = tag.getBoolean("eggs");

        boolean wheat = tag.getBoolean("wheat");

        boolean milk = tag.getBoolean("milk");

        for (int i = 0; i < 4; i++) {

            Allergen currentAllergen = Allergen.intToAllergen(i);

            if(currentAllergen != null) {
                if(currentAllergen.equals(Allergen.GOLD) && gold) {
                    allergens[i] = Allergen.GOLD;
                } else if (currentAllergen.equals(Allergen.EGGS) && eggs) {
                    allergens[i] = Allergen.EGGS;
                } else if (currentAllergen.equals(Allergen.MILK) && milk) {
                    allergens[i] = Allergen.MILK;
                } else if (currentAllergen.equals(Allergen.WHEAT) && wheat) {
                    allergens[i] = Allergen.WHEAT;
                }
            }

        }

        allergies = new PlayerAllergies(capability.getDefaultInstance().getPlayer(), allergens);

        instance.setAllergens(allergies);
    }
}
