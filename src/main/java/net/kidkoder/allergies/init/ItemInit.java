package net.kidkoder.allergies.init;

import net.kidkoder.allergies.AllergiesMod;
import net.kidkoder.allergies.group.GroupAllergyRelief;
import net.kidkoder.allergies.object.item.ItemAllergyPill;
import net.kidkoder.allergies.object.item.ItemAllergyShot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    public static ItemGroup allergyRelief = new GroupAllergyRelief();

    public static Item ALLERGY_SHOT;
    public static Item ALLERGY_PILL;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(

                ALLERGY_SHOT = new ItemAllergyShot(),
                ALLERGY_PILL = new ItemAllergyPill()

        );


        AllergiesMod.LOGGER.debug("Items registered successfully! Yay");
    }

}
