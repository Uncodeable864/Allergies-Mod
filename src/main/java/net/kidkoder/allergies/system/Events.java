/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.system;

import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Events {

    SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public void newPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();

        IAllergies allergies = (IAllergies) player.getCapability(AllergiesProvider.ALLERGIES_CAP);

        if(allergies.rolled()) {
            StringTextComponent text = new StringTextComponent("Loaded allergies");
            player.sendStatusMessage(text, true);
        } if(!allergies.rolled()) {
            assignment.roll(player, player.getEntityWorld());
            StringTextComponent text = new StringTextComponent("Allergies rolled");
            player.sendStatusMessage(text, true);
        }

    }

    @SubscribeEvent
    public void playerClone(PlayerEvent.Clone event) {
        /*

       Transfer Capability
         */
        PlayerEntity newPlayer = event.getPlayer();
        IAllergies allergies = (IAllergies) newPlayer.getCapability(AllergiesProvider.ALLERGIES_CAP);
        IAllergies oldAllergies = (IAllergies) event.getOriginal().getCapability(AllergiesProvider.ALLERGIES_CAP, null);

        allergies.setAllergens(oldAllergies.getAllergens());

    }

}
