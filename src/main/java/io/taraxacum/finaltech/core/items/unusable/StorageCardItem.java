package io.taraxacum.finaltech.core.items.unusable;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.taraxacum.finaltech.api.interfaces.RecipeItem;
import io.taraxacum.finaltech.util.ItemStackUtil;
import io.taraxacum.finaltech.util.StringItemUtil;
import io.taraxacum.finaltech.util.TextUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class StorageCardItem extends UnusableSlimefunItem implements RecipeItem {
    public static final String ITEM_LORE_WITHOUT_COLOR = "⌫⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌧⌦";
    public static final String ITEM_LORE = TextUtil.colorRandomString(ITEM_LORE_WITHOUT_COLOR);

    public static final ItemStack[] RANDOM_STORAGE_CARD_ITEM = new ItemStack[] {
//            new ItemStack(FinalTechItems.STORAGE_ITEM_WHITE),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_ORANGE),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_MAGENTA),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_LIGHT_BLUE),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_YELLOW),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_LIME),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_PINK),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_GRAY),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_LIGHT_GRAY),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_CYAN),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_PURPLE),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_BLUE),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_BROWN),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_GREEN),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_RED),
//            new ItemStack(FinalTechItems.STORAGE_ITEM_BLACK),
    };

    public StorageCardItem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerDescriptiveRecipe("&f介绍",
                "",
                "&f需通过存储交互接口",
                "&f存入或取出物品",
                "",
                "&f一个存储卡只能存入一种物品",
                "&f但是可存入物品的数量是无限的",
                "&f各色存储卡之间并无区别");
    }

    public static boolean isValid(@Nonnull ItemStack item) {
        if (item.hasItemMeta()) {
            return StorageCardItem.isValid(item.getItemMeta());
        }
        return false;
    }
    public static boolean isValid(@Nonnull ItemMeta itemMeta) {
        if (!itemMeta.hasLore()) {
            return false;
        }
        List<String> lore = itemMeta.getLore();
        return !lore.isEmpty() && StorageCardItem.ITEM_LORE_WITHOUT_COLOR.equals(ChatColor.stripColor(lore.get(0)));
    }

    public static void updateLore(@Nonnull ItemStack cardItem) {
        if (!cardItem.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        StorageCardItem.updateLore(itemMeta);
        cardItem.setItemMeta(itemMeta);
    }
    /**
     * Use ItemStack.setItemMeta() after using this
     * @param cardItemMeta
     */
    public static void updateLore(@Nonnull ItemMeta cardItemMeta) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        ItemStack stringItem = null;
        if (persistentDataContainer.has(StringItemUtil.ITEM_KEY, PersistentDataType.STRING)) {
            String itemString = persistentDataContainer.get(StringItemUtil.ITEM_KEY, PersistentDataType.STRING);
            stringItem = ItemStackUtil.stringToItemStack(itemString);
        }
        StorageCardItem.updateLore(cardItemMeta, stringItem);
    }
    public static void updateLore(@Nonnull ItemMeta cardItemMeta, @Nullable ItemStack stringItem) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        List<String> lore;
        if (persistentDataContainer.has(StringItemUtil.AMOUNT_KEY, PersistentDataType.STRING)) {
            String amount = persistentDataContainer.get(StringItemUtil.AMOUNT_KEY, PersistentDataType.STRING);
            lore = cardItemMeta.getLore();
            if (lore == null || lore.isEmpty()) {
                lore = new ArrayList<>(4);
                lore.add(StorageCardItem.ITEM_LORE);
            } else {
                lore.set(0, StorageCardItem.ITEM_LORE);
            }
            String name = ItemStackUtil.getItemName(stringItem);
            if (lore.size() == 1) {
                lore.add("§7存储的物品=" + name);
            } else {
                lore.set(1, "§7存储的物品=" + name);
            }
            if (lore.size() == 2) {
                lore.add("§7存储的数量=" + amount);
            } else {
                lore.set(2, "§7存储的数量=" + amount);
            }
        } else {
            lore = new ArrayList<>(2);
            lore.add(StorageCardItem.ITEM_LORE);
            lore.add("§7未存储物品");
        }
        cardItemMeta.setLore(lore);
    }

    public static void updateType(@Nonnull ItemStack cardItem) {
        StorageCardItem.updateType(cardItem, cardItem.getItemMeta());
    }
    public static void updateType(@Nonnull ItemStack cardItem, @Nonnull ItemMeta cardItemMeta) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(StringItemUtil.AMOUNT_KEY, PersistentDataType.STRING)) {
            Material type = cardItem.getType();
            switch (type) {
                case WHITE_CONCRETE_POWDER -> type = Material.WHITE_CONCRETE;
                case ORANGE_CONCRETE_POWDER -> type = Material.ORANGE_CONCRETE;
                case MAGENTA_CONCRETE_POWDER -> type = Material.MAGENTA_CONCRETE;
                case LIGHT_BLUE_CONCRETE_POWDER -> type = Material.LIGHT_BLUE_CONCRETE;
                case YELLOW_CONCRETE_POWDER -> type = Material.YELLOW_CONCRETE;
                case LIME_CONCRETE_POWDER -> type = Material.LIME_CONCRETE;
                case PINK_CONCRETE_POWDER -> type = Material.PINK_CONCRETE;
                case GRAY_CONCRETE_POWDER -> type = Material.GRAY_CONCRETE;
                case LIGHT_GRAY_CONCRETE_POWDER -> type = Material.LIGHT_GRAY_CONCRETE;
                case CYAN_CONCRETE_POWDER -> type = Material.CYAN_CONCRETE;
                case PURPLE_CONCRETE_POWDER -> type = Material.PURPLE_CONCRETE;
                case BLUE_CONCRETE_POWDER -> type = Material.BLUE_CONCRETE;
                case BROWN_CONCRETE_POWDER -> type = Material.BROWN_CONCRETE;
                case GREEN_CONCRETE_POWDER -> type = Material.GREEN_CONCRETE;
                case RED_CONCRETE_POWDER -> type = Material.RED_CONCRETE;
                case BLACK_CONCRETE_POWDER -> type = Material.BLACK_CONCRETE;
                default -> {
                }
            }
            cardItem.setType(type);
        } else {
            Material type = cardItem.getType();
            switch (type) {
                case WHITE_CONCRETE -> type = Material.WHITE_CONCRETE_POWDER;
                case ORANGE_CONCRETE -> type = Material.ORANGE_CONCRETE_POWDER;
                case MAGENTA_CONCRETE -> type = Material.MAGENTA_CONCRETE_POWDER;
                case LIGHT_BLUE_CONCRETE -> type = Material.LIGHT_BLUE_CONCRETE_POWDER;
                case YELLOW_CONCRETE -> type = Material.YELLOW_CONCRETE_POWDER;
                case LIME_CONCRETE -> type = Material.LIME_CONCRETE_POWDER;
                case PINK_CONCRETE -> type = Material.PINK_CONCRETE_POWDER;
                case GRAY_CONCRETE -> type = Material.GRAY_CONCRETE_POWDER;
                case LIGHT_GRAY_CONCRETE -> type = Material.LIGHT_GRAY_CONCRETE_POWDER;
                case CYAN_CONCRETE -> type = Material.CYAN_CONCRETE_POWDER;
                case PURPLE_CONCRETE -> type = Material.PURPLE_CONCRETE_POWDER;
                case BLUE_CONCRETE -> type = Material.BLUE_CONCRETE_POWDER;
                case BROWN_CONCRETE -> type = Material.BROWN_CONCRETE_POWDER;
                case GREEN_CONCRETE -> type = Material.GREEN_CONCRETE_POWDER;
                case RED_CONCRETE -> type = Material.RED_CONCRETE_POWDER;
                case BLACK_CONCRETE -> type = Material.BLACK_CONCRETE_POWDER;
                default -> {
                }
            }
            cardItem.setType(type);
        }
    }
}