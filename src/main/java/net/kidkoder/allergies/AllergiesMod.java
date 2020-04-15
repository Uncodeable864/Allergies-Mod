

/*
 * Koded by Kid Koder :)
 *
 *  % : ° ° : %
 *       O
 */

package net.kidkoder.allergies;


import net.kidkoder.allergies.capability.allergies.AllergiesFactory;
import net.kidkoder.allergies.capability.allergies.AllergiesStorage;
import net.kidkoder.allergies.capability.allergies.IAllergies;
import net.kidkoder.allergies.system.Events;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
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
        MinecraftForge.EVENT_BUS.register(Events.class);
    }

    private void clientSetup(FMLClientSetupEvent event) {}

    private void commonSetup(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IAllergies.class, new AllergiesStorage(), new AllergiesFactory());
    }


}
