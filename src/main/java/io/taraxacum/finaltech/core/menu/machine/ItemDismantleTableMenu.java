package io.taraxacum.finaltech.core.menu.machine;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.taraxacum.common.util.JavaUtil;
import io.taraxacum.common.util.StringNumberUtil;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.enums.LogSourceType;
import io.taraxacum.finaltech.core.option.Icon;
import io.taraxacum.finaltech.core.item.machine.AbstractMachine;
import io.taraxacum.finaltech.core.item.unusable.ReplaceableCard;
import io.taraxacum.finaltech.core.menu.manual.AbstractManualMachineMenu;
import io.taraxacum.finaltech.setup.FinalTechItems;
import io.taraxacum.finaltech.util.RecipeUtil;
import io.taraxacum.libs.plugin.dto.LanguageManager;
import io.taraxacum.libs.plugin.dto.LocationData;
import io.taraxacum.libs.plugin.util.InventoryUtil;
import io.taraxacum.libs.plugin.util.ItemStackUtil;
import io.taraxacum.libs.slimefun.interfaces.ValidItem;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class ItemDismantleTableMenu extends AbstractManualMachineMenu {
    private static final int[] BORDER = new int[] {3, 4, 12, 21, 22};
    private static final int[] INPUT_BORDER = new int[] {0, 1, 2, 9, 11, 18, 19, 20};
    private static final int[] OUTPUT_BORDER = new int[] {5, 14, 23};
    private static final int[] INPUT_SLOT = new int[] {10};
    private static final int[] OUTPUT_SLOT = new int[] {6, 7, 8, 15, 16, 17, 24, 25, 26};
    private static final int STATUS_SLOT = 13;

    public ItemDismantleTableMenu(@Nonnull AbstractMachine machine) {
        super(machine);
    }

    @Override
    protected int[] getBorder() {
        return BORDER;
    }

    @Override
    protected int[] getInputBorder() {
        return INPUT_BORDER;
    }

    @Override
    protected int[] getOutputBorder() {
        return OUTPUT_BORDER;
    }

    @Override
    public int[] getInputSlot() {
        return INPUT_SLOT;
    }

    @Override
    public int[] getOutputSlot() {
        return OUTPUT_SLOT;
    }

    @Override
    public void init() {
        super.init();
        this.addItem(STATUS_SLOT, Icon.STATUS_ICON);
    }

    @Override
    public void newInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block block) {
        super.newInstance(blockMenu, block);
        Inventory inventory = blockMenu.toInventory();
        LocationData locationData = FinalTech.getLocationDataService().getLocationData(block.getLocation());

        blockMenu.addMenuClickHandler(STATUS_SLOT, (player, slot, itemStack, action) -> {
            String count = JavaUtil.getFirstNotNull(FinalTech.getLocationDataService().getLocationData(locationData, FinalTechItems.ITEM_DISMANTLE_TABLE.getKey()), StringNumberUtil.ZERO);
            if(StringNumberUtil.compare(count, FinalTechItems.ITEM_DISMANTLE_TABLE.getCount()) >= 0) {
                if (InventoryUtil.isEmpty(inventory, this.getOutputSlot())) {
                    ItemStack item = inventory.getItem(this.getInputSlot()[0]);
                    SlimefunItem slimefunItem = SlimefunItem.getByItem(item);
                    if (slimefunItem != null && FinalTechItems.ITEM_DISMANTLE_TABLE.calAllowed(slimefunItem) && item.getAmount() >= slimefunItem.getRecipeOutput().getAmount()) {
                        boolean verify;
                        if(slimefunItem instanceof ValidItem validItem) {
                            verify = validItem.verifyItem(item);
                        } else {
                            verify = ItemStackUtil.isItemSimilar(item, slimefunItem.getRecipeOutput()) && ItemStackUtil.isEnchantmentSame(item, slimefunItem.getRecipeOutput());
                        }
                        if(verify) {
                            int amount = item.getAmount() / slimefunItem.getRecipeOutput().getAmount();
                            for (ItemStack outputItem : slimefunItem.getRecipe()) {
                                if (!ItemStackUtil.isItemNull(outputItem)) {
                                    amount = Math.min(amount, outputItem.getMaxStackSize() / outputItem.getAmount());
                                }
                            }
                            item.setAmount(item.getAmount() - slimefunItem.getRecipeOutput().getAmount() * amount);
                            if(slimefunItem instanceof ValidItem) {
                                FinalTech.getLogService().subItem(slimefunItem.getId(), slimefunItem.getRecipeOutput().getAmount() * amount, this.getID(), LogSourceType.SLIMEFUN_MACHINE, null, block.getLocation(), this.getSlimefunItem().getAddon().getJavaPlugin());
                            }
                            for (int i = 0; i < ItemDismantleTableMenu.this.getOutputSlot().length && i < slimefunItem.getRecipe().length; i++) {
                                if (!ItemStackUtil.isItemNull(slimefunItem.getRecipe()[i])) {
                                    ItemStack outputItem;
                                    ReplaceableCard replaceableCard = RecipeUtil.getReplaceableCard(slimefunItem.getRecipe()[i]);
                                    if (replaceableCard != null && replaceableCard.getExtraSourceMaterial() != null) {
                                        outputItem = replaceableCard.getItem();
                                    } else {
                                        outputItem = slimefunItem.getRecipe()[i];
                                    }
                                    inventory.setItem(this.getOutputSlot()[i], outputItem);
                                    outputItem = inventory.getItem(this.getOutputSlot()[i]);
                                    outputItem.setAmount(outputItem.getAmount() * amount);
                                }
                            }

                            FinalTech.getLocationDataService().setLocationData(locationData, FinalTechItems.ITEM_DISMANTLE_TABLE.getKey(), StringNumberUtil.sub(count, FinalTechItems.ITEM_DISMANTLE_TABLE.getCount()));
                        }
                    }
                }
            }

            return false;
        });
    }

    @Override
    public void updateInventory(@Nonnull Inventory inventory, @Nonnull Location location) {
        LocationData locationData = FinalTech.getLocationDataService().getLocationData(location);

        ItemStack item = inventory.getItem(STATUS_SLOT);
        if(!ItemStackUtil.isItemNull(item)) {
            String count = JavaUtil.getFirstNotNull(FinalTech.getLocationDataService().getLocationData(locationData, FinalTechItems.ITEM_DISMANTLE_TABLE.getKey()), StringNumberUtil.ZERO);

            LanguageManager languageManager = FinalTech.getLanguageManager();
            ItemStackUtil.setLore(item, languageManager.replaceStringList(languageManager.getStringList("items", this.getID(), "status-icon", "lore"),
                    count,
                    FinalTechItems.ITEM_DISMANTLE_TABLE.getCount()));

            if(StringNumberUtil.compare(count, FinalTechItems.ITEM_DISMANTLE_TABLE.getCount()) >= 0) {
                item.setType(Material.GREEN_STAINED_GLASS_PANE);
            } else {
                item.setType(Material.RED_STAINED_GLASS_PANE);
            }
        }

    }
}
