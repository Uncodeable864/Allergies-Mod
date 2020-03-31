package net.kidkoder.allergies.object.item;

import net.kidkoder.allergies.init.ItemInit;
import net.minecraft.item.Item;

public class ItemNormalInhaler extends Item {
    public ItemNormalInhaler() {
        super(new Item.Properties().group(ItemInit.allergyRelief));
        setRegistryName("inhaler_normal");
    }
}
