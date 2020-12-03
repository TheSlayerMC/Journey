package net.jitl.client.render.gui.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.jitl.JITL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JButton extends Button {

	public static final ResourceLocation BUTTONS_NORMAL = JITL.rl("textures/gui/widgets_normal.png");
	public static final ResourceLocation BUTTONS_MIRRORED = JITL.rl("textures/gui/widgets_mirrored.png");

	public boolean isMirrored;

	public JButton(int x, int y, int width, int height, ITextComponent title, IPressable pressedAction, boolean isMirrored) {
		super(x, y, width, height, title, pressedAction);
		this.isMirrored = isMirrored;
	}

	public JButton(int x, int y, int width, int height, ITextComponent title, IPressable pressedAction, ITooltip onTooltip, boolean isMirrored) {
		super(x, y, width, height, title, pressedAction, onTooltip);
		this.isMirrored = isMirrored;
	}

	@Override
	public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		if (this.visible) {
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontrenderer = minecraft.font;
			if (!this.isMirrored) {
				minecraft.getTextureManager().bind(BUTTONS_NORMAL);
			} else {
				minecraft.getTextureManager().bind(BUTTONS_MIRRORED);
			}
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, this.alpha);

			isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width
					&& mouseY < this.y + this.height;

			int i = this.getYImage(this.isHovered());

			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();

			this.blit(matrixStack, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
			this.blit(matrixStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

			this.renderBg(matrixStack, minecraft, mouseX, mouseY);

			int j = 14737632;

			if (getFGColor() != 0) {
				j = getFGColor();
			} else if (!this.isFocused()) {
				j = 10526880;
			} else if (this.isHovered()) {
				j = 16777120;
			}
			drawCenteredString(matrixStack, fontrenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
		}
	}
}