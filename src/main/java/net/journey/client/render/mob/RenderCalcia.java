package net.journey.client.render.mob;

import net.journey.client.render.Textures;
import net.journey.client.render.base.RenderBoss;
import net.journey.entity.mob.boss.EntityCalcia;
import net.journey.util.EnumHexColor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCalcia extends RenderBoss {

    private final ResourceLocation texture;

    public RenderCalcia(ModelBase model, float shadow, float size, ResourceLocation tex, String bar) {
        super(model, shadow, size, tex, bar, EnumHexColor.RED, EnumHexColor.WHITE);
        texture = tex;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        EntityCalcia calcia = (EntityCalcia) var1;
        return calcia.isInv() ? Textures.blank : texture;
    }
}