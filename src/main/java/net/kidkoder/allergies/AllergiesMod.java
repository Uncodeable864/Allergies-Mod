package net.kidkoder.allergies;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("allergies")
public class AllergiesMod {

    public static final String MODID = "allergies";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public AllergiesMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

    }

    private void clientSetup(FMLClientSetupEvent event) {}

    private void commonSetup(FMLCommonSetupEvent event) {}

}
