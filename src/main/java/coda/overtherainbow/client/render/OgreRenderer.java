package coda.overtherainbow.client.render;

import coda.overtherainbow.client.model.OgreModel;
import coda.overtherainbow.common.entities.OgreEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OgreRenderer extends GeoEntityRenderer<OgreEntity> {

    public OgreRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OgreModel());
        this.shadowRadius = 0.8F;
    }

    @Override
    public RenderType getRenderType(OgreEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityCutout(textureLocation);
    }
}