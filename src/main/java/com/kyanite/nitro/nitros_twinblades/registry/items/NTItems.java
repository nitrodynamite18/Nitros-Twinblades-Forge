package com.kyanite.nitro.nitros_twinblades.registry.items;

import com.kyanite.nitro.nitros_twinblades.NitrosTwinblades;
import com.kyanite.nitro.nitros_twinblades.registry.items.custom.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NitrosTwinblades.MODID);

    // Vanilla materials
    public static final RegistryObject<SwordItem> WOODEN_TWINBLADE = ITEMS.register("wooden_twinblade", () -> new SwordItem(Tiers.WOOD, 3, -2.4f, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<SwordItem> STONE_TWINBLADE = ITEMS.register("stone_twinblade", () -> new SwordItem(Tiers.STONE, 3, -2.4f, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<SwordItem> GOLDEN_TWINBLADE = ITEMS.register("golden_twinblade", () -> new SwordItem(Tiers.GOLD, 3, -2.4f, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<SwordItem> IRON_TWINBLADE = ITEMS.register("iron_twinblade", () -> new SwordItem(Tiers.IRON, 3, -2.4f, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<SwordItem> DIAMOND_TWINBLADE = ITEMS.register("diamond_twinblade", () -> new SwordItem(Tiers.DIAMOND, 3, -2.4f, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<SwordItem> NETHERITE_TWINBLADE = ITEMS.register("netherite_twinblade", () -> new SwordItem(Tiers.NETHERITE, 3, -2.4f, new Item.Properties().stacksTo(1).fireResistant().tab(CreativeModeTab.TAB_COMBAT)));

    // Modded materials


    // Special
    public static final RegistryObject<InfernalSwordItem> INFERNAL_TWINBLADE = ITEMS.register("infernal_twinblade", InfernalSwordItem::new);
    public static final RegistryObject<FrigidSwordItem> FRIGID_TWINBLADE = ITEMS.register("frigid_twinblade", FrigidSwordItem::new);
    public static final RegistryObject<VenomousSwordItem> VENOMOUS_TWINBLADE = ITEMS.register("venomous_twinblade", VenomousSwordItem::new);
    public static final RegistryObject<LightningSwordItem> LIGHTNING_TWINBLADE = ITEMS.register("lightning_twinblade", LightningSwordItem::new);
    public static final RegistryObject<TerraBladeItem> TERRA_BLADE = ITEMS.register("terra_blade", TerraBladeItem::new);
    // public static final RegistryObject<ClawSwordItem> CRAB_CLAW_TWINBLADE = ITEMS.register("crab_claw_twinblade", ClawSwordItem::new);
    // public static final RegistryObject<VoidSwordItem> VOID_MASTER_TWINBLADE = ITEMS.register("void_master_twinblade", VoidSwordItem::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
