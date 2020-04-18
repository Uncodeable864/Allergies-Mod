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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class Events {

    static SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public static void newPlayerJoinWorldEvent(PlayerEvent.PlayerLoggedInEvent event) {
        //Get player
        PlayerEntity player = event.getPlayer();
        //Get capability
        LazyOptional<IAllergies> allergiesLazyOptional = player.getCapability(AllergiesProvider.ALLERGIES_CAP);
        IAllergies allergies = allergiesLazyOptional.orElseThrow(() -> new RuntimeException("Capabily for allergies SHOULD NOT BE EMPTY(Events.java:34)"));

        //Detect if allergies have been rolled
        if(allergies.rolled()) {
            //Tell player allergies
            StringTextComponent textLoad = new StringTextComponent("Loaded allergies");
            player.sendMessage(textLoad);
        } if(!allergies.rolled()) {
            assignment.roll(player, player.getEntityWorld());
            allergies.setRolled();
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
                new RuntimeException("Capabily for allergies SHOULD NOT BE EMPTY(Events.java:59)")
        );

        allergies.setAllergens(oldAllergies.getAllergens());

    }


    @SubscribeEvent
    public static void onServerStarting(final FMLServerStartingEvent event) {
        GetAllergiesCommand.register(event.getCommandDispatcher());
        TestForAllergyCommand.register(event.getCommandDispatcher());
    }


}
