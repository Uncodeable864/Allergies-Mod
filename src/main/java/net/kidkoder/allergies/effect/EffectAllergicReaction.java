package net.kidkoder.allergies.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
public class EffectAllergicReaction extends Effect {
    public EffectAllergicReaction() {
        super(EffectType.HARMFUL, 255);
        setRegistryName("allergic_reaction");
    }

    @Override
    public void applyAttributesModifiersToEntity(LivingEntity entity, AbstractAttributeMap attributeMapIn, int amplifier) {
        while(entity.getHealth() > 0) {
            float newHealth = entity.getHealth() - (4 * amplifier);
            entity.setHealth(newHealth);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.applyAttributesModifiersToEntity(entity, attributeMapIn, amplifier);
    }
}