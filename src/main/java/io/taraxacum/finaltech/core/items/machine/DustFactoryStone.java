package io.taraxacum.finaltech.core.items.machine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.taraxacum.common.util.JavaUtil;
import io.taraxacum.finaltech.api.interfaces.RecipeItem;
import io.taraxacum.finaltech.api.dto.ItemStackWithWrapper;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.core.menu.machine.OrderedDustFactoryStoneMenu;
import io.taraxacum.finaltech.setup.FinalTechItems;
import io.taraxacum.finaltech.util.ItemStackUtil;
import io.taraxacum.finaltech.util.MachineUtil;
import io.taraxacum.finaltech.util.TextUtil;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class DustFactoryStone extends AbstractMachine implements RecipeItem {
    public DustFactoryStone(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    protected BlockPlaceHandler onBlockPlace() {
        return MachineUtil.BLOCK_PLACE_HANDLER_PLACER_DENY;
    }

    @Nonnull
    @Override
    protected BlockBreakHandler onBlockBreak() {
        return MachineUtil.simpleBlockBreakerHandler(this);
    }

    @Nonnull
    @Override
    protected AbstractMachineMenu setMachineMenu() {
        return new OrderedDustFactoryStoneMenu(this);
    }

    @Override
    protected void tick(@Nonnull Block block, @Nonnull SlimefunItem slimefunItem, @Nonnull Config config) {
        BlockMenu blockMenu = BlockStorage.getInventory(block);
        if(MachineUtil.itemCount(blockMenu, this.getInputSlot()) != this.getInputSlot().length) {
            return;
        }
        Set<Integer> amountList = new HashSet<>(this.getInputSlot().length);
        ItemStackWithWrapper firstItem = new ItemStackWithWrapper(blockMenu.getItemInSlot(this.getInputSlot()[0]));
        boolean allSameItem = true;
        for (int slot : this.getInputSlot()) {
            ItemStack item = blockMenu.getItemInSlot(slot);
            amountList.add(item.getAmount());
            if(allSameItem && !ItemStackUtil.isItemSimilar(firstItem, item)) {
                allSameItem = false;
            }
        }
        for (int slot : this.getInputSlot()) {
            blockMenu.replaceExistingItem(slot, ItemStackUtil.AIR);
        }
        if (amountList.size() == this.getInputSlot().length && allSameItem) {
            blockMenu.pushItem(FinalTechItems.ORDERED_DUST.clone(), JavaUtil.shuffle(this.getOutputSlot()));
        } else if (Math.random() < (double)(amountList.size()) / this.getInputSlot().length) {
            blockMenu.pushItem(FinalTechItems.UNORDERED_DUST.clone(), JavaUtil.shuffle(this.getOutputSlot()));
        }
    }

    @Override
    protected boolean isSynchronized() {
        return false;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerDescriptiveRecipe(TextUtil.COLOR_PASSIVE + "?????? " + FinalTechItems.UNORDERED_DUST.getDisplayName(),
                "",
                TextUtil.COLOR_NORMAL + "?????????????????????????????? " + TextUtil.COLOR_NUMBER + this.getInputSlot().length + "???"  + TextUtil.COLOR_NORMAL + " ?????????????????????",
                TextUtil.COLOR_NORMAL + "??????????????????",
                TextUtil.COLOR_NORMAL + "??????????????????????????? ???????????? " + TextUtil.COLOR_NUMBER + String.format("%.2f", 100.0 / this.getInputSlot().length) + "%" + TextUtil.COLOR_NORMAL + " ??????????????? " + FinalTechItems.UNORDERED_DUST.getDisplayName());
        this.registerDescriptiveRecipe(TextUtil.COLOR_PASSIVE + "&f?????? " + FinalTechItems.ORDERED_DUST.getDisplayName(),
                "",
                TextUtil.COLOR_NORMAL + "?????????????????????????????? " + TextUtil.COLOR_NUMBER + this.getInputSlot().length + "???"  + TextUtil.COLOR_NORMAL + " ?????????????????????",
                TextUtil.COLOR_NORMAL + "??????????????????",
                TextUtil.COLOR_NORMAL + "????????????????????????????????????????????? ?????????????????????????????????",
                TextUtil.COLOR_NORMAL + "?????? " + FinalTechItems.ORDERED_DUST.getDisplayName());
    }
}
