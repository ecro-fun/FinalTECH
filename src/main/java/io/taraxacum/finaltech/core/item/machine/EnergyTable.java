package io.taraxacum.finaltech.core.item.machine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.taraxacum.common.util.StringNumberUtil;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.interfaces.RecipeItem;
import io.taraxacum.finaltech.core.item.usable.EnergyCard;
import io.taraxacum.finaltech.core.item.usable.PortableEnergyStorage;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.core.menu.machine.EnergyTableMenu;
import io.taraxacum.finaltech.util.MachineUtil;
import io.taraxacum.finaltech.util.RecipeUtil;
import io.taraxacum.libs.plugin.dto.LocationData;
import io.taraxacum.libs.plugin.util.InventoryUtil;
import io.taraxacum.libs.plugin.util.ItemStackUtil;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigInteger;

/**
 * @author Final_ROOT
 */
public class EnergyTable extends AbstractMachine implements RecipeItem {
    public EnergyTable(@Nonnull ItemGroup itemGroup, @Nonnull SlimefunItemStack item, @Nonnull RecipeType recipeType, @Nonnull ItemStack[] recipe) {
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
        return MachineUtil.simpleBlockBreakerHandler(FinalTech.getLocationDataService(), this, EnergyTableMenu.CARD_SLOT);
    }

    @Nullable
    @Override
    protected AbstractMachineMenu setMachineMenu() {
        return new EnergyTableMenu(this);
    }

    @Override
    protected void tick(@Nonnull Block block, @Nonnull SlimefunItem slimefunItem, @Nonnull LocationData locationData) {
        Inventory inventory = FinalTech.getLocationDataService().getInventory(locationData);
        if(inventory == null) {
            return;
        }

        boolean doInput = !InventoryUtil.isEmpty(inventory, this.getInputSlot());
        boolean doOutput = InventoryUtil.isEmpty(inventory, this.getOutputSlot());

        if(!doInput && !doOutput) {
            return;
        }

        ItemStack energyStorageItem = inventory.getItem(EnergyTableMenu.CARD_SLOT);
        if(ItemStackUtil.isItemNull(energyStorageItem) || energyStorageItem.getAmount() > 1 || !(SlimefunItem.getByItem(energyStorageItem) instanceof PortableEnergyStorage portableEnergyStorage)) {
            return;
        }

        String energy = portableEnergyStorage.getEnergy(energyStorageItem);

        if(!doInput && StringNumberUtil.ZERO.equals(energy)) {
            return;
        }

        boolean update = false;
        if(doInput) {
            ItemStack itemStack = inventory.getItem(this.getInputSlot()[0]);
            if(SlimefunItem.getByItem(itemStack) instanceof EnergyCard energyCard) {
                String cardEnergy = energyCard.getEnergy();
                energy = StringNumberUtil.add(energy, StringNumberUtil.mul(cardEnergy, String.valueOf(itemStack.getAmount())));
                itemStack.setAmount(0);
                update = true;
            }
        }

        if(doOutput) {
            EnergyCard energyCard = EnergyCard.getByEnergy(energy);
            if(energyCard != null && StringNumberUtil.compare(energy, energyCard.getEnergy()) >= 0) {
                String count = new BigInteger(energy).divide(new BigInteger(energyCard.getEnergy())).toString();
                count = StringNumberUtil.min(count, String.valueOf(energyCard.getItem().getMaxStackSize()));
                if(InventoryUtil.tryPushAllItem(inventory, this.getOutputSlot(), Integer.parseInt(count), energyCard.getItem())) {
                    energy = StringNumberUtil.sub(energy, StringNumberUtil.mul(energyCard.getEnergy(), count));
                    update = true;
                }
            }
        }

        if(update) {
            portableEnergyStorage.setEnergy(energyStorageItem, energy);
            portableEnergyStorage.updateLore(energyStorageItem);
        }
    }

    @Override
    protected boolean isSynchronized() {
        return false;
    }

    @Override
    public void registerDefaultRecipes() {
        RecipeUtil.registerDescriptiveRecipe(FinalTech.getLanguageManager(), this);
    }
}
