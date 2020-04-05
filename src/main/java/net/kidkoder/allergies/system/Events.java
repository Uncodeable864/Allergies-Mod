package net.kidkoder.allergies.system;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
public class Events {
    public void newPlayerJoinWorld(EntityJoinWorldEvent event) {

        if (event.getEntity() instanceof PlayerEntity) {
            
        }

    }
}
