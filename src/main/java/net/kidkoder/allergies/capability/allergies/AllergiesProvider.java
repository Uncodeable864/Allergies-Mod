package net.kidkoder.allergies.capability.allergies;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AllergiesProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IAllergies.class)
    public static final Capability<IAllergies> ALLERGIES_CAP = null;

    private IAllergies instance = ALLERGIES_CAP.getDefaultInstance();


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
      return null;
    }



    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return null;
    }

    @Override
    public INBT serializeNBT() {
        return ALLERGIES_CAP.getStorage().writeNBT(ALLERGIES_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        ALLERGIES_CAP.getStorage().readNBT(ALLERGIES_CAP, this.instance, null, nbt);
    }

}
