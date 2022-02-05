package coda.dazzled.registry;

import coda.dazzled.Dazzled;
import coda.dazzled.common.entities.GnomeEntity;
import coda.dazzled.common.entities.OgreEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DazzledEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Dazzled.MOD_ID);

    public static final RegistryObject<EntityType<OgreEntity>> OGRE = create("ogre", EntityType.Builder.of(OgreEntity::new, MobCategory.CREATURE).sized(1.25F, 2.85F));
    public static final RegistryObject<EntityType<GnomeEntity>> GNOME = create("gnome", EntityType.Builder.of(GnomeEntity::new, MobCategory.CREATURE).sized(0.4F, 0.65F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(Dazzled.MOD_ID + "." + name));
    }
}