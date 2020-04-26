/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.command;

import com.mojang.brigadier.CommandDispatcher;
import net.kidkoder.allergies.data.DataConfig;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.kidkoder.allergies.system.allergy.PlayerAllergies;
import net.kidkoder.allergies.system.pack.SingleAllergiesAsthmaPack;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

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

        World world = player.getEntityWorld();

        SingleAllergiesAsthmaPack pack = DataConfig.decodeConfig(DataConfig.getConfigFile(world, player.getDisplayName().getFormattedText().toLowerCase()), player);

        PlayerAllergies allergies = pack.getAllergies();

        StringTextComponent gold = new StringTextComponent("Gold: " + allergies.hasAllergen(Allergen.GOLD));
        player.sendMessage(gold);

        StringTextComponent eggs = new StringTextComponent("Eggs: " + allergies.hasAllergen(Allergen.EGGS));
        player.sendMessage(eggs);

        StringTextComponent wheat = new StringTextComponent("Wheat: " + allergies.hasAllergen(Allergen.WHEAT));
        player.sendMessage(wheat);

        StringTextComponent milk = new StringTextComponent("Milk: " + allergies.hasAllergen(Allergen.MILK));
        player.sendMessage(milk);



        return 1;
    }


}
