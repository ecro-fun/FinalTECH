package io.taraxacum.finaltech.core.item.machine.template.advanced;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.taraxacum.finaltech.util.RecipeUtil;
import org.bukkit.inventory.ItemStack;

/**
 * @author Final_ROOT
 */
public class AdvancedOreGrinder extends AbstractAdvanceMachine {
    public AdvancedOreGrinder(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void registerDefaultRecipes() {
        RecipeUtil.registerRecipeBySlimefunId(this, SlimefunItems.ELECTRIC_ORE_GRINDER.getItemId());
    }
}
