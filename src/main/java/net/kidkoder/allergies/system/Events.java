package net.kidkoder.allergies.system;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.io.File;
import java.nio.file.Path;



public class Events {

    SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public void newPlayerJoinWorld(EntityJoinWorldEvent event) {
    if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            World world = event.getWorld();
            Path loc = Minecraft.getInstance().getSaveLoader().getBackupsFolder();
            File savesFolder = loc.toFile();
            String worldID = world.getProviderName();
            String playerName = playerEntity.getName().getString().toLowerCase();
            File possibleConfigFile = new File(savesFolder.getAbsolutePath() + "/" + worldID + "/aaconfig/" + playerName + ".aaconfig");
            AllergiesMod.LOGGER.debug("Located file & in if statement");
            if(!possibleConfigFile.exists()) {
                assignment.roll(playerEntity, world);
                AllergiesMod.LOGGER.debug("Rolled chances");
            }

        }

    }
}
