package net.kidkoder.allergies.potion.effect;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectAllergicReaction extends Effect {
    public EffectAllergicReaction() {
        super(EffectType.HARMFUL, 255);
        setRegistryName("allergic_reaction");
    }
}
