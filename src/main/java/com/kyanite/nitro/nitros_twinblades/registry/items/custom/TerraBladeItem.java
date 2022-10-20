package com.kyanite.nitro.nitros_twinblades.registry.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TerraBladeItem extends SwordItem {
    public TerraBladeItem() {
        super(Tiers.NETHERITE, 3, -2.4f, new Item.Properties().fireResistant().rarity(Rarity.create("terra", ChatFormatting.DARK_GREEN)).stacksTo(1).tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> components, @NotNull TooltipFlag flag) {
        components.add(Component.translatable("tooltip.nitros_twinblades.terra_blade").withStyle(ChatFormatting.DARK_GREEN));
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (p_43296_) -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        target.hurt(DamageSource.FALLING_STALACTITE, 10.0f);
        return true;
    }
}
