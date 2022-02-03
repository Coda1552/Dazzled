package coda.dazzled.registry;

import coda.dazzled.Dazzled;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DazzledItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dazzled.MOD_ID);

    public static final RegistryObject<Item> OGRE_SPAWN_EGG = ITEMS.register("ogre_spawn_egg", () -> new ForgeSpawnEggItem(DazzledEntities.OGRE, 0x00000, 0x00FF00, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
