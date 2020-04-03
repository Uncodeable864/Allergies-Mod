package net.kidkoder.allergies.system;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {

        World world = event.getWorld();

    }

}
