package io.taraxacum.finaltech.util;

import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.api.dto.ItemStackWithWrapperAmount;
import io.taraxacum.finaltech.api.dto.ItemStackWithWrapper;
import io.taraxacum.common.util.StringNumberUtil;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * We should make suer that
 * one item will have "item" key and "amount" key in the same time
 * or one item will not have only one of them.
 * @author Final_ROOT
 * @since 1.0
 */
public class StringItemUtil {
    public static final NamespacedKey ITEM_KEY = new NamespacedKey(FinalTech.getPlugin(FinalTech.class), "item");
    public static final NamespacedKey AMOUNT_KEY = new NamespacedKey(FinalTech.getPlugin(FinalTech.class), "amount");

    /**
     * get and push item to the inventory
     * @param cardItem
     * @param inventory
     * @param slots ths slot of the inventory that the item will push it's stored items
     * @return the amount it pushed in real
     */
    public static int pushItemFromCard(@Nonnull ItemStack cardItem, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        if (!cardItem.hasItemMeta() || (cardItem.getAmount() != 1)) {
            return 0;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        int count = StringItemUtil.pushItemFromCard(itemMeta, inventory, slots);
        cardItem.setItemMeta(itemMeta);
        return count;
    }
    /**
     * Set itemMete after using this to save data
     * @param cardItemMeta
     * @param inventory
     * @param slots
     * @return
     */
    public static int pushItemFromCard(@Nonnull ItemMeta cardItemMeta, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(ITEM_KEY, PersistentDataType.STRING)) {
            String itemString = persistentDataContainer.get(ITEM_KEY, PersistentDataType.STRING);
            ItemStackWithWrapper stringItem = new ItemStackWithWrapper(ItemStackUtil.stringToItemStack(itemString));
            return StringItemUtil.pushItemFromCard(cardItemMeta, stringItem, inventory, slots);
        }
        return 0;
    }
    public static int pushItemFromCard(@Nonnull ItemMeta cardItemMeta, @Nonnull ItemStackWithWrapper stringItem, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        String amount = persistentDataContainer.get(AMOUNT_KEY, PersistentDataType.STRING);
        int maxStackSize = stringItem.getItemStack().getMaxStackSize();
        int validAmount = StringNumberUtil.compare(amount, String.valueOf(maxStackSize * slots.length)) >= 1 ? maxStackSize * slots.length : Integer.parseInt(amount);
        amount = StringNumberUtil.sub(amount, String.valueOf(validAmount));
        ItemStack targetItem;
        int count = 0;
        for (int slot : slots) {
            targetItem = inventory.getItem(slot);
            if (ItemStackUtil.isItemNull(targetItem)) {
                if (validAmount >= maxStackSize) {
                    targetItem = stringItem.getItemStack().clone();
                    targetItem.setAmount(maxStackSize);
                    inventory.setItem(slot, targetItem);
                    count += maxStackSize;
                    validAmount -= maxStackSize;
                } else if (validAmount > 0) {
                    targetItem = stringItem.getItemStack().clone();
                    targetItem.setAmount(validAmount);
                    inventory.setItem(slot, targetItem);
                    count += validAmount;
                    validAmount = 0;
                    break;
                }
            } else if (targetItem.getAmount() < targetItem.getMaxStackSize() && ItemStackUtil.isItemSimilar(stringItem, targetItem)) {
                int stackableAmount = targetItem.getMaxStackSize() - targetItem.getAmount();
                if (validAmount > stackableAmount) {
                    targetItem.setAmount(targetItem.getMaxStackSize());
                    count += stackableAmount;
                    validAmount -= stackableAmount;
                } else {
                    targetItem.setAmount(targetItem.getAmount() + validAmount);
                    count += Integer.parseInt(amount);
                    validAmount -= stackableAmount;
                    break;
                }
            }
        }
        amount = StringNumberUtil.add(amount, String.valueOf(validAmount));
        if (StringNumberUtil.ZERO.equals(amount)) {
            persistentDataContainer.remove(ITEM_KEY);
            persistentDataContainer.remove(AMOUNT_KEY);
        } else {
            persistentDataContainer.set(AMOUNT_KEY, PersistentDataType.STRING, amount);
        }
        return count;
    }

