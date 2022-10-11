package com.kyanite.nitro.nitros_twinblades.registry.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningSwordItem extends SwordItem {
    public LightningSwordItem() {
        super(Tiers.NETHERITE, 3, -2.4f, new Item.Properties().fireResistant().rarity(Rarity.create("lightning", ChatFormatting.YELLOW)).stacksTo(1).fireResistant().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> components, @NotNull TooltipFlag flag) {
        components.add(Component.translatable("tooltip.nitros_twinblades.lightning_sword").withStyle(ChatFormatting.YELLOW));
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (p_43296_) -> p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(target.level);
        assert lightningBolt != null;
        lightningBolt.moveTo(target.getX(), target.getY(), target.getZ());
        lightningBolt.setCause(attacker instanceof ServerPlayer ? (ServerPlayer)attacker : null);
        target.level.addFreshEntity(lightningBolt);
        target.playSound(SoundEvents.TRIDENT_THUNDER, 5.0F, 1.0F);
        return true;
    }
}
