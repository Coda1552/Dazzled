package coda.dazzled.client.model;

import coda.dazzled.Dazzled;
import coda.dazzled.common.entities.GnomeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class GnomeModel extends AnimatedTickingGeoModel<GnomeEntity> {

    @Override
    public ResourceLocation getModelLocation(GnomeEntity object) {
        return new ResourceLocation(Dazzled.MOD_ID, "geo/gnome.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GnomeEntity object) {
        return new ResourceLocation(Dazzled.MOD_ID, "textures/entity/gnome.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GnomeEntity animatable) {
        return new ResourceLocation(Dazzled.MOD_ID, "animations/gnome.animation.json");
    }
}
