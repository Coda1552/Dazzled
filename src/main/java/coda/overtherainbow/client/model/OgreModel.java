package coda.overtherainbow.client.model;

import coda.overtherainbow.OverTheRainbow;
import coda.overtherainbow.common.entities.OgreEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class OgreModel extends AnimatedTickingGeoModel<OgreEntity> {

    @Override
    public ResourceLocation getModelLocation(OgreEntity object) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "geo/ogre.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(OgreEntity object) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "textures/entity/ogre.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(OgreEntity animatable) {
        return new ResourceLocation(OverTheRainbow.MOD_ID, "animations/ogre.animation.json");
    }

    @Override
    public void setLivingAnimations(OgreEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);

        IBone root = this.getAnimationProcessor().getBone("root");

        root.setScaleX(1.35F);
        root.setScaleY(1.35F);
        root.setScaleZ(1.35F);
        root.setPositionY(4.5F);
    }
}
