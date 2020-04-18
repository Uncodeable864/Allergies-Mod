/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.command;

import com.mojang.brigadier.CommandDispatcher;
import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.kidkoder.allergies.capability.allergies.CapabilityAllergies;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;

public class GetAllergiesCommand {


    public static void register(CommandDispatcher<CommandSource> dispatcher) {

        dispatcher.register(Commands.literal("getallergies").requires(context -> {
            return context.hasPermissionLevel(2);
        }).executes(source -> {
            return getAllergies(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player())).executes(source -> {
            return getAllergies(source.getSource(), EntityArgument.getPlayer(source, "target"));
        }));

    }

    public static int getAllergies(CommandSource source, PlayerEntity player) {
        LazyOptional<IAllergies> allergiesLazyOptional = player.getCapability(AllergiesProvider.ALLERGIES_CAP);
        IAllergies iAllergies = allergiesLazyOptional.orElseGet(CapabilityAllergies::new);
        PlayerAllergies allergies = iAllergies.getAllergens();

        String hasGold = Boolean.toString(allergies.hasAllergen(Allergen.GOLD));
        StringTextComponent gold = new StringTextComponent("Gold: " + hasGold);
        player.sendMessage(gold);

        String hasEggs = Boolean.toString(allergies.hasAllergen(Allergen.EGGS));
        StringTextComponent eggs = new StringTextComponent("Gold: " + hasEggs);
        player.sendMessage(eggs);

        String hasWheat = Boolean.toString(allergies.hasAllergen(Allergen.WHEAT));
        StringTextComponent wheat = new StringTextComponent("Wheat: " + hasWheat);
        player.sendMessage(wheat);

        String hasMilk = Boolean.toString(allergies.hasAllergen(Allergen.MILK));
        StringTextComponent milk = new StringTextComponent("Wheat: " + hasMilk);
        player.sendMessage(milk);

        return 1;
    }


}
