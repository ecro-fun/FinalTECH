package io.taraxacum.finaltech.setup;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Final_ROOT
 */
public final class FinalTechRecipes {

    // RecipesType
    public static final RecipeType RECIPE_TYPE_ORDERED_DUST_FACTORY = new RecipeType(FinalTechItems.ORDERED_DUST_FACTORY_DIRT, "FINALTECH_DUST_FACTORY");
    public static final RecipeType RECIPE_TYPE_ITEM_SERIALIZATION_CONSTRUCTOR = new RecipeType(FinalTechItems.ITEM_SERIALIZATION_CONSTRUCTOR, "FINALTECH_ALL_COMPRESSION");
    public static final RecipeType RECIPE_TYPE_MATRIX_CRAFTING_TABLE = new RecipeType(FinalTechItems.MATRIX_CRAFTING_TABLE, "FINALTECH_MATRIX_CRAFTING_TABLE");
    public static final RecipeType RECIPE_TYPE_EQUIVALENT_EXCHANGE_TABLE = new RecipeType(FinalTechItems.EQUIVALENT_EXCHANGE_TABLE, "FINALTECH_EQUIVALENT_EXCHANGE_TABLE");
    public static final RecipeType RECIPE_TYPE_CARD_OPERATION_PORT = new RecipeType(FinalTechItems.CARD_OPERATION_PORT, "FINALTECH_CARD_OPERATION_PORT");
    public static final RecipeType RECIPE_TYPE_ENTROPY = new RecipeType(FinalTechItems.ENTROPY, "FINALTECH_ENTROPY");

