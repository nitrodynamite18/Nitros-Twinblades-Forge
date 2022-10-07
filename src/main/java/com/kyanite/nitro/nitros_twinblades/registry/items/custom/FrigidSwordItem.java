package com.kyanite.nitro.nitros_twinblades.registry.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrigidSwordItem extends SwordItem {
    public FrigidSwordItem() {
        super(Tiers.NETHERITE, 3, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.create("frigid", ChatFormatting.DARK_BLUE)).stacksTo(1).tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("tooltip.nitros_twinblades.frigid_sword"));
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (p_43296_) -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        target.hurt(new DamageSource("frostbite").bypassMagic(), 2.0F);
        return true;
    }
}
