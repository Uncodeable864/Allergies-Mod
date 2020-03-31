package net.kidkoder.allergies.init;

import net.kidkoder.allergies.effect.EffectAllergicReaction;
import net.kidkoder.allergies.effect.EffectEpinephrine;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EffectInit {

        public static Effect EFFECT_ALLERGIC_REACTION;
        public static Effect EFFECT_EPINEPHRINE;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Effect> event) {

        event.getRegistry().registerAll(

                EFFECT_ALLERGIC_REACTION = new EffectAllergicReaction(),
                EFFECT_EPINEPHRINE = new EffectEpinephrine()
        );

    }
}
