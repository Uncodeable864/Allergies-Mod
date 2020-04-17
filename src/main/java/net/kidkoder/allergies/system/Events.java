/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.system;

import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.kidkoder.allergies.capability.allergies.CapabilityAllergies;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class Events {

    static SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public static void newPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();

        StringTextComponent textWorked = new StringTextComponent("In the event");
        player.sendMessage(textWorked);

        LazyOptional<IAllergies> allergiesLazyOptional = player.getCapability(AllergiesProvider.ALLERGIES_CAP);
        IAllergies allergies = allergiesLazyOptional.orElseGet(CapabilityAllergies::new);


        if(allergies.rolled()) {
            StringTextComponent textLoad = new StringTextComponent("Loaded allergies");
            player.sendMessage(textLoad);
        } if(!allergies.rolled()) {
            assignment.roll(player, player.getEntityWorld());
            StringTextComponent textRoll = new StringTextComponent("Allergies rolled");
            player.sendMessage(textRoll);
            allergies.setRolled();
            PlayerAllergies playerAllergies = player.getCapability(AllergiesProvider.ALLERGIES_CAP).orElse(new CapabilityAllergies()).getAllergens();
            StringTextComponent allergiesListGold = new StringTextComponent("You are allergic to gold: " + playerAllergies.hasAllergen(Allergen.GOLD));
            player.sendMessage(allergiesListGold);
            StringTextComponent allergiesListWheat = new StringTextComponent("You are allergic to wheat: " + playerAllergies.hasAllergen(Allergen.WHEAT));
            player.sendMessage(allergiesListWheat);
            StringTextComponent allergiesListEggs = new StringTextComponent("You are allergic to eggs: " + playerAllergies.hasAllergen(Allergen.EGGS));
            player.sendMessage(allergiesListEggs);
            StringTextComponent allergiesListMilk = new StringTextComponent("You are allergic to gold: " + playerAllergies.hasAllergen(Allergen.MILK));
            player.sendMessage(allergiesListMilk);
        }


    }

    @SubscribeEvent
    public static void playerClone(PlayerEvent.Clone event) {
        /*
       Transfer Capability
         */
        PlayerEntity newPlayer = event.getPlayer();
        IAllergies allergies = newPlayer.getCapability(AllergiesProvider.ALLERGIES_CAP).orElse(new CapabilityAllergies());
        IAllergies oldAllergies = newPlayer.getCapability(AllergiesProvider.ALLERGIES_CAP).orElse(new CapabilityAllergies());

        allergies.setAllergens(oldAllergies.getAllergens());

    }


}
