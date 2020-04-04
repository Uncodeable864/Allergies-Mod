package net.kidkoder.allergies.system.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class DataPlayerAsthma extends WorldSavedData {
    public DataPlayerAsthma() {
        super("playerDataAllergies");
    }

    @Override
    public void read(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return null;
    }
}
