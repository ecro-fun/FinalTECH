package io.taraxacum.finaltech.core.item.machine.unit;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.interfaces.RecipeItem;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.core.menu.unit.DividedStorageUnitMenu;
import io.taraxacum.finaltech.util.MachineUtil;
import io.taraxacum.finaltech.util.RecipeUtil;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author Final_ROOT
 */
public class DividedStorageUnit extends AbstractStorageUnit implements RecipeItem {
    public DividedStorageUnit(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    protected AbstractMachineMenu setMachineMenu() {
        return new DividedStorageUnitMenu(this);
    }

    @Override
    public void registerDefaultRecipes() {
        RecipeUtil.registerDescriptiveRecipe(FinalTech.getLanguageManager(), this,
                String.valueOf(MachineUtil.calMachineSlotSize(this)),
                String.valueOf(this.getInputSlot().length),
                String.valueOf(this.getOutputSlot().length));
    }
}