    // items
    public static final ItemStack[] WATER_CARD = new ItemStack[] {
            null, null, null,
            null, new ItemStack(Material.WATER_BUCKET), null,
            null, null, null
    };
    public static final ItemStack[] LAVA_CARD = new ItemStack[] {
            null, null, null,
            null, new ItemStack(Material.LAVA_BUCKET), null,
            null, null, null
    };
    public static final ItemStack[] MILK_CARD = new ItemStack[] {
            null, null, null,
            null, new ItemStack(Material.MILK_BUCKET), null,
            null, null, null
    };
    public static final ItemStack[] GEARWHEEL = new ItemStack[] {
            new ItemStack(Material.GRANITE), new ItemStack(Material.GRANITE), new ItemStack(Material.GRANITE),
            new ItemStack(Material.DIORITE), new ItemStack(Material.DIORITE), new ItemStack(Material.DIORITE),
            new ItemStack(Material.ANDESITE), new ItemStack(Material.ANDESITE), new ItemStack(Material.ANDESITE)
    };
    public static final ItemStack[] UNORDERED_DUST = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] ORDERED_DUST = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] BUG = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] ENTROPY = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] QUANTITY_MODULE = new ItemStack[] {
            SlimefunItems.ENCHANTMENT_RUNE, FinalTechItems.ORDERED_DUST, SlimefunItems.CHRISTMAS_PRESENT,
            SlimefunItems.ANDROID_INTERFACE_FUEL, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.ANDROID_INTERFACE_ITEMS,
            SlimefunItems.ENRICHED_NETHER_ICE, SlimefunItems.STEEL_THRUSTER, SlimefunItems.MEDICINE
    };
    public static final ItemStack[] COPY_CARD = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] ANNULAR = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] QUANTITY_MODULE_INFINITY = new ItemStack[] {
            new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64),
            new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), FinalTechItems.ANNULAR, new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64),
            new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64)
    };
    public static final ItemStack[] SINGULARITY = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] SPIROCHETE = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] SHELL = new ItemStack[] {
            null, null, null,
            null, null, null,
            null, null, null
    };
    public static final ItemStack[] PHONY = new ItemStack[] {
            FinalTechItems.SHELL, FinalTechItems.SHELL, FinalTechItems.SHELL,
            FinalTechItems.SHELL, null, FinalTechItems.SHELL,
            FinalTechItems.SHELL, FinalTechItems.SHELL, FinalTechItems.SHELL
    };

    // tool

    public static final ItemStack[] MACHINE_CHARGE_CARD_L1 = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST,
            null, FinalTechItems.GEARWHEEL, null,
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] MACHINE_CHARGE_CARD_L2 = new ItemStack[] {
            FinalTechItems.MACHINE_CHARGE_CARD_L1, FinalTechItems.MACHINE_CHARGE_CARD_L1, FinalTechItems.MACHINE_CHARGE_CARD_L1,
            FinalTechItems.MACHINE_CHARGE_CARD_L1, FinalTechItems.BUG, FinalTechItems.MACHINE_CHARGE_CARD_L1,
            FinalTechItems.MACHINE_CHARGE_CARD_L1, FinalTechItems.MACHINE_CHARGE_CARD_L1, FinalTechItems.MACHINE_CHARGE_CARD_L1
    };
    public static final ItemStack[] MACHINE_CHARGE_CARD_L3 = new ItemStack[] {
            FinalTechItems.MACHINE_CHARGE_CARD_L2, FinalTechItems.MACHINE_CHARGE_CARD_L2, FinalTechItems.MACHINE_CHARGE_CARD_L2,
            FinalTechItems.MACHINE_CHARGE_CARD_L2, FinalTechItems.ANNULAR, FinalTechItems.MACHINE_CHARGE_CARD_L2,
            FinalTechItems.MACHINE_CHARGE_CARD_L2, FinalTechItems.MACHINE_CHARGE_CARD_L2, FinalTechItems.MACHINE_CHARGE_CARD_L2
    };
    public static final ItemStack[] MACHINE_ACCELERATE_CARD_L1 = new ItemStack[] {
            null, FinalTechItems.ORDERED_DUST, null,
            FinalTechItems.ORDERED_DUST, FinalTechItems.GEARWHEEL, FinalTechItems.ORDERED_DUST,
            null, FinalTechItems.ORDERED_DUST, null
    };
    public static final ItemStack[] MACHINE_ACCELERATE_CARD_L2 = new ItemStack[] {
            FinalTechItems.MACHINE_ACCELERATE_CARD_L1, FinalTechItems.MACHINE_ACCELERATE_CARD_L1, FinalTechItems.MACHINE_ACCELERATE_CARD_L1,
            FinalTechItems.MACHINE_ACCELERATE_CARD_L1, FinalTechItems.BUG, FinalTechItems.MACHINE_ACCELERATE_CARD_L1,
            FinalTechItems.MACHINE_ACCELERATE_CARD_L1, FinalTechItems.MACHINE_ACCELERATE_CARD_L1, FinalTechItems.MACHINE_ACCELERATE_CARD_L1
    };
    public static final ItemStack[] MACHINE_ACCELERATE_CARD_L3 = new ItemStack[] {
            FinalTechItems.MACHINE_ACCELERATE_CARD_L2, FinalTechItems.MACHINE_ACCELERATE_CARD_L2, FinalTechItems.MACHINE_ACCELERATE_CARD_L2,
            FinalTechItems.MACHINE_ACCELERATE_CARD_L2, FinalTechItems.ANNULAR, FinalTechItems.MACHINE_ACCELERATE_CARD_L2,
            FinalTechItems.MACHINE_ACCELERATE_CARD_L2, FinalTechItems.MACHINE_ACCELERATE_CARD_L2, FinalTechItems.MACHINE_ACCELERATE_CARD_L2
    };
    public static final ItemStack[] MACHINE_ACTIVATE_CARD_L1 = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.GEARWHEEL, FinalTechItems.ORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] MACHINE_ACTIVATE_CARD_L2 = new ItemStack[] {
            FinalTechItems.MACHINE_ACTIVATE_CARD_L1, FinalTechItems.MACHINE_ACTIVATE_CARD_L1, FinalTechItems.MACHINE_ACTIVATE_CARD_L1,
            FinalTechItems.MACHINE_ACTIVATE_CARD_L1, FinalTechItems.BUG, FinalTechItems.MACHINE_ACTIVATE_CARD_L1,
            FinalTechItems.MACHINE_ACTIVATE_CARD_L1, FinalTechItems.MACHINE_ACTIVATE_CARD_L1, FinalTechItems.MACHINE_ACTIVATE_CARD_L1
    };
    public static final ItemStack[] MACHINE_ACTIVATE_CARD_L3 = new ItemStack[] {
            FinalTechItems.MACHINE_ACTIVATE_CARD_L2, FinalTechItems.MACHINE_ACTIVATE_CARD_L2, FinalTechItems.MACHINE_ACTIVATE_CARD_L2,
            FinalTechItems.MACHINE_ACTIVATE_CARD_L2, FinalTechItems.ANNULAR, FinalTechItems.MACHINE_ACTIVATE_CARD_L2,
            FinalTechItems.MACHINE_ACTIVATE_CARD_L2, FinalTechItems.MACHINE_ACTIVATE_CARD_L2, FinalTechItems.MACHINE_ACTIVATE_CARD_L2
    };
    public static final ItemStack[] MENU_VIEWER = new ItemStack[] {
            null, FinalTechItems.GEARWHEEL, null,
            null, new ItemStack(Material.SPYGLASS), null,
            null, null, null
    };
    public static final ItemStack[] LOCATION_RECORDER = new ItemStack[] {
            null, FinalTechItems.GEARWHEEL, null,
            null, new ItemStack(Material.COMPASS), null,
            null, null, null
    };

    // cargo and storage
    public static final ItemStack[] BASIC_FRAME_MACHINE = new ItemStack[] {
            new ItemStack(Material.STONE), new ItemStack(Material.CHAIN), new ItemStack(Material.STONE),
            new ItemStack(Material.CHAIN), FinalTechItems.ORDERED_DUST, new ItemStack(Material.CHAIN),
            new ItemStack(Material.STONE), new ItemStack(Material.CHAIN), new ItemStack(Material.STONE)
    };
    public static final ItemStack[] NORMAL_STORAGE_UNIT = new ItemStack[] {
            new ItemStack(Material.GLASS), new ItemStack(Material.CHEST), new ItemStack(Material.GLASS),
            new ItemStack(Material.CHEST), null, new ItemStack(Material.CHEST),
            new ItemStack(Material.GLASS), new ItemStack(Material.CHEST), new ItemStack(Material.GLASS),
    };
    public static final ItemStack[] DIVIDED_STORAGE_UNIT = new ItemStack[] {
            null, FinalTechItems.GEARWHEEL, null,
            null, FinalTechItems.NORMAL_STORAGE_UNIT, null,
            null, FinalTechItems.GEARWHEEL, null,
    };
    public static final ItemStack[] LIMITED_STORAGE_UNIT = new ItemStack[] {
            null, null, null,
            FinalTechItems.GEARWHEEL, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.GEARWHEEL,
            null, null, null,
    };
    public static final ItemStack[] STACK_STORAGE_UNIT = new ItemStack[] {
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL,
            null, FinalTechItems.NORMAL_STORAGE_UNIT, null,
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL,
    };
    public static final ItemStack[] DIVIDED_LIMITED_STORAGE_UNIT = new ItemStack[] {
            null, FinalTechItems.GEARWHEEL, null,
            FinalTechItems.GEARWHEEL, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.GEARWHEEL,
            null, FinalTechItems.GEARWHEEL, null,
    };
    public static final ItemStack[] DIVIDED_STACK_STORAGE_UNIT = new ItemStack[] {
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            null, FinalTechItems.NORMAL_STORAGE_UNIT, null,
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
    };
    public static final ItemStack[] LIMITED_STACK_STORAGE_UNIT = new ItemStack[] {
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL,
    };
    public static final ItemStack[] CHARGEABLE_STORAGE_UNIT = new ItemStack[] {
            new ItemStack(Material.GLASS), new ItemStack(Material.CHEST), new ItemStack(Material.GLASS),
            new ItemStack(Material.CHEST), FinalTechItems.UNORDERED_DUST, new ItemStack(Material.CHEST),
            new ItemStack(Material.GLASS), new ItemStack(Material.CHEST), new ItemStack(Material.GLASS),
    };
    public static final ItemStack[] RANDOM_INPUT_STORAGE_UNIT = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST,
            null, FinalTechItems.NORMAL_STORAGE_UNIT, null,
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST,
    };
    public static final ItemStack[] RANDOM_OUTPUT_STORAGE_UNIT = new ItemStack[] {
            null, FinalTechItems.UNORDERED_DUST, null,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.UNORDERED_DUST,
            null, FinalTechItems.UNORDERED_DUST, null,
    };
    public static final ItemStack[] RANDOM_STORAGE_UNIT = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST,
    };
    public static final ItemStack[] DISTRIBUTE_LEFT_STORAGE_UNIT = new ItemStack[] {
            null, null, null,
            FinalTechItems.ORDERED_DUST, FinalTechItems.NORMAL_STORAGE_UNIT, null,
            null, null, null,
    };
    public static final ItemStack[] DISTRIBUTE_RIGHT_STORAGE_UNIT = new ItemStack[] {
            null, null, null,
            null, FinalTechItems.NORMAL_STORAGE_UNIT, FinalTechItems.ORDERED_DUST,
            null, null, null,
    };
    public static final ItemStack[] REMOTE_ACCESSOR = new ItemStack[] {
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, new ItemStack(Material.OBSERVER), FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL
    };
    public static final ItemStack[] LINK_TRANSFER = new ItemStack[] {
            new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.CHAIN), new ItemStack(Material.TRIPWIRE_HOOK),
            new ItemStack(Material.STRING), FinalTechItems.BASIC_FRAME_MACHINE, new ItemStack(Material.STRING),
            new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.CHAIN), new ItemStack(Material.TRIPWIRE_HOOK)
    };
    public static final ItemStack[] LINE_TRANSFER = new ItemStack[] {
            new ItemStack(Material.STRING), new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.STRING),
            new ItemStack(Material.TRIPWIRE_HOOK), FinalTechItems.BASIC_FRAME_MACHINE, new ItemStack(Material.TRIPWIRE_HOOK),
            new ItemStack(Material.CHEST), new ItemStack(Material.CHEST), new ItemStack(Material.CHEST)
    };
    public static final ItemStack[] STATION_TRANSFER = new ItemStack[] {
            new ItemStack(Material.HOPPER), new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.CHAIN),
            new ItemStack(Material.HOPPER), FinalTechItems.BASIC_FRAME_MACHINE, new ItemStack(Material.STRING),
            new ItemStack(Material.HOPPER), new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.CHAIN)
    };
    public static final ItemStack[] LOCATION_TRANSFER = new ItemStack[] {
            new ItemStack(Material.CHAIN), new ItemStack(Material.CHEST), new ItemStack(Material.CHAIN),
            new ItemStack(Material.TRIPWIRE_HOOK), FinalTechItems.BASIC_FRAME_MACHINE, new ItemStack(Material.TRIPWIRE_HOOK),
            new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.STRING), new ItemStack(Material.TRIPWIRE_HOOK)
    };
    public static final ItemStack[] STORAGE_INTERACT_PORT = new ItemStack[] {
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE)
    };
    public static final ItemStack[] STORAGE_INSERT_PORT = new ItemStack[] {
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE)
    };

    public static final ItemStack[] STORAGE_WITHDRAW_PORT = new ItemStack[] {
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
            new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL
    };
    public static final ItemStack[] STORAGE_ITEM_UNCOLORED = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.CHEST), new ItemStack(Material.CHEST),
            new ItemStack(Material.CHEST), new ItemStack(Material.CHEST), new ItemStack(Material.TRAPPED_CHEST),
            new ItemStack(Material.TRAPPED_CHEST), new ItemStack(Material.TRAPPED_CHEST), new ItemStack(Material.TRAPPED_CHEST)
    };
    public static final ItemStack[] STORAGE_ITEM_WHITE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.WHITE_CONCRETE_POWDER),
            new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.WHITE_CONCRETE_POWDER), new ItemStack(Material.WHITE_CONCRETE),
            new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.WHITE_CONCRETE), new ItemStack(Material.WHITE_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_ORANGE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.ORANGE_CONCRETE_POWDER), new ItemStack(Material.ORANGE_CONCRETE_POWDER),
            new ItemStack(Material.ORANGE_CONCRETE_POWDER), new ItemStack(Material.ORANGE_CONCRETE_POWDER), new ItemStack(Material.ORANGE_CONCRETE),
            new ItemStack(Material.ORANGE_CONCRETE), new ItemStack(Material.ORANGE_CONCRETE), new ItemStack(Material.ORANGE_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_MAGENTA = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.MAGENTA_CONCRETE_POWDER), new ItemStack(Material.MAGENTA_CONCRETE_POWDER),
            new ItemStack(Material.MAGENTA_CONCRETE_POWDER), new ItemStack(Material.MAGENTA_CONCRETE_POWDER), new ItemStack(Material.MAGENTA_CONCRETE),
            new ItemStack(Material.MAGENTA_CONCRETE), new ItemStack(Material.MAGENTA_CONCRETE), new ItemStack(Material.MAGENTA_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_LIGHT_BLUE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER), new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER),
            new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER), new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER), new ItemStack(Material.LIGHT_BLUE_CONCRETE),
            new ItemStack(Material.LIGHT_BLUE_CONCRETE), new ItemStack(Material.LIGHT_BLUE_CONCRETE), new ItemStack(Material.LIGHT_BLUE_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_YELLOW = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.YELLOW_CONCRETE_POWDER), new ItemStack(Material.YELLOW_CONCRETE_POWDER),
            new ItemStack(Material.YELLOW_CONCRETE_POWDER), new ItemStack(Material.YELLOW_CONCRETE_POWDER), new ItemStack(Material.YELLOW_CONCRETE),
            new ItemStack(Material.YELLOW_CONCRETE), new ItemStack(Material.YELLOW_CONCRETE), new ItemStack(Material.YELLOW_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_LIME = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.LIME_CONCRETE_POWDER), new ItemStack(Material.LIME_CONCRETE_POWDER),
            new ItemStack(Material.LIME_CONCRETE_POWDER), new ItemStack(Material.LIME_CONCRETE_POWDER), new ItemStack(Material.LIME_CONCRETE),
            new ItemStack(Material.LIME_CONCRETE), new ItemStack(Material.LIME_CONCRETE), new ItemStack(Material.LIME_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_PINK = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.PINK_CONCRETE_POWDER), new ItemStack(Material.PINK_CONCRETE_POWDER),
            new ItemStack(Material.PINK_CONCRETE_POWDER), new ItemStack(Material.PINK_CONCRETE_POWDER), new ItemStack(Material.PINK_CONCRETE),
            new ItemStack(Material.PINK_CONCRETE), new ItemStack(Material.PINK_CONCRETE), new ItemStack(Material.PINK_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_GRAY = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.GRAY_CONCRETE_POWDER), new ItemStack(Material.GRAY_CONCRETE_POWDER),
            new ItemStack(Material.GRAY_CONCRETE_POWDER), new ItemStack(Material.GRAY_CONCRETE_POWDER), new ItemStack(Material.GRAY_CONCRETE),
            new ItemStack(Material.GRAY_CONCRETE), new ItemStack(Material.GRAY_CONCRETE), new ItemStack(Material.GRAY_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_LIGHT_GRAY = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER), new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER),
            new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER), new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER), new ItemStack(Material.LIGHT_GRAY_CONCRETE),
            new ItemStack(Material.LIGHT_GRAY_CONCRETE), new ItemStack(Material.LIGHT_GRAY_CONCRETE), new ItemStack(Material.LIGHT_GRAY_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_CYAN = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.CYAN_CONCRETE_POWDER), new ItemStack(Material.CYAN_CONCRETE_POWDER),
            new ItemStack(Material.CYAN_CONCRETE_POWDER), new ItemStack(Material.CYAN_CONCRETE_POWDER), new ItemStack(Material.CYAN_CONCRETE),
            new ItemStack(Material.CYAN_CONCRETE), new ItemStack(Material.CYAN_CONCRETE), new ItemStack(Material.CYAN_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_PURPLE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.PURPLE_CONCRETE_POWDER), new ItemStack(Material.PURPLE_CONCRETE_POWDER),
            new ItemStack(Material.PURPLE_CONCRETE_POWDER), new ItemStack(Material.PURPLE_CONCRETE_POWDER), new ItemStack(Material.PURPLE_CONCRETE),
            new ItemStack(Material.PURPLE_CONCRETE), new ItemStack(Material.PURPLE_CONCRETE), new ItemStack(Material.PURPLE_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_BLUE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.BLUE_CONCRETE_POWDER), new ItemStack(Material.BLUE_CONCRETE_POWDER),
            new ItemStack(Material.BLUE_CONCRETE_POWDER), new ItemStack(Material.BLUE_CONCRETE_POWDER), new ItemStack(Material.BLUE_CONCRETE),
            new ItemStack(Material.BLUE_CONCRETE), new ItemStack(Material.BLUE_CONCRETE), new ItemStack(Material.BLUE_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_BROWN = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.BROWN_CONCRETE_POWDER), new ItemStack(Material.BROWN_CONCRETE_POWDER),
            new ItemStack(Material.BROWN_CONCRETE_POWDER), new ItemStack(Material.BROWN_CONCRETE_POWDER), new ItemStack(Material.BROWN_CONCRETE),
            new ItemStack(Material.BROWN_CONCRETE), new ItemStack(Material.BROWN_CONCRETE), new ItemStack(Material.BROWN_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_GREEN = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.GREEN_CONCRETE_POWDER), new ItemStack(Material.GREEN_CONCRETE_POWDER),
            new ItemStack(Material.GREEN_CONCRETE_POWDER), new ItemStack(Material.GREEN_CONCRETE_POWDER), new ItemStack(Material.GREEN_CONCRETE),
            new ItemStack(Material.GREEN_CONCRETE), new ItemStack(Material.GREEN_CONCRETE), new ItemStack(Material.GREEN_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_RED = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.RED_CONCRETE_POWDER), new ItemStack(Material.RED_CONCRETE_POWDER),
            new ItemStack(Material.RED_CONCRETE_POWDER), new ItemStack(Material.RED_CONCRETE_POWDER), new ItemStack(Material.RED_CONCRETE),
            new ItemStack(Material.RED_CONCRETE), new ItemStack(Material.RED_CONCRETE), new ItemStack(Material.RED_CONCRETE)
    };
    public static final ItemStack[] STORAGE_ITEM_BLACK = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.BLACK_CONCRETE_POWDER), new ItemStack(Material.BLACK_CONCRETE_POWDER),
            new ItemStack(Material.BLACK_CONCRETE_POWDER), new ItemStack(Material.BLACK_CONCRETE_POWDER), new ItemStack(Material.BLACK_CONCRETE),
            new ItemStack(Material.BLACK_CONCRETE), new ItemStack(Material.BLACK_CONCRETE), new ItemStack(Material.BLACK_CONCRETE)
    };

    // electric
    public static final ItemStack[] BASIC_CHARGE_INCREASE_CAPACITOR = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, FinalTechItems.BUG, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.GEARWHEEL, SlimefunItems.ENERGIZED_CAPACITOR, FinalTechItems.GEARWHEEL,
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] BASIC_CONSUME_REDUCE_CAPACITOR = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.GEARWHEEL, SlimefunItems.ENERGIZED_CAPACITOR, FinalTechItems.GEARWHEEL,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.BUG, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] SMALL_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.DURALUMIN_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.DURALUMIN_INGOT,
            FinalTechItems.GEARWHEEL, SlimefunItems.ENERGIZED_CAPACITOR, FinalTechItems.GEARWHEEL,
            SlimefunItems.DURALUMIN_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.DURALUMIN_INGOT
    };
    public static final ItemStack[] MEDIUM_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.BILLON_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.BILLON_INGOT,
            FinalTechItems.GEARWHEEL, FinalTechItems.SMALL_EXPANDED_CAPACITOR, FinalTechItems.GEARWHEEL,
            SlimefunItems.BILLON_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.BILLON_INGOT
    };
    public static final ItemStack[] BIG_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.STEEL_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.STEEL_INGOT,
            FinalTechItems.GEARWHEEL, FinalTechItems.MEDIUM_EXPANDED_CAPACITOR, FinalTechItems.GEARWHEEL,
            SlimefunItems.STEEL_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.STEEL_INGOT
    };
    public static final ItemStack[] LARGE_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.REINFORCED_ALLOY_INGOT,
            FinalTechItems.GEARWHEEL, FinalTechItems.BIG_EXPANDED_CAPACITOR, FinalTechItems.GEARWHEEL,
            SlimefunItems.REINFORCED_ALLOY_INGOT, FinalTechItems.QUANTITY_MODULE, SlimefunItems.REINFORCED_ALLOY_INGOT
    };
    public static final ItemStack[] CARBONADO_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.CARBONADO, FinalTechItems.QUANTITY_MODULE, SlimefunItems.CARBONADO,
            FinalTechItems.GEARWHEEL, FinalTechItems.LARGE_EXPANDED_CAPACITOR, FinalTechItems.GEARWHEEL,
            SlimefunItems.CARBONADO, FinalTechItems.QUANTITY_MODULE, SlimefunItems.CARBONADO
    };
    public static final ItemStack[] ENERGIZED_EXPANDED_CAPACITOR = new ItemStack[] {
            SlimefunItems.CARBONADO, FinalTechItems.QUANTITY_MODULE, SlimefunItems.CARBONADO,
            FinalTechItems.ANNULAR, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.ANNULAR,
            SlimefunItems.CARBONADO, FinalTechItems.QUANTITY_MODULE, SlimefunItems.CARBONADO
    };
    public static final ItemStack[] ENERGIZED_STACK_EXPANDED_CAPACITOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 8), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64)
    };
    public static final ItemStack[] OVERLOADED_EXPANDED_CAPACITOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 8), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64)
    };
    public static final ItemStack[] ADVANCED_CHARGE_INCREASE_CAPACITOR = new ItemStack[] {
            null, new CustomItemStack(FinalTechItems.BASIC_CHARGE_INCREASE_CAPACITOR, 64), null,
            null, null, null,
            null, new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 8), null
    };
    public static final ItemStack[] ADVANCED_CONSUME_REDUCE_CAPACITOR = new ItemStack[] {
            null, new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 8), null,
            null, null, null,
            null, new CustomItemStack(FinalTechItems.BASIC_CONSUME_REDUCE_CAPACITOR, 64), null
    };
    public static final ItemStack[] ESCAPE_CAPACITOR = new ItemStack[] {
            FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR,
            FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.BUG, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR,
            FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR, FinalTechItems.CARBONADO_EXPANDED_CAPACITOR
    };
    public static final ItemStack[] NORMAL_ELECTRICITY_SHOOT_PILE = new ItemStack[] {
            FinalTechItems.BUG, FinalTechItems.BUG, FinalTechItems.BUG,
            FinalTechItems.BUG, SlimefunItems.ENERGY_CONNECTOR, FinalTechItems.BUG,
            FinalTechItems.BUG, FinalTechItems.BUG, FinalTechItems.BUG
    };
    public static final ItemStack[] ENERGIZED_ELECTRICITY_SHOOT_PILE = new ItemStack[] {
            null, FinalTechItems.ORDERED_DUST, null,
            FinalTechItems.ORDERED_DUST, FinalTechItems.NORMAL_ELECTRICITY_SHOOT_PILE, FinalTechItems.ORDERED_DUST,
            null, FinalTechItems.ORDERED_DUST, null
    };
    public static final ItemStack[] OVERLOADED_ELECTRICITY_SHOOT_PILE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, null, FinalTechItems.ORDERED_DUST,
            null, FinalTechItems.NORMAL_ELECTRICITY_SHOOT_PILE, null,
            FinalTechItems.ORDERED_DUST, null, FinalTechItems.ORDERED_DUST
    };
    public static final ItemStack[] ORDERED_DUST_GENERATOR = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, null, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] BASIC_GENERATOR = new ItemStack[] {
            new ItemStack(Material.GLOWSTONE), new ItemStack(Material.GLOWSTONE), new ItemStack(Material.GLOWSTONE),
            SlimefunItems.SOLAR_PANEL, FinalTechItems.ORDERED_DUST, SlimefunItems.SOLAR_PANEL,
            null, SlimefunItems.SOLAR_PANEL, null
    };
    public static final ItemStack[] ADVANCED_GENERATOR = new ItemStack[] {
            FinalTechItems.BASIC_GENERATOR, FinalTechItems.BUG, FinalTechItems.BASIC_GENERATOR,
            FinalTechItems.BUG, new ItemStack(Material.REDSTONE), FinalTechItems.BUG,
            FinalTechItems.BASIC_GENERATOR, FinalTechItems.BUG, FinalTechItems.BASIC_GENERATOR
    };
    public static final ItemStack[] CARBONADO_GENERATOR = new ItemStack[] {
            FinalTechItems.ADVANCED_GENERATOR, FinalTechItems.BUG, FinalTechItems.ADVANCED_GENERATOR,
            FinalTechItems.BUG, SlimefunItems.CARBONADO, FinalTechItems.BUG,
            FinalTechItems.ADVANCED_GENERATOR, FinalTechItems.BUG, FinalTechItems.ADVANCED_GENERATOR
    };
    public static final ItemStack[] ENERGIZED_GENERATOR = new ItemStack[] {
            FinalTechItems.CARBONADO_GENERATOR, FinalTechItems.BUG, FinalTechItems.CARBONADO_GENERATOR,
            FinalTechItems.BUG, SlimefunItems.SOLAR_GENERATOR_4, FinalTechItems.BUG,
            FinalTechItems.CARBONADO_GENERATOR, FinalTechItems.BUG, FinalTechItems.CARBONADO_GENERATOR
    };
    public static final ItemStack[] ENERGIZED_STACK_GENERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64)
    };
    public static final ItemStack[] OVERLOADED_GENERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.UNORDERED_DUST, 64)
    };
    public static final ItemStack[] ENERGIZED_ACCELERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.ANNULAR, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64)
    };
    public static final ItemStack[] OVERLOADED_ACCELERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.ANNULAR, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64)
    };

    // function machine
    public static final ItemStack[] ORDERED_DUST_FACTORY_DIRT = new ItemStack[] {
            SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN,
            SlimefunItems.PORTABLE_DUSTBIN, new ItemStack(Material.DIRT), SlimefunItems.PORTABLE_DUSTBIN,
            SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN
    };
    public static final ItemStack[] ORDERED_DUST_FACTORY_STONE = new ItemStack[] {
            SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN,
            SlimefunItems.PORTABLE_DUSTBIN, new ItemStack(Material.COBBLESTONE), SlimefunItems.PORTABLE_DUSTBIN,
            SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN, SlimefunItems.PORTABLE_DUSTBIN
    };
    public static final ItemStack[] ALL_COMPRESSION = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, SlimefunItems.TRASH_CAN, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST
    };
    public static final ItemStack[] ALL_FACTORY = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.ITEM_SERIALIZATION_CONSTRUCTOR, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST
    };
    public static final ItemStack[] MATRIX_CRAFTING_TABLE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, new ItemStack(Material.HEART_OF_THE_SEA), FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST
    };
    public static final ItemStack[] CARD_OPERATION_PORT = new ItemStack[] {
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, new CustomItemStack(Material.CRAFTING_TABLE), FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL
    };
    public static final ItemStack[] ITEM_DISMANTLE_TABLE = new ItemStack[] {
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, new CustomItemStack(Material.CRAFTING_TABLE), FinalTechItems.UNORDERED_DUST,
            FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST, FinalTechItems.UNORDERED_DUST
    };
    public static final ItemStack[] EQUIVALENT_EXCHANGE_TABLE = new ItemStack[] {
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, new CustomItemStack(Material.CRAFTING_TABLE), FinalTechItems.ORDERED_DUST,
            FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST, FinalTechItems.ORDERED_DUST
    };
    public static final ItemStack[] ENTROPY_CONSTRUCTOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64),
            new CustomItemStack(FinalTechItems.BUG, 64), null, new CustomItemStack(FinalTechItems.BUG, 64),
            new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64)
    };

    // basic machine
    public static final ItemStack[] BASIC_COBBLE_FACTORY = new ItemStack[] {
            new ItemStack(Material.OBSIDIAN), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.OBSIDIAN),
            new ItemStack(Material.WATER_BUCKET), FinalTechItems.GEARWHEEL, new ItemStack(Material.WATER_BUCKET),
            SlimefunItems.COBALT_PICKAXE, new ItemStack(Material.PISTON), SlimefunItems.COBALT_PICKAXE
    };

    public static final ItemStack[] BASIC_ORE_FACTORY = new ItemStack[] {
            SlimefunItems.URANIUM, new ItemStack(Material.PISTON), SlimefunItems.URANIUM,
            SlimefunItems.EARTH_RUNE, FinalTechItems.BASIC_COBBLE_FACTORY, SlimefunItems.EARTH_RUNE,
            SlimefunItems.ENHANCED_FURNACE, new ItemStack(Material.DROPPER), SlimefunItems.ENHANCED_FURNACE
    };

    public static final ItemStack[] BASIC_DUST_FACTORY = new ItemStack[] {
            SlimefunItems.ELECTRIC_ORE_GRINDER, new ItemStack(Material.PISTON), SlimefunItems.ELECTRIC_ORE_GRINDER,
            SlimefunItems.ELECTRIC_GOLD_PAN, FinalTechItems.BASIC_COBBLE_FACTORY, SlimefunItems.ELECTRIC_GOLD_PAN,
            SlimefunItems.ELECTRIC_DUST_WASHER, new ItemStack(Material.DROPPER), SlimefunItems.ELECTRIC_DUST_WASHER
    };

    public static final ItemStack[] BASIC_FARM_FACTORY = new ItemStack[] {
            SlimefunItems.FOOD_FABRICATOR, new ItemStack(Material.PISTON), SlimefunItems.FOOD_FABRICATOR,
            SlimefunItems.FOOD_COMPOSTER, FinalTechItems.BASIC_COBBLE_FACTORY, SlimefunItems.FOOD_COMPOSTER,
            SlimefunItems.CROP_GROWTH_ACCELERATOR, new ItemStack(Material.DROPPER), SlimefunItems.CROP_GROWTH_ACCELERATOR
    };

    public static final ItemStack[] BASIC_LIQUID_FACTORY = new ItemStack[] {
            new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.PISTON), new ItemStack(Material.WATER_BUCKET),
            new ItemStack(Material.LAVA_BUCKET), FinalTechItems.BASIC_COBBLE_FACTORY, new ItemStack(Material.LAVA_BUCKET),
            new ItemStack(Material.MILK_BUCKET), new ItemStack(Material.DROPPER), new ItemStack(Material.MILK_BUCKET)
    };

    public static final ItemStack[] MANUAL_CRAFTING_TABLE = new ItemStack[] {
            FinalTechItems.GEARWHEEL, SlimefunItems.PORTABLE_CRAFTER, null,
            null, null, null,
            null, null, null
    };

    public static final ItemStack[] MANUAL_ENHANCED_CRAFTING_TABLE = new ItemStack[] {
            null, new ItemStack(Material.CRAFTING_TABLE), null,
            null, new ItemStack(Material.DISPENSER), null,
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_GRIND_STONE = new ItemStack[] {
            null, new ItemStack(Material.OAK_FENCE), null,
            null, new ItemStack(Material.DISPENSER), null,
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_ARMOR_FORGE = new ItemStack[] {
            null, new ItemStack(Material.ANVIL), null,
            null, new ItemStack(Material.DISPENSER), null,
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_ORE_CRUSHER = new ItemStack[] {
            null, new ItemStack(Material.NETHER_BRICK_FENCE), null,
            new ItemStack(Material.IRON_BARS), new ItemStack(Material.DISPENSER), new ItemStack(Material.IRON_BARS),
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_COMPRESSOR = new ItemStack[] {
            null, new ItemStack(Material.NETHER_BRICK_FENCE), null,
            new ItemStack(Material.PISTON), new ItemStack(Material.DISPENSER), new ItemStack(Material.PISTON),
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_SMELTERY = new ItemStack[] {
            FinalTechItems.GEARWHEEL, new ItemStack(Material.NETHER_BRICK_FENCE), FinalTechItems.GEARWHEEL,
            new ItemStack(Material.NETHER_BRICK), new ItemStack(Material.DISPENSER), new ItemStack(Material.NETHER_BRICK),
            new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.IGNITION_CHAMBER, new ItemStack(Material.FLINT_AND_STEEL)
    };

    public static final ItemStack[] MANUAL_PRESSURE_CHAMBER = new ItemStack[] {
            FinalTechItems.GEARWHEEL, new ItemStack(Material.DISPENSER), FinalTechItems.GEARWHEEL,
            new ItemStack(Material.PISTON), new ItemStack(Material.GLASS), new ItemStack(Material.PISTON),
            new ItemStack(Material.PISTON), new ItemStack(Material.CAULDRON), new ItemStack(Material.PISTON)
    };

    public static final ItemStack[] MANUAL_MAGIC_WORKBENCH = new ItemStack[] {
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL,
            new ItemStack(Material.BOOKSHELF), new ItemStack(Material.CRAFTING_TABLE), new ItemStack(Material.DISPENSER),
            FinalTechItems.GEARWHEEL, null, FinalTechItems.GEARWHEEL
    };

    public static final ItemStack[] MANUAL_ORE_WASHER = new ItemStack[] {
            null, new ItemStack(Material.DISPENSER), null,
            FinalTechItems.GEARWHEEL, new ItemStack(Material.OAK_FENCE), FinalTechItems.GEARWHEEL,
            null, new ItemStack(Material.CAULDRON), null
    };

    public static final ItemStack[] MANUAL_COMPOSTER = new ItemStack[] {
            new ItemStack(Material.OAK_SLAB), FinalTechItems.GEARWHEEL, new ItemStack(Material.OAK_SLAB),
            new ItemStack(Material.OAK_SLAB), FinalTechItems.GEARWHEEL, new ItemStack(Material.OAK_SLAB),
            new ItemStack(Material.OAK_SLAB), new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB)
    };

    public static final ItemStack[] MANUAL_GOLD_PAN = new ItemStack[] {
            null, new ItemStack(Material.OAK_TRAPDOOR), null,
            null, new ItemStack(Material.CAULDRON), null,
            null, FinalTechItems.GEARWHEEL, null
    };

    public static final ItemStack[] MANUAL_CRUCIBLE = new ItemStack[] {
            new ItemStack(Material.TERRACOTTA), FinalTechItems.GEARWHEEL, new ItemStack(Material.TERRACOTTA),
            new ItemStack(Material.TERRACOTTA), FinalTechItems.GEARWHEEL, new ItemStack(Material.TERRACOTTA),
            new ItemStack(Material.TERRACOTTA), new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.TERRACOTTA)
    };
    public static final ItemStack[] MANUAL_JUICER = new ItemStack[] {
            null, new ItemStack(Material.GLASS), null,
            FinalTechItems.GEARWHEEL, new ItemStack(Material.NETHER_BRICK_FENCE), FinalTechItems.GEARWHEEL,
            null, new ItemStack(Material.DISPENSER), null
    };
    public static final ItemStack[] MANUAL_ANCIENT_ALTAR = new ItemStack[] {
            SlimefunItems.ANCIENT_PEDESTAL, FinalTechItems.GEARWHEEL, SlimefunItems.ANCIENT_PEDESTAL,
            FinalTechItems.GEARWHEEL, SlimefunItems.ANCIENT_ALTAR, FinalTechItems.GEARWHEEL,
            SlimefunItems.ANCIENT_PEDESTAL, FinalTechItems.GEARWHEEL, SlimefunItems.ANCIENT_PEDESTAL
    };
    public static final ItemStack[] MANUAL_HEATED_PRESSURE_CHAMBER = new ItemStack[] {
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, SlimefunItems.HEATED_PRESSURE_CHAMBER, FinalTechItems.GEARWHEEL,
            FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL, FinalTechItems.GEARWHEEL
    };
    public static final ItemStack[] STONE_CHUNK_PRODUCTION_STATION = new ItemStack[] {
            new ItemStack(Material.OBSIDIAN), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.OBSIDIAN),
            new ItemStack(Material.WATER_BUCKET), FinalTechItems.GEARWHEEL, new ItemStack(Material.WATER_BUCKET),
            SlimefunItems.COBALT_PICKAXE, new ItemStack(Material.PISTON), SlimefunItems.COBALT_PICKAXE
    };
    public static final ItemStack[] DUST_WORKSHOP = new ItemStack[] {
            SlimefunItems.ELECTRIC_ORE_GRINDER, new ItemStack(Material.PISTON), SlimefunItems.ELECTRIC_ORE_GRINDER,
            SlimefunItems.ELECTRIC_GOLD_PAN, FinalTechItems.BASIC_COBBLE_FACTORY, SlimefunItems.ELECTRIC_GOLD_PAN,
            SlimefunItems.ELECTRIC_DUST_WASHER, new ItemStack(Material.DROPPER), SlimefunItems.ELECTRIC_DUST_WASHER
    };

    // advanced machines
    public static final ItemStack[] ADVANCED_COMPOSTER = new ItemStack[] {
            FinalTechItems.MANUAL_COMPOSTER, FinalTechItems.ANNULAR, FinalTechItems.MANUAL_COMPOSTER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            FinalTechItems.MANUAL_COMPOSTER, FinalTechItems.UNORDERED_DUST, FinalTechItems.MANUAL_COMPOSTER
    };

    public static final ItemStack[] ADVANCED_JUICER = new ItemStack[] {
            FinalTechItems.MANUAL_JUICER, FinalTechItems.ANNULAR, FinalTechItems.MANUAL_JUICER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            FinalTechItems.MANUAL_JUICER, FinalTechItems.UNORDERED_DUST, FinalTechItems.MANUAL_JUICER
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_FURNACE = new ItemStack[] {
            SlimefunItems.ELECTRIC_FURNACE, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_FURNACE,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_FURNACE, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_FURNACE
    };

    public static final ItemStack[] ADVANCED_GOLD_PAN = new ItemStack[] {
            SlimefunItems.ELECTRIC_GOLD_PAN, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_GOLD_PAN,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_GOLD_PAN, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_GOLD_PAN
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_DUST_WASHER = new ItemStack[] {
            SlimefunItems.ELECTRIC_DUST_WASHER, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_DUST_WASHER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_DUST_WASHER, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_DUST_WASHER
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_INGOT_FACTORY = new ItemStack[] {
            SlimefunItems.ELECTRIC_INGOT_FACTORY, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_INGOT_FACTORY,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_INGOT_FACTORY, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_INGOT_FACTORY
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_CRUCIBLE = new ItemStack[] {
            SlimefunItems.ELECTRIFIED_CRUCIBLE, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIFIED_CRUCIBLE,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIFIED_CRUCIBLE, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIFIED_CRUCIBLE
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_ORE_GRINDER = new ItemStack[] {
            SlimefunItems.ELECTRIC_ORE_GRINDER, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_ORE_GRINDER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_ORE_GRINDER, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_ORE_GRINDER
    };

    public static final ItemStack[] ADVANCED_HEATED_PRESSURE_CHAMBER = new ItemStack[] {
            SlimefunItems.HEATED_PRESSURE_CHAMBER, FinalTechItems.ANNULAR, SlimefunItems.HEATED_PRESSURE_CHAMBER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.HEATED_PRESSURE_CHAMBER, FinalTechItems.UNORDERED_DUST, SlimefunItems.HEATED_PRESSURE_CHAMBER
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_INGOT_PULVERIZER = new ItemStack[] {
            SlimefunItems.ELECTRIC_INGOT_PULVERIZER, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_INGOT_PULVERIZER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_INGOT_PULVERIZER, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_INGOT_PULVERIZER
    };

    public static final ItemStack[] ADVANCED_AUTO_DRIER = new ItemStack[] {
            SlimefunItems.AUTO_DRIER, FinalTechItems.ANNULAR, SlimefunItems.AUTO_DRIER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.AUTO_DRIER, FinalTechItems.UNORDERED_DUST, SlimefunItems.AUTO_DRIER
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_PRESS = new ItemStack[] {
            SlimefunItems.ELECTRIC_PRESS, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_PRESS,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_PRESS, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_PRESS
    };

    public static final ItemStack[] ADVANCED_FOOD_FACTORY = new ItemStack[] {
            SlimefunItems.FOOD_COMPOSTER, FinalTechItems.ANNULAR, SlimefunItems.FOOD_COMPOSTER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.FOOD_FABRICATOR, FinalTechItems.UNORDERED_DUST, SlimefunItems.FOOD_FABRICATOR
    };

    public static final ItemStack[] ADVANCED_FREEZER = new ItemStack[] {
            SlimefunItems.FREEZER, FinalTechItems.ANNULAR, SlimefunItems.FREEZER,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.FREEZER, FinalTechItems.UNORDERED_DUST, SlimefunItems.FREEZER
    };

    public static final ItemStack[] ADVANCED_CARBON_PRESS = new ItemStack[] {
            SlimefunItems.CARBON_PRESS, FinalTechItems.ANNULAR, SlimefunItems.CARBON_PRESS,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.CARBON_PRESS, FinalTechItems.UNORDERED_DUST, SlimefunItems.CARBON_PRESS
    };

    public static final ItemStack[] ADVANCED_ELECTRIC_SMELTERY = new ItemStack[] {
            SlimefunItems.ELECTRIC_SMELTERY, FinalTechItems.ANNULAR, SlimefunItems.ELECTRIC_SMELTERY,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            SlimefunItems.ELECTRIC_SMELTERY, FinalTechItems.UNORDERED_DUST, SlimefunItems.ELECTRIC_SMELTERY
    };

    public static final ItemStack[] ADVANCED_DUST_FACTORY = new ItemStack[] {
            FinalTechItems.BASIC_DUST_FACTORY, FinalTechItems.ANNULAR, FinalTechItems.BASIC_DUST_FACTORY,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            FinalTechItems.BASIC_DUST_FACTORY, FinalTechItems.UNORDERED_DUST, FinalTechItems.BASIC_DUST_FACTORY
    };

    public static final ItemStack[] ADVANCED_ORE_FACTORY = new ItemStack[] {
            FinalTechItems.BASIC_ORE_FACTORY, FinalTechItems.ANNULAR, FinalTechItems.BASIC_ORE_FACTORY,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            FinalTechItems.BASIC_ORE_FACTORY, FinalTechItems.UNORDERED_DUST, FinalTechItems.BASIC_ORE_FACTORY
    };

    public static final ItemStack[] ADVANCED_FARM_FACTORY = new ItemStack[] {
            FinalTechItems.BASIC_FARM_FACTORY, FinalTechItems.ANNULAR, FinalTechItems.BASIC_FARM_FACTORY,
            FinalTechItems.GEARWHEEL, FinalTechItems.BASIC_FRAME_MACHINE, FinalTechItems.GEARWHEEL,
            FinalTechItems.BASIC_FARM_FACTORY, FinalTechItems.UNORDERED_DUST, FinalTechItems.BASIC_FARM_FACTORY
    };

    // best item

    public static final ItemStack[] MACHINE_CHARGE_CARD_INFINITY = new ItemStack[] {
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L3, 8), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L3, 8),
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), FinalTechItems.PHONY, new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L3, 8), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_CHARGE_CARD_L3, 8)
    };

    public static final ItemStack[] MACHINE_ACCELERATE_CARD_INFINITY = new ItemStack[] {
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L3, 8), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L3, 8),
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), FinalTechItems.PHONY, new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64),
            new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L3, 8), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L2, 64), new CustomItemStack(FinalTechItems.MACHINE_ACCELERATE_CARD_L3, 8)
    };

    public static final ItemStack[] MACHINE_ACTIVATE_CARD_L4 = new ItemStack[] {
            FinalTechItems.MACHINE_ACCELERATE_CARD_INFINITY, new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.PHONY, 2), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), FinalTechItems.MACHINE_CHARGE_CARD_INFINITY
    };

    public static final ItemStack[] ADVANCED_AUTO_CRAFT = new ItemStack[] {
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.PHONY, 3), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.ORDERED_DUST, 64), new CustomItemStack(SlimefunItems.CARGO_MANAGER, 64), new CustomItemStack(FinalTechItems.ORDERED_DUST, 64)
    };

    public static final ItemStack[] MATRIX_EXPANDED_CAPACITOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64),
            new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 64), new CustomItemStack(FinalTechItems.PHONY, 4), new CustomItemStack(FinalTechItems.ENERGIZED_EXPANDED_CAPACITOR, 64),
            new CustomItemStack(FinalTechItems.GEARWHEEL, 64), new CustomItemStack(FinalTechItems.QUANTITY_MODULE, 64), new CustomItemStack(FinalTechItems.GEARWHEEL, 64)
    };

    public static final ItemStack[] MATRIX_GENERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8), new CustomItemStack(FinalTechItems.BUG, 8), new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8),
            new CustomItemStack(FinalTechItems.BUG, 8), new CustomItemStack(FinalTechItems.PHONY, 6), new CustomItemStack(FinalTechItems.BUG, 8),
            new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8), new CustomItemStack(FinalTechItems.BUG, 8), new CustomItemStack(FinalTechItems.ENERGIZED_GENERATOR, 8)
    };

    public static final ItemStack[] MATRIX_ACCELERATOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.ANNULAR, 8), new CustomItemStack(FinalTechItems.ANNULAR, 8), new CustomItemStack(FinalTechItems.ANNULAR, 8),
            new CustomItemStack(FinalTechItems.ANNULAR, 8), new CustomItemStack(FinalTechItems.PHONY, 7), new CustomItemStack(FinalTechItems.ANNULAR, 8),
            new CustomItemStack(FinalTechItems.ANNULAR, 8), new CustomItemStack(FinalTechItems.ANNULAR, 8), new CustomItemStack(FinalTechItems.ANNULAR, 8)
    };

    public static final ItemStack[] MATRIX_REACTOR = new ItemStack[] {
            new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64),
            new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.PHONY, 9), new CustomItemStack(FinalTechItems.BUG, 64),
            new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64), new CustomItemStack(FinalTechItems.BUG, 64)
    };

    // weapon
    public static final ItemStack[] DUST_SWORD = new ItemStack[] {
            null, FinalTechItems.ORDERED_DUST, null,
            null, FinalTechItems.ORDERED_DUST, null,
            null, FinalTechItems.GEARWHEEL, null
    };
}
