/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.kidkoder.allergies.capability.allergies.AllergiesProvider;
import net.kidkoder.allergies.capability.allergies.CapabilityAllergies;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.kidkoder.allergies.system.allergy.Allergen;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;

public class TestForAllergyCommand {


    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("allergy-test").then(Commands.argument("allergen", IntegerArgumentType.integer()).executes(source -> {
            return test(source.getSource(), source.getSource().asPlayer(), IntegerArgumentType.getInteger(source, "allergen"));
        })));
    }

    private static int test(CommandSource source, ServerPlayerEntity player, int allergenInt) {
        Allergen allergen = Allergen.intToAllergen(allergenInt);
        LazyOptional<IAllergies> allergiesLazyOptional = player.getCapability(AllergiesProvider.ALLERGIES_CAP);
        IAllergies allergies = allergiesLazyOptional.orElseGet(CapabilityAllergies::new);
        String has = Boolean.toString(allergies.getAllergens().hasAllergen(allergen));
        String allergenString = Allergen.allergenToString(allergen);
        source.sendFeedback(new TranslationTextComponent("commands.testAllergy.run", allergenString,has), true);
        return 1;
    }
}
