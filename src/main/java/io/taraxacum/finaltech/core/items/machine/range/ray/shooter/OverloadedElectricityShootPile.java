package io.taraxacum.finaltech.core.items.machine.range.ray.shooter;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.taraxacum.finaltech.api.interfaces.AntiAccelerationMachine;
import io.taraxacum.finaltech.util.SlimefunUtil;
import io.taraxacum.common.util.StringNumberUtil;
import io.taraxacum.finaltech.util.TextUtil;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.inventory.ItemStack;

/**
 * @author Final_ROOT
 * @since 1.0
 */
public class OverloadedElectricityShootPile extends AbstractElectricityShootPile implements AntiAccelerationMachine {
    public static final int RANGE = 16;

    public OverloadedElectricityShootPile(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getRange() {
        return RANGE;
    }

    @Override
    protected Function doFunction(Summary summary) {
        return location -> {
            if (summary.getCapacitorEnergy() <= 0) {
                return -1;
            }
            if (BlockStorage.hasBlockInfo(location)) {
                Config energyComponentConfig = BlockStorage.getLocationInfo(location);
                if (energyComponentConfig.contains(SlimefunUtil.KEY_ID)) {
                    SlimefunItem energyComponentItem = SlimefunItem.getById(energyComponentConfig.getString(SlimefunUtil.KEY_ID));
                    if (energyComponentItem instanceof EnergyNetComponent && !EnergyNetComponentType.CAPACITOR.equals(((EnergyNetComponent) energyComponentItem).getEnergyComponentType())) {
                        int componentEnergy = Integer.parseInt(SlimefunUtil.getCharge(energyComponentConfig));
                        int componentCapacity = Integer.MAX_VALUE;
                        int transferEnergy = Math.max(componentCapacity - componentEnergy, 0) / 2;
                        if (transferEnergy == 0) {
                            return 0;
                        }
                        transferEnergy = Math.min(transferEnergy, summary.getCapacitorEnergy());
                        SlimefunUtil.setCharge(location, String.valueOf(componentEnergy + transferEnergy * 2));
                        summary.setCapacitorEnergy(summary.getCapacitorEnergy() - transferEnergy);
                        summary.setEnergyCharge(StringNumberUtil.add(summary.getEnergyCharge(), String.valueOf(transferEnergy)));
                        summary.setEnergyCharge(StringNumberUtil.add(summary.getEnergyCharge(), String.valueOf(transferEnergy)));
                        return 1;
                    }
                }
            }
            return 0;
        };
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerDescriptiveRecipe(TextUtil.COLOR_PASSIVE + "??????",
                "",
                TextUtil.COLOR_NORMAL + "?????????????????????????????????",
                TextUtil.COLOR_NORMAL + "?????? ???????????? ?????????",
                TextUtil.COLOR_NORMAL + "??????????????????????????????????????? " + TextUtil.COLOR_NUMBER + this.getRange() +"???" + TextUtil.COLOR_NORMAL + " ??????",
                TextUtil.COLOR_NEGATIVE + "?????????????????????");
        this.registerDescriptiveRecipe(TextUtil.COLOR_PASSIVE + "???????????????",
                "",
                TextUtil.COLOR_NORMAL + "????????? ????????????????????????????????????",
                TextUtil.COLOR_NORMAL + "????????????= " + TextUtil.COLOR_NUMBER + "200%");
    }
}
