package net.kidkoder.allergies.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectAsthmaAttack extends Effect {

    public EffectAsthmaAttack() {
        super(EffectType.HARMFUL, 300);
        setRegistryName("asthma_attack");
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);
    }
}
