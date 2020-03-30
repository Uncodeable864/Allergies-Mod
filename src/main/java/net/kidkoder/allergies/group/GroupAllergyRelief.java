package net.kidkoder.allergies.group;

import net.kidkoder.allergies.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GroupAllergyRelief extends ItemGroup {
    public GroupAllergyRelief()
    {
        super("allergyRelief");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemInit.ALLERGY_SHOT);
    }
}
