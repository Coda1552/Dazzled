package coda.overtherainbow;

import coda.overtherainbow.common.entities.GnomeEntity;
import coda.overtherainbow.common.entities.OgreEntity;
import coda.overtherainbow.registry.OTRBlocks;
import coda.overtherainbow.registry.OTREntities;
import coda.overtherainbow.registry.OTRItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(OverTheRainbow.MOD_ID)
public class OverTheRainbow  {
    public static final String MOD_ID = "overtherainbow";
    public final static CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(OTRBlocks.GNOME_HOME.get().asItem());
        }
    };

    public OverTheRainbow() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::registerEntityAttributes);

        OTRItems.ITEMS.register(bus);
        OTREntities.ENTITIES.register(bus);
        OTRBlocks.BLOCKS.register(bus);

        GeckoLib.initialize();
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(OTREntities.OGRE.get(), OgreEntity.createAttributes().build());
        event.put(OTREntities.GNOME.get(), GnomeEntity.createAttributes().build());
    }
}
