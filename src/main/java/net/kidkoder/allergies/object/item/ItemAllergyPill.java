package net.kidkoder.allergies.object.item;

import net.kidkoder.allergies.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class ItemAllergyPill extends Item {
    public ItemAllergyPill() {
        super(new Item.Properties().maxStackSize(1).group(ItemInit.allergyRelief));
        setRegistryName("allergy_pill");

    }
}