    public static int storageItemToCard(@Nonnull ItemStack cardItem, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        if (!cardItem.hasItemMeta()) {
            return 0;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        int count = StringItemUtil.storageItemToCard(itemMeta, cardItem.getAmount(), inventory, slots);
        cardItem.setItemMeta(itemMeta);
        return count;
    }
    public static int storageItemToCard(@Nonnull ItemMeta itemMeta, int size, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        ItemStackWithWrapper stringItem = null;
        if (persistentDataContainer.has(ITEM_KEY, PersistentDataType.STRING)) {
            String itemString = persistentDataContainer.get(ITEM_KEY, PersistentDataType.STRING);
            ItemStack item = ItemStackUtil.stringToItemStack(itemString);
            if (item != null) {
                stringItem = new ItemStackWithWrapper(item);
            }
        }
        return StringItemUtil.storageItemToCard(itemMeta, stringItem, size, inventory, slots);
    }

    public static int storageItemToCard(@Nonnull ItemMeta cardItemMeta, @Nullable ItemStackWithWrapper stringItem, int size, @Nonnull Inventory inventory, @Nonnull int[] slots) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        String amount = StringNumberUtil.ZERO;
        if (persistentDataContainer.has(AMOUNT_KEY, PersistentDataType.STRING)) {
            amount = persistentDataContainer.get(AMOUNT_KEY, PersistentDataType.STRING);
        } else {
            stringItem = null;
        }
        int totalAmount = 0;
        List<ItemStack> sourceItemList = new ArrayList<>(slots.length);
        for (int slot : slots) {
            ItemStack sourceItem = inventory.getItem(slot);
            if (ItemStackUtil.isItemNull(sourceItem)) {
                continue;
            }
            if (stringItem == null || ItemStackUtil.isItemNull(stringItem.getItemStack())) {
                stringItem = new ItemStackWithWrapperAmount(sourceItem.clone());
                stringItem.getItemStack().setAmount(1);
                totalAmount += sourceItem.getAmount();
                sourceItemList.add(sourceItem);
            } else if (ItemStackUtil.isItemSimilar(stringItem, sourceItem)) {
                totalAmount += sourceItem.getAmount();
                sourceItemList.add(sourceItem);
            }
        }

        totalAmount = totalAmount - totalAmount % size;
        int count = totalAmount;
        for (ItemStack sourceItem : sourceItemList) {
            if (sourceItem.getAmount() > totalAmount) {
                sourceItem.setAmount(sourceItem.getAmount() - totalAmount);
                break;
            } else {
                totalAmount -= sourceItem.getAmount();
                sourceItem.setAmount(0);
            }
        }

        if (count > 0) {
            if (StringNumberUtil.ZERO.equals(amount)) {
                persistentDataContainer.set(AMOUNT_KEY, PersistentDataType.STRING, String.valueOf(count));
                persistentDataContainer.set(ITEM_KEY, PersistentDataType.STRING, ItemStackUtil.itemStackToString(stringItem.getItemStack()));
            } else {
                persistentDataContainer.set(AMOUNT_KEY, PersistentDataType.STRING, StringNumberUtil.add(amount, String.valueOf(count)));
            }
        } else {
            if (StringNumberUtil.ZERO.equals(amount)) {
                persistentDataContainer.remove(ITEM_KEY);
            }
        }

        return count;
    }

    @Nullable
    public static ItemStack parseItemInCard(@Nonnull ItemStack cardItem) {
        if (!cardItem.hasItemMeta()) {
            return null;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        return StringItemUtil.parseItemInCard(itemMeta);
    }
    @Nullable
    public static ItemStack parseItemInCard(@Nonnull ItemMeta cardItemMeta) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(ITEM_KEY, PersistentDataType.STRING)) {
            String itemString = persistentDataContainer.get(ITEM_KEY, PersistentDataType.STRING);
            ItemStack stringItem = ItemStackUtil.stringToItemStack(itemString);
            stringItem.setAmount(1);
            return stringItem;
        }
        return null;
    }

    @Nonnull
    public static String parseAmountInCard(@Nonnull ItemStack cardItem) {
        if (!cardItem.hasItemMeta()) {
            return StringNumberUtil.ZERO;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        return StringItemUtil.parseAmountInCard(itemMeta);
    }
    @Nonnull
    public static String parseAmountInCard(@Nonnull ItemMeta cardItemMeta) {
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(AMOUNT_KEY, PersistentDataType.STRING)) {
            return persistentDataContainer.get(AMOUNT_KEY, PersistentDataType.STRING);
        }
        return StringNumberUtil.ZERO;
    }

    public static void setItemInCard(@Nonnull ItemStack cardItem, @Nonnull ItemStack item, int amount) {
        StringItemUtil.setItemInCard(cardItem, item, String.valueOf(amount));
    }
    public static void setItemInCard(@Nonnull ItemStack cardItem, @Nonnull ItemStack item, @Nonnull String amount) {
        if (!cardItem.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = cardItem.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (StringNumberUtil.easilyCompare(amount, StringNumberUtil.ZERO) == 1) {
            persistentDataContainer.set(ITEM_KEY, PersistentDataType.STRING, ItemStackUtil.itemStackToString(item));
            persistentDataContainer.set(AMOUNT_KEY, PersistentDataType.STRING, amount);
        } else {
            persistentDataContainer.remove(ITEM_KEY);
            persistentDataContainer.remove(AMOUNT_KEY);
        }
        cardItem.setItemMeta(itemMeta);
    }

    public static void setAmountInCard(@Nonnull ItemStack cardItem, @Nonnull String amount) {
        if (!cardItem.hasItemMeta()) {
            return;
        }
        ItemMeta cardItemMeta = cardItem.getItemMeta();
        PersistentDataContainer persistentDataContainer = cardItemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(ITEM_KEY, PersistentDataType.STRING) && persistentDataContainer.has(AMOUNT_KEY, PersistentDataType.STRING)) {
            if (StringNumberUtil.easilyCompare(amount, StringNumberUtil.ZERO) == 1) {
                persistentDataContainer.set(AMOUNT_KEY, PersistentDataType.STRING, amount);
            } else {
                persistentDataContainer.remove(ITEM_KEY);
                persistentDataContainer.remove(AMOUNT_KEY);
            }
        }
        cardItem.setItemMeta(cardItemMeta);
    }
}
