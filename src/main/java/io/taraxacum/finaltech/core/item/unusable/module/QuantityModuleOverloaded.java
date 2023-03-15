package io.taraxacum.finaltech.core.item.unusable.module;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.interfaces.RecipeItem;
import io.taraxacum.finaltech.util.ConfigUtil;
import io.taraxacum.finaltech.util.RecipeUtil;
import org.bukkit.inventory.ItemStack;

/**
 * @author Final_ROOT
 * @since 2.4
 */
public class QuantityModuleOverloaded extends AbstractQuantityModule implements RecipeItem {
    private final int baseEfficiency = ConfigUtil.getOrDefaultItemSetting(1, this, "base-efficiency");
    private final int randomEfficiency = ConfigUtil.getOrDefaultItemSetting(4, this, "random-efficiency");

    public QuantityModuleOverloaded(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getEffect(int itemAmount) {
        return itemAmount * baseEfficiency + FinalTech.getRandom().nextInt(itemAmount * randomEfficiency);
    }

    @Override
    public void registerDefaultRecipes() {
        RecipeUtil.registerDescriptiveRecipe(FinalTech.getLanguageManager(), this);
    }
}