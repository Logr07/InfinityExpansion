package io.github.mooy1.infinityexpansion.implementation.blocks;

import lombok.experimental.UtilityClass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.categories.Categories;
import io.github.mooy1.infinityexpansion.implementation.materials.Materials;
import io.github.mooy1.infinitylib.slimefun.presets.LorePreset;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

@UtilityClass
public final class Blocks {

    public static final SlimefunItemStack ADVANCED_ANVIL = new SlimefunItemStack(
            "ADVANCED_ANVIL",
            Material.SMITHING_TABLE,
            "&cAdvanced Anvil",
            "&7Combines tools and gear enchants and sometimes upgrades them",
            "&bWorks with Slimefun items",
            "",
            LorePreset.energy(100000) + "per use"
    );
    public static final SlimefunItemStack INFINITY_FORGE = new SlimefunItemStack(
            "INFINITY_FORGE",
            Material.RESPAWN_ANCHOR,
            "&6Infinity Workbench",
            "&7Used to craft infinity items",
            "",
            LorePreset.energy(10000000) + "per item"
    );
    public static final SlimefunItemStack STORAGE_FORGE = new SlimefunItemStack(
            "STORAGE_FORGE",
            Material.BEEHIVE,
            "&6Storage Forge",
            "&7Upgrades the tier of Storage Units",
            "&7Retains stored items"
    );
    
    private static final int BASIC_AMOUNT = 6400;
    private static final int ADVANCED_AMOUNT = 25600;
    private static final int REINFORCED_AMOUNT = 102400;
    private static final int VOID_AMOUNT = 409600;
    private static final int INFINITY_AMOUNT = 1_600_000_000;
    
    public static final SlimefunItemStack BASIC_STORAGE = new SlimefunItemStack(
            "BASIC_STORAGE",
            Material.OAK_WOOD,
            "&9Basic &8Storage Unit",
            "&6Capacity: &e" + LorePreset.format(BASIC_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack ADVANCED_STORAGE = new SlimefunItemStack(
            "ADVANCED_STORAGE",
            Material.DARK_OAK_WOOD,
            "&cAdvanced &8Storage Unit",
            "&6Capacity: &e" + LorePreset.format(ADVANCED_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack REINFORCED_STORAGE = new SlimefunItemStack(
            "REINFORCED_STORAGE",
            Material.ACACIA_WOOD,
            "&fReinforced &8Storage Unit",
            "&6Capacity: &e" + LorePreset.format(REINFORCED_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack VOID_STORAGE = new SlimefunItemStack(
            "VOID_STORAGE",
            Material.CRIMSON_HYPHAE,
            "&8Void &8Storage Unit",
            "&6Capacity: &e" + LorePreset.format(VOID_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack INFINITY_STORAGE = new SlimefunItemStack(
            "INFINITY_STORAGE",
            Material.WARPED_HYPHAE,
            "&bInfinity &8Storage Unit",
            "&6Capacity: &e" + LorePreset.format(INFINITY_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack STRAINER_BASE = new SlimefunItemStack(
            "STRAINER_BASE",
            Material.SANDSTONE_WALL,
            "&7Strainer Base"
    );
    
    public static void setup(InfinityExpansion plugin) {
        new StrainerBase(Categories.BASIC_MACHINES, STRAINER_BASE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.STICK), new ItemStack(Material.STRING), new ItemStack(Material.STICK),
                new ItemStack(Material.STICK), new ItemStack(Material.STRING), new ItemStack(Material.STICK),
                Materials.MAGSTEEL, Materials.MAGSTEEL, Materials.MAGSTEEL,
        }, 48).register(plugin);
        new StorageUnit(BASIC_STORAGE, BASIC_AMOUNT,  new ItemStack[] {
                new ItemStack(Material.OAK_LOG), Materials.MAGSTEEL, new ItemStack(Material.OAK_LOG),
                new ItemStack(Material.OAK_LOG), new ItemStack(Material.BARREL), new ItemStack(Material.OAK_LOG),
                new ItemStack(Material.OAK_LOG), Materials.MAGSTEEL, new ItemStack(Material.OAK_LOG)
        }).register(plugin);
        new StorageUnit(ADVANCED_STORAGE, ADVANCED_AMOUNT,  new ItemStack[] {
                Materials.MAGSTEEL, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL,
                Materials.MAGSTEEL, BASIC_STORAGE, Materials.MAGSTEEL,
                Materials.MAGSTEEL, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL
        }).register(plugin);
        new StorageUnit(REINFORCED_STORAGE, REINFORCED_AMOUNT,  new ItemStack[] {
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL_PLATE,
                Materials.MAGSTEEL_PLATE, ADVANCED_STORAGE, Materials.MAGSTEEL_PLATE,
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_PLATE, Materials.MAGSTEEL_PLATE
        }).register(plugin);
        new StorageUnit(VOID_STORAGE, VOID_AMOUNT,  new ItemStack[] {
                Materials.VOID_INGOT, Materials.MACHINE_PLATE, Materials.VOID_INGOT,
                Materials.MAGNONIUM, REINFORCED_STORAGE, Materials.MAGNONIUM,
                Materials.VOID_INGOT, Materials.MACHINE_CORE, Materials.VOID_INGOT
        }).register(plugin);
        new StorageUnit(INFINITY_STORAGE, INFINITY_AMOUNT, new ItemStack[] {
                Materials.INFINITY, Materials.VOID_INGOT, Materials.INFINITY,
                Materials.INFINITY, VOID_STORAGE, Materials.INFINITY,
                Materials.INFINITY, Materials.VOID_INGOT, Materials.INFINITY
        }).register(plugin);
        new AdvancedAnvil(Categories.MAIN_MATERIALS, ADVANCED_ANVIL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, new ItemStack(Material.ANVIL), Materials.MACHINE_PLATE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }, 100000).register(plugin);
        new InfinityWorkbench(Categories.MAIN_MATERIALS, INFINITY_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.MACHINE_PLATE, Materials.VOID_INGOT,
                SlimefunItems.ENERGIZED_CAPACITOR, new ItemStack(Material.CRAFTING_TABLE), SlimefunItems.ENERGIZED_CAPACITOR,
                Materials.VOID_INGOT, Materials.MACHINE_PLATE, Materials.VOID_INGOT
        }, 10000000).register(plugin);
        new StorageForge(Categories.STORAGE, STORAGE_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Materials.MAGSTEEL, new ItemStack(Material.ANVIL), Materials.MAGSTEEL,
                Materials.MAGSTEEL, new ItemStack(Material.CRAFTING_TABLE), Materials.MAGSTEEL,
                Materials.MAGSTEEL, new ItemStack(Material.BARREL), Materials.MAGSTEEL,
        }).register(plugin);
    }
    
}