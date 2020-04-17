/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.capability;

import net.kidkoder.allergies.AllergiesMod;
import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityHandler {

    public static final ResourceLocation ALLERGIES_LOC = new ResourceLocation(AllergiesMod.MODID, "allergies");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(ALLERGIES_LOC, new AllergiesProvider());
        }

    }

}
