/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.kidkoder.allergies.data.DataConfig;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class TestForAllergyCommand {


    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("allergy-test").then(Commands.argument("allergen", IntegerArgumentType.integer()).executes(source -> {
            return test(source.getSource(), source.getSource().asPlayer(), IntegerArgumentType.getInteger(source, "allergen"));
        })));
    }

    private static int test(CommandSource source, PlayerEntity player, int allergenInt) {
        Allergen allergen = Allergen.intToAllergen(allergenInt);

        boolean hasAllergen = DataConfig.decodeConfig(DataConfig.getConfigFile(player.getEntityWorld(), player.getDisplayName().getFormattedText().toLowerCase()), player).getAllergies().hasAllergen(allergen);


        StringTextComponent msg = new StringTextComponent(Allergen.allergenToString(allergen) + " is " + hasAllergen);

        player.sendMessage(msg);

        return 1;
    }
}
