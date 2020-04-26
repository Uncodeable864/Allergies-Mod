/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.system;

import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.kidkoder.allergies.command.GetAllergiesCommand;
import net.kidkoder.allergies.command.TestForAllergyCommand;
import net.kidkoder.allergies.data.DataConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import java.io.File;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class Events {

    static SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public static void newPlayerJoinWorldEvent(PlayerEvent.PlayerLoggedInEvent event) {
        //Get player
        PlayerEntity player = event.getPlayer();
        //Get world
        World world = player.getEntityWorld();
        //Locate the possible allergies if
        File possibleFile = DataConfig.getConfigFile(world, player.getDisplayName().getFormattedText().toLowerCase());

        if(!possibleFile.exists()) {
            assignment.roll(player, world, possibleFile);
            player.sendMessage(new StringTextComponent("Rolled allergies"));
        } else {
            player.sendMessage(new StringTextComponent("Loaded allergies"));
        }

    }

    @SubscribeEvent
    public static void playerClone(PlayerEvent.Clone event) {
        /**
       Transfer Capability
         */
        PlayerEntity player = event.getPlayer();
        IAllergies allergies = player.getCapability(AllergiesProvider.ALLERGIES_CAP).orElseThrow(() -> new RuntimeException("Capabily for allergies SHOULD NOT BE EMTPY(Events.java:56)"));

        IAllergies oldAllergies = event.getOriginal().getCapability(AllergiesProvider.ALLERGIES_CAP).orElseThrow(() ->
                new RuntimeException("Capability for allergies SHOULD NOT BE EMPTY(Events.java:59)")
        );

        allergies.setAllergens(oldAllergies.getAllergens());

    }


    @SubscribeEvent
    public static void onServerStarting(final FMLServerStartingEvent event) {
        GetAllergiesCommand.register(event.getCommandDispatcher());
        TestForAllergyCommand.register(event.getCommandDispatcher());
    }


}
