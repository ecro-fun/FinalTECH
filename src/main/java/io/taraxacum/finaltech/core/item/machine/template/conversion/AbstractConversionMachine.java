package io.taraxacum.finaltech.core.item.machine.template.conversion;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.libs.plugin.dto.AdvancedMachineRecipe;
import io.taraxacum.libs.plugin.dto.ItemWrapper;
import io.taraxacum.libs.plugin.dto.LocationData;
import io.taraxacum.libs.slimefun.dto.RandomMachineRecipe;
import io.taraxacum.finaltech.core.interfaces.RecipeItem;
import io.taraxacum.libs.slimefun.dto.MachineRecipeFactory;
import io.taraxacum.finaltech.core.option.Icon;
import io.taraxacum.finaltech.core.item.machine.AbstractMachine;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.core.menu.machine.ConversionMachineMenu;
import io.taraxacum.libs.plugin.util.ItemStackUtil;
import io.taraxacum.finaltech.util.MachineUtil;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author Final_ROOT
 */
public abstract class AbstractConversionMachine extends AbstractMachine implements RecipeItem {
    public AbstractConversionMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
        return MachineUtil.simpleBlockBreakerHandler(FinalTech.getLocationDataService(), this);
    }

    @Nonnull
    @Override
    protected AbstractMachineMenu setMachineMenu() {
        return new ConversionMachineMenu(this);
    }

    @Override
    protected void tick(@Nonnull Block block, @Nonnull SlimefunItem slimefunItem, @Nonnull LocationData locationData) {
        Inventory inventory = FinalTech.getLocationDataService().getInventory(locationData);
        if(inventory == null) {
            return;
        }
        boolean hasViewer = !inventory.getViewers().isEmpty();

        List<AdvancedMachineRecipe> advancedMachineRecipeList = MachineRecipeFactory.getInstance().getAdvancedRecipe(this.getId());
        int quantityModule = Icon.updateQuantityModule(inventory, hasViewer, ConversionMachineMenu.MODULE_SLOT, ConversionMachineMenu.STATUS_SLOT);
        ItemWrapper itemWrapper = new ItemWrapper();
        for (int slot : this.getInputSlot()) {
            ItemStack itemStack = inventory.getItem(slot);
            if (ItemStackUtil.isItemNull(itemStack) || itemStack.getAmount() > quantityModule) {
                continue;
            }
            itemWrapper.newWrap(itemStack);
            for (AdvancedMachineRecipe advancedMachineRecipe : advancedMachineRecipeList) {
                if (ItemStackUtil.isItemSimilar(itemWrapper, advancedMachineRecipe.getInput()[0])) {
                    int amount = itemStack.getAmount();
                    inventory.setItem(slot, advancedMachineRecipe.getOutput()[0].getItemStack());
                    ItemStack outputItemStack = inventory.getItem(slot);
                    outputItemStack.setAmount(amount);
                    break;
                }
            }
        }
    }

    @Override
    protected boolean isSynchronized() {
        return false;
    }

    @Override
    public void registerRecipe(@Nonnull MachineRecipe recipe) {
        if (recipe.getInput().length != 1) {
            throw new IllegalArgumentException("Register recipe for " + this.getItemName() + " has occurred a error: " + " input item type should be just one");
        }

        if (recipe.getInput()[0].getAmount() > 1) {
            this.getAddon().getJavaPlugin().getServer().getLogger().info("Register recipe for " + this.getItemName() + " has occurred a error: " + " input item amount should be one");
            recipe.getInput()[0] = new CustomItemStack(recipe.getInput()[0], 1);
        }

        if (recipe instanceof RandomMachineRecipe randomMachineRecipe) {
            for (RandomMachineRecipe.RandomOutput randomOutput : randomMachineRecipe.getRandomOutputs()) {
                if (randomOutput.getOutputItem().length != 1) {
                    throw new IllegalArgumentException("Register recipe for " + this.getItemName() + " has occurred a error: " + " output item type should be only just one");
                }
                if (randomOutput.getOutputItem()[0].getAmount() != 1) {
                    this.getAddon().getJavaPlugin().getServer().getLogger().info("Register recipe for " + this.getItemName() + " has occurred a error: " + " output item amount should be one");
                    randomOutput.getOutputItem()[0] = new CustomItemStack(randomOutput.getOutputItem()[0], 1);
                }
            }
        } else {
            for (int i = 0; i < 100; i++) {
                if (recipe.getOutput().length != 1) {
                    throw new IllegalArgumentException("Register recipe for " + this.getItemName() + " has occurred a error: " + " out item type should only just one");
                }
                if (recipe.getOutput()[0].getAmount() != 1) {
                    this.getAddon().getJavaPlugin().getServer().getLogger().info("Register recipe for " + this.getItemName() + " has occurred a error: " + " output item amount should be one");
                    recipe.getOutput()[0] = new CustomItemStack(recipe.getOutput()[0], 1);
                }
            }
        }

        RecipeItem.super.registerRecipe(recipe);
    }
}
