package coda.overtherainbow.client.render;

import coda.overtherainbow.client.model.GnomeModel;
import coda.overtherainbow.common.entities.GnomeEntity;
import coda.overtherainbow.common.entities.OgreEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GnomeRenderer extends GeoEntityRenderer<GnomeEntity> {

    public GnomeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GnomeModel());
        this.shadowRadius = 0.15F;
    }

    @Override
    public void render(GnomeEntity entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        if (Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.HEAD).is(Items.DIAMOND_HELMET)) {
            super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
        }
    }
}