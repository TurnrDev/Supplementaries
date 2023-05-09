package net.mehvahdjukaar.supplementaries.client.tooltip;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.mehvahdjukaar.supplementaries.client.BlackboardManager;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlackboardTooltipComponent implements ClientTooltipComponent {

    private static final int SIZE = 80;
    private final ResourceLocation texture;

    public BlackboardTooltipComponent(BlackboardManager.Key key) {
        this.texture = BlackboardManager.getInstance(key).getTextureLocation();
    }

    @Override
    public int getHeight() {
        return SIZE + 2;
    }

    @Override
    public int getWidth(Font pFont) {
        return SIZE;
    }

    @Override
    public void renderImage(Font pFont, int x, int y, PoseStack poseStack, ItemRenderer pItemRenderer) {
        poseStack.pushPose();

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, texture);
        GuiComponent.blit(poseStack, x, y, 0, 0, 0, SIZE, SIZE, SIZE, SIZE);

        poseStack.popPose();
    }
}