package net.kidkoder.allergies.effect;


import net.minecraft.potion.Effect;
import net.kidkoder.allergies.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.EffectType;

public class EffectEpinephrine extends Effect {
    public EffectEpinephrine() {
        super(EffectType.BENEFICIAL, 255);
        setRegistryName("epinephrine");
    }

    @Override
    public void applyAttributesModifiersToEntity(LivingEntity entity, AbstractAttributeMap attributeMapIn, int amplifier) {
        entity.removeActivePotionEffect(EffectInit.EFFECT_ALLERGIC_REACTION);
        super.applyAttributesModifiersToEntity(entity, attributeMapIn, amplifier);
    }

    @Override
    public boolean isInstant() {
        return true;
    }

}