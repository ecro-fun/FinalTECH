package io.taraxacum.finaltech.core.items.machine.standard;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.taraxacum.finaltech.api.interfaces.AntiAccelerationMachine;
import io.taraxacum.finaltech.core.items.unusable.CopyCardItem;
import io.taraxacum.finaltech.core.menu.standard.AbstractStandardMachineMenu;
import io.taraxacum.finaltech.core.menu.standard.ItemDeserializeParserMenu;
import io.taraxacum.finaltech.util.ItemStackUtil;
import io.taraxacum.finaltech.util.StringItemUtil;
import io.taraxacum.finaltech.util.TextUtil;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This is a slimefun machine
 * it will be used in gameplay
 * It's not a function class!
 * @author Final_ROOT
 * @since 1.0
 */
public class ItemDeserializeParser extends AbstractStandardMachine implements AntiAccelerationMachine {
    public ItemDeserializeParser(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    protected AbstractStandardMachineMenu setMachineMenu() {
        return new ItemDeserializeParserMenu(this);
    }

    @Override
    protected void tick(@Nonnull Block block, @Nonnull SlimefunItem slimefunItem, @Nonnull Config config) {
        BlockMenu blockMenu = BlockStorage.getInventory(block);
        for (int slot : this.getInputSlot()) {
            ItemStack item = blockMenu.getItemInSlot(slot);
            if (CopyCardItem.isValid(item)) {
                ItemStack stringItem = StringItemUtil.parseItemInCard(item);
                if (!ItemStackUtil.isItemNull(stringItem)) {
                    stringItem.setAmount(item.getAmount());
                    blockMenu.pushItem(stringItem, this.getOutputSlot());
                }
            }
        }
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerDescriptiveRecipe(TextUtil.COLOR_PASSIVE + "??????",
                "",
                TextUtil.COLOR_NORMAL + "???????????????",
                TextUtil.COLOR_NORMAL + "??? " + TextUtil.COLOR_NUMBER + String.format("%.2f", Slimefun.getTickerTask().getTickRate() / 20.0) + "???" + TextUtil.COLOR_NORMAL + " ???????????????????????????????????????",
                TextUtil.COLOR_NORMAL + "????????????????????????????????????????????????????????????");
    }
}
