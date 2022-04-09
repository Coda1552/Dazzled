package coda.overtherainbow.client.render;

import coda.overtherainbow.client.model.OgreModel;
import coda.overtherainbow.common.entities.OgreEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OgreRenderer extends GeoEntityRenderer<OgreEntity> {

    public OgreRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OgreModel());
        this.shadowRadius = 0.8F;
    }

}