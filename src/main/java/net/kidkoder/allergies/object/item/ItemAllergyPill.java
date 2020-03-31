package net.kidkoder.allergies.object.item;

import net.kidkoder.allergies.init.ItemInit;
import net.kidkoder.allergies.potion.effect.EffectAllergicReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class ItemAllergyPill extends Item {
    public ItemAllergyPill() {
        super(new Item.Properties().maxStackSize(1).group(ItemInit.allergyRelief));
        setRegistryName("allergy_pill");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        playerIn.addPotionEffect(new EffectInstance(new EffectAllergicReaction()));
        
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
