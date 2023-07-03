package io.taraxacum.finaltech.core.option;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.item.unusable.module.AbstractQuantityModule;
import io.taraxacum.libs.plugin.util.ItemStackUtil;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Final_ROOT
 */
public class Icon {
    public static final ItemStack QUANTITY_MODULE_ICON = new CustomItemStack(Material.REDSTONE, FinalTech.getLanguageString("option", "ICON", "quantity-module", "name"), FinalTech.getLanguageStringArray("option", "ICON", "quantity-module", "lore"));

    public static final ItemStack BORDER_ICON = ChestMenuUtils.getBackground();
//    public static final ItemStack INPUT_BORDER_ICON = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, FinalTech.getLanguageString("option", "CARGO_ORDER", "input-border", "name"), FinalTech.getLanguageStringArray("option", "CARGO_ORDER", "input-border", "lore"));
    public static final ItemStack INPUT_BORDER_ICON = ChestMenuUtils.getInputSlotTexture();
//    public static final ItemStack OUTPUT_BORDER_ICON = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, FinalTech.getLanguageString("option", "CARGO_ORDER", "output-border", "name"), FinalTech.getLanguageStringArray("option", "CARGO_ORDER", "output-border", "lore"));
    public static final ItemStack OUTPUT_BORDER_ICON = ChestMenuUtils.getOutputSlotTexture();
    public static final ItemStack SPECIAL_BORDER_ICON = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, " ");

    public static final ItemStack NEXT_PAGE_ICON = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, FinalTech.getLanguageString("option", "ICON", "next-page", "name"), FinalTech.getLanguageStringArray("option", "ICON", "next-page", "lore"));
    public static final ItemStack PREVIOUS_PAGE_ICON = new CustomItemStack(Material.RED_STAINED_GLASS_PANE, FinalTech.getLanguageString("option", "ICON", "previous-page", "name"), FinalTech.getLanguageStringArray("option", "ICON", "previous-page", "lore"));

    public static final ItemStack STATUS_ICON = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, FinalTech.getLanguageString("option", "ICON", "status", "name"), FinalTech.getLanguageStringArray("option", "ICON", "status", "lore"));

    public static final ItemStack ERROR_ICON = new CustomItemStack(Material.BARRIER, FinalTech.getLanguageString("option", "ICON", "error", "name"), FinalTech.getLanguageStringArray("option", "ICON", "error", "lore"));

    public static final ItemStack WIKI_ICON = new CustomItemStack(Material.KNOWLEDGE_BOOK, FinalTech.getLanguageString("option", "ICON", "wiki-icon", "name"), FinalTech.getLanguageStringArray("option", "ICON", "wiki-icon", "lore"));

    public static final ItemStack RECIPE_ICON = new CustomItemStack(Material.PAPER, FinalTech.getLanguageString("option", "ICON", "recipe-icon", "name"), FinalTech.getLanguageStringArray("option", "ICON", "recipe-icon", "lore"));

    public static final ItemStack CONSUMER_ICON = new CustomItemStack(Material.FURNACE, FinalTech.getLanguageString("option", "ICON", "consumer", "name"), FinalTech.getLanguageStringArray("option", "ICON", "consumer", "lore"));

    public static final ItemStack GENERATOR_ICON = new CustomItemStack(Material.DAYLIGHT_DETECTOR, FinalTech.getLanguageString("option", "ICON", "generator", "name"), FinalTech.getLanguageStringArray("option", "ICON", "generator", "lore"));

    public static final ItemStack CAPACITOR_ICON = new CustomItemStack(Material.YELLOW_STAINED_GLASS, FinalTech.getLanguageString("option", "ICON", "capacitor", "name"), FinalTech.getLanguageStringArray("option", "ICON", "capacitor", "lore"));

    @Deprecated
    public static int updateQuantityModule(@Nonnull BlockMenu blockMenu, int quantityModuleSlot, int statusSlot) {
        boolean updateLore = blockMenu.hasViewer();

        int amount;

        ItemStack itemStack = blockMenu.getItemInSlot(quantityModuleSlot);
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if(slimefunItem instanceof AbstractQuantityModule quantityModule) {
            amount = quantityModule.getEffect(itemStack.getAmount());
            if(updateLore) {
                List<String> loreList = new ArrayList<>(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "lore"));
                if(amount >= 3456) {
                    loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-lore"),
                            FinalTech.getLanguageString("option", "ICON", "quantity-module", "amount-infinity")));
                } else {
                    loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-lore"),
                            String.valueOf(amount)));
                }
                ItemStackUtil.setLore(blockMenu.getItemInSlot(statusSlot), loreList);
            }
        } else {
            amount = 1;
            if(updateLore) {
                List<String> loreList = new ArrayList<>(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "lore"));
                loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-none-lore"),
                        "1"));
                ItemStackUtil.setLore(blockMenu.getItemInSlot(statusSlot), loreList);
            }
        }

        return amount;
    }

    public static int updateQuantityModule(@Nonnull Inventory inventory, boolean updateLore, int quantityModuleSlot, int statusSlot) {
        int amount;

        ItemStack itemStack = inventory.getItem(quantityModuleSlot);
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if(slimefunItem instanceof AbstractQuantityModule quantityModule) {
            amount = quantityModule.getEffect(itemStack.getAmount());
            if(updateLore) {
                List<String> loreList = new ArrayList<>(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "lore"));
                if(amount >= 3456) {
                    loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-lore"),
                            FinalTech.getLanguageString("option", "ICON", "quantity-module", "amount-infinity")));
                } else {
                    loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-lore"),
                            String.valueOf(amount)));
                }
                ItemStackUtil.setLore(inventory.getItem(statusSlot), loreList);
            }
        } else {
            amount = 1;
            if(updateLore) {
                List<String> loreList = new ArrayList<>(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "lore"));
                loreList.addAll(FinalTech.getLanguageManager().replaceStringList(FinalTech.getLanguageStringList("option", "ICON", "quantity-module", "amount-none-lore"),
                        "1"));
                ItemStackUtil.setLore(inventory.getItem(statusSlot), loreList);
            }
        }

        return amount;
    }
}