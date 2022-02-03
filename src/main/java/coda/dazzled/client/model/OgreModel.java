package coda.dazzled.client.model;

import coda.dazzled.Dazzled;
import coda.dazzled.common.entities.OgreEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class OgreModel extends AnimatedTickingGeoModel<OgreEntity> {

    @Override
    public ResourceLocation getModelLocation(OgreEntity object) {
        return new ResourceLocation(Dazzled.MOD_ID, "geo/ogre.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(OgreEntity object) {
        return new ResourceLocation(Dazzled.MOD_ID, "textures/entity/ogre.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(OgreEntity animatable) {
        return new ResourceLocation(Dazzled.MOD_ID, "animations/ogre.animation.json");
    }
}
