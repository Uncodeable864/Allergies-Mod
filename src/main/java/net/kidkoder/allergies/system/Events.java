package net.kidkoder.allergies.system;

import net.kidkoder.allergies.AllergiesMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.nio.file.Path;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Events {

    SystemAssignment assignment = new SystemAssignment();

    @SubscribeEvent
    public void newPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        AllergiesMod.LOGGER.debug("newPLayerJoinWorldEvent(EntityJoinWorldEvent) started, get instance");
        PlayerEntity playerEntity = event.getPlayer();
        World world = event.getPlayer().getEntityWorld();
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
