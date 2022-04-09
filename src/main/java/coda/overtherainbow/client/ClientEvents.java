package coda.overtherainbow.client;

import coda.overtherainbow.OverTheRainbow;
import coda.overtherainbow.client.render.GnomeRenderer;
import coda.overtherainbow.client.render.OgreRenderer;
import coda.overtherainbow.registry.OTREntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD, modid = OverTheRainbow.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(OTREntities.OGRE.get(), OgreRenderer::new);
        EntityRenderers.register(OTREntities.GNOME.get(), GnomeRenderer::new);
    }

    // RenderLivingEvent
}
