package com.kyanite.nitro.nitros_twinblades;

import com.kyanite.nitro.nitros_twinblades.registry.items.NTItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NitrosTwinblades.MODID)
public class NitrosTwinblades {
    public static final String MODID = "nitros_twinblades";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NitrosTwinblades() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        NTItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
