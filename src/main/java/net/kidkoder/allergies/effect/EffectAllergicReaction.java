package net.kidkoder.allergies.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
public class EffectAllergicReaction extends Effect {
    public EffectAllergicReaction() {
        super(EffectType.HARMFUL, 255);
        setRegistryName("allergic_reaction");
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {

        entity.setHealth(1);

        super.performEffect(entity, amplifier);
    }
}