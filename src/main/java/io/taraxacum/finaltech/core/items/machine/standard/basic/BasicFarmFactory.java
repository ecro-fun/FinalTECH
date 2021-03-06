package io.taraxacum.finaltech.core.items.machine.standard.basic;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Final_ROOT
 * @since 1.0
 */
public class BasicFarmFactory extends AbstractBasicMachine {
    public BasicFarmFactory(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.OAK_LOG, 20)}, new ItemStack[] { new ItemStack(Material.OAK_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.SPRUCE_LOG, 20)}, new ItemStack[] { new ItemStack(Material.SPRUCE_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.BIRCH_LOG, 20)}, new ItemStack[] { new ItemStack(Material.BIRCH_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.JUNGLE_LOG, 20)}, new ItemStack[] { new ItemStack(Material.JUNGLE_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.ACACIA_LOG, 20)}, new ItemStack[] { new ItemStack(Material.ACACIA_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.DARK_OAK_LOG, 20)}, new ItemStack[] { new ItemStack(Material.DARK_OAK_LOG, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.CRIMSON_STEM, 20)}, new ItemStack[] { new ItemStack(Material.CRIMSON_STEM, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.WARPED_STEM, 20)}, new ItemStack[] { new ItemStack(Material.WARPED_STEM, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.PUMPKIN, 20)}, new ItemStack[] { new ItemStack(Material.PUMPKIN, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.WHEAT, 20)}, new ItemStack[] { new ItemStack(Material.WHEAT, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.CARROT, 20)}, new ItemStack[] { new ItemStack(Material.CARROT, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.POTATO, 20)}, new ItemStack[] { new ItemStack(Material.POTATO, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.MELON, 20)}, new ItemStack[] { new ItemStack(Material.MELON, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.BEETROOT, 20)}, new ItemStack[] { new ItemStack(Material.BEETROOT, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.SWEET_BERRIES, 20)}, new ItemStack[] { new ItemStack(Material.SWEET_BERRIES, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.GLOW_BERRIES, 20)}, new ItemStack[] { new ItemStack(Material.GLOW_BERRIES, 24)});
        this.registerRecipe(0, new ItemStack[] { new ItemStack(Material.DIRT, 20), new ItemStack(Material.COCOA_BEANS, 20)}, new ItemStack[] { new ItemStack(Material.COCOA_BEANS, 24)});
    }
}
