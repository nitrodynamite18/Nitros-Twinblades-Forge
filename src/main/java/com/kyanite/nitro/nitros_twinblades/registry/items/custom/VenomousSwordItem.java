package com.kyanite.nitro.nitros_twinblades.registry.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VenomousSwordItem extends SwordItem {
    public VenomousSwordItem() {
        super(Tiers.NETHERITE, 3, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.create("venomous", ChatFormatting.GREEN)).stacksTo(1).tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> components, @NotNull TooltipFlag flag) {
        components.add(Component.translatable("tooltip.nitros_twinblades.venomous_sword").withStyle(ChatFormatting.GREEN));
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (p_43296_) -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        target.hurt(DamageSource.WITHER, 8.0f);
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 3));
        return true;
    }
}
