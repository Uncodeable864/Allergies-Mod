package net.kidkoder.allergies.object.item;

import net.kidkoder.allergies.init.EffectInit;
import net.kidkoder.allergies.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemAllergyShot extends Item {
    public ItemAllergyShot() {
            super(new Item.Properties().group(ItemInit.allergyRelief).maxStackSize(1));
            setRegistryName("allergy_shot");
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        String name = playerIn.getGameProfile().getName();
            String posX = Double.toString(playerIn.getPositionVec().getX());
            String posZ = Double.toString(playerIn.getPositionVec().getZ());
            String msgFinal = "Help! I'm having an allergic reaction at (x=" + posX + ", z=" + posZ + ") Come NOW!";
            StringTextComponent msg = new StringTextComponent(msgFinal);
            worldIn.getClosestPlayer(playerIn.getPositionVec().getX(), playerIn.getPositionVec().getY(), playerIn.getPositionVec().getZ()).sendMessage(msg);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}