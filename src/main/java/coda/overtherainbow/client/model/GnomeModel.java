package coda.overtherainbow.client.model;

import coda.overtherainbow.OverTheRainbow;
import coda.overtherainbow.common.entities.GnomeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class GnomeModel extends AnimatedTickingGeoModel<GnomeEntity> {

    @Override
    public ResourceLocation getModelLocation(GnomeEntity object) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "geo/gnome.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GnomeEntity object) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "textures/entity/gnome.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GnomeEntity animatable) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "animations/gnome.animation.json");
    }
}
