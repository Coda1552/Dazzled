package coda.overtherainbow.registry;

import coda.overtherainbow.OverTheRainbow;
import coda.overtherainbow.common.blocks.entities.GnomeHomeBlockEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.extensions.IForgeBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OTRBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, OverTheRainbow.MOD_ID);

    public static final RegistryObject<BlockEntityType<?>> GNOME_HOME = BLOCK_ENTITIES.register("gnome_home", () -> BlockEntityType.Builder.of(GnomeHomeBlockEntity::new, OTRBlocks.GNOME_HOME.get()).build(null));
}
