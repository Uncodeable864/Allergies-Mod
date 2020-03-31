package net.kidkoder.allergies.potion.effect;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import javax.annotation.Nullable;

public class EffectAllergicReaction extends Effect {
    public EffectAllergicReaction() {
        super(EffectType.HARMFUL, 255);
        setRegistryName("allergic_reaction");
    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entity, int amplifier, double health) {

        entity.setHealth(1);

        super.affectEntity(source, indirectSource, entity, amplifier, health);
    }
}