package net.kidkoder.allergies.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectAsthmaAttack extends Effect {

    public EffectAsthmaAttack() {
        super(EffectType.HARMFUL, 15511700);
        setRegistryName("asthma_attack");
    }

}
