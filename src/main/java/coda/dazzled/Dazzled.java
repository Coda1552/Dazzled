package coda.dazzled;

import coda.dazzled.common.entities.GnomeEntity;
import coda.dazzled.common.entities.OgreEntity;
import coda.dazzled.registry.DazzledEntities;
import coda.dazzled.registry.DazzledItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(Dazzled.MOD_ID)
public class Dazzled {
    public static final String MOD_ID = "dazzled";

    public Dazzled() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::registerEntityAttributes);

        DazzledItems.ITEMS.register(bus);
        DazzledEntities.ENTITIES.register(bus);

        GeckoLib.initialize();
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(DazzledEntities.OGRE.get(), OgreEntity.createAttributes().build());
        event.put(DazzledEntities.GNOME.get(), GnomeEntity.createAttributes().build());
    }
}
