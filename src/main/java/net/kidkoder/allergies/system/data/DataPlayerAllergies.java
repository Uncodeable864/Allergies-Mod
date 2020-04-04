package net.kidkoder.allergies.system.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class DataPlayerAllergies extends WorldSavedData {
    private boolean dirty;

    public DataPlayerAllergies() {
        super("playerDataAllergies");
    }

    @Override
    public void read(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return null;
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }
}
