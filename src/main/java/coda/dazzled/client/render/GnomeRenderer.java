package coda.dazzled.client.render;

import coda.dazzled.client.model.GnomeModel;
import coda.dazzled.common.entities.GnomeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GnomeRenderer extends GeoEntityRenderer<GnomeEntity> {

    public GnomeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GnomeModel());
        this.shadowRadius = 0.15F;
    }


}