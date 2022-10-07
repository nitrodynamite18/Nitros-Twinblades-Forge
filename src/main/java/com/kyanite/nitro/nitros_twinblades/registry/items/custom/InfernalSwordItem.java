package com.kyanite.nitro.nitros_twinblades.registry.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfernalSwordItem extends SwordItem {
    public InfernalSwordItem() {
        super(Tiers.NETHERITE, 3, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.create("infernal", ChatFormatting.DARK_RED)).stacksTo(1).tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.nitros_twinblades.infernal_sword"));
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target){
        return target.getBoundingBox().inflate(1.0D, 0.5D, 1.0D);
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity target, LivingEntity attacker) {
        p_43278_.hurtAndBreak(1, attacker, (p_43296_) -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        target.hurt(new DamageSource("hellFire").bypassMagic().setIsFire(), 2.0F);
        return true;
    }
}
