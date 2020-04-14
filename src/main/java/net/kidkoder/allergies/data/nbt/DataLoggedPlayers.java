package net.kidkoder.allergies.data.nbt;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class DataLoggedPlayers extends WorldSavedData {

    public static final String USERNAME_TAG = "username";

    CompoundNBT nbt = new CompoundNBT();

    public DataLoggedPlayers() {
        super("loggedIn");
    }

    @Override
    public void read(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {

        addPlayer(nbt);
        markDirty();
        return nbt;
    }

    private void addPlayer(CompoundNBT nbt) {
    }

}
