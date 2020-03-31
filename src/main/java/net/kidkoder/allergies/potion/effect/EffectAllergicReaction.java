package net.kidkoder.allergies.potion.effect;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

import javax.annotation.Nullable;

public class EffectAllergicReaction extends Effect {
    public EffectAllergicReaction() {
        super(EffectType.HARMFUL, 255);
        setRegistryName("allergic_reaction");
}

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entityLivingBaseIn, int amplifier, double health) {
        super.affectEntity(source, indirectSource, entityLivingBaseIn, amplifier, health);
    }
}