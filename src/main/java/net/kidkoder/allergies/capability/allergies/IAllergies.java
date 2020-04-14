package net.kidkoder.allergies.capability.allergies;

import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.minecraft.entity.player.PlayerEntity;

/*
Interface to use for a Capability for ALLERGIES only.
Allergen storage capability
 */

public interface IAllergies {

    PlayerAllergies getAllergens();

    boolean hasAllergies();

    void setAllergens(PlayerAllergies allergens);

    PlayerEntity getPlayer();

    void setPlayer(PlayerEntity player);

}
