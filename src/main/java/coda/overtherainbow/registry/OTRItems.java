package coda.overtherainbow.registry;

import coda.overtherainbow.OverTheRainbow;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OTRItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OverTheRainbow.MOD_ID);

    public static final RegistryObject<Item> OGRE_SPAWN_EGG = ITEMS.register("ogre_spawn_egg", () -> new ForgeSpawnEggItem(OTREntities.OGRE, 0x534a2b, 0x3a291e, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GNOME_SPAWN_EGG = ITEMS.register("gnome_spawn_egg", () -> new ForgeSpawnEggItem(OTREntities.GNOME, 0x464c9d, 0x6d3637, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
