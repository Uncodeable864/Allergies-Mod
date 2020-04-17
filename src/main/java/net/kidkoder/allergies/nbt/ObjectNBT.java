package net.kidkoder.allergies.nbt;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.INBTType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.io.DataOutput;

public class ObjectNBT implements INBT {

    public Object object;

    public ObjectNBT(Object object) {
        this.object = object;
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public void write(DataOutput output) {}

    @Override
    public byte getId() {
        return 0;
    }

    @Override
    public INBTType<?> func_225647_b_() {
        return null;
    }

    @Override
    public INBT copy() {
        return null;
    }

    @Override
    public ITextComponent toFormattedComponent(String indentation, int indentDepth) {
        return new StringTextComponent(indentation + indentDepth);
    }
}
