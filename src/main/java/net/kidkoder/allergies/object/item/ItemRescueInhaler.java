package net.kidkoder.allergies.object.item;

import net.kidkoder.allergies.init.ItemInit;
import net.minecraft.item.Item;

public class ItemRescueInhaler extends Item {
    public ItemRescueInhaler() {
        super(new Properties().group(ItemInit.allergyRelief));
        setRegistryName("inhaler_normal");
    }
}
