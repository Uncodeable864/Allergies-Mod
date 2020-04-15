/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.capability;

import net.kidkoder.allergies.AllergiesMod;
import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation ALLERGIES_LOC = new ResourceLocation(AllergiesMod.MODID, "allergies");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        event.addCapability(ALLERGIES_LOC, new AllergiesProvider());
    }
}
