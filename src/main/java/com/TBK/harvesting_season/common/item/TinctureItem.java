package com.TBK.harvesting_season.common.item;

import com.TBK.harvesting_season.Config;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TinctureItem extends PotionItem {
    public TinctureItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, Level world, @NotNull LivingEntity pEntityLiving) {
        if (!world.isClientSide) {
            List<MobEffectInstance> effects = PotionUtils.getMobEffects(pStack);
            if (!effects.isEmpty()) {
                MobEffectInstance effect = (MobEffectInstance)effects.get(0);
                MobEffectInstance currentEffect = pEntityLiving.getEffect(effect.getEffect());
                int newDuration = currentEffect != null ? currentEffect.getDuration() : effect.getDuration();
                int newAmplifier = currentEffect != null ? currentEffect.getAmplifier() + 1 : 0;
                int cap = Config.amplifierCap - 1;
                if (newAmplifier > cap) {
                    newAmplifier = cap;
                }

                pEntityLiving.addEffect(new MobEffectInstance(effect.getEffect(), newDuration, newAmplifier));
            }
        }

        return super.finishUsingItem(pStack, world, pEntityLiving);
    }
}
