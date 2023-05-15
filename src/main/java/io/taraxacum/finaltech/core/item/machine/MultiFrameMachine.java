package io.taraxacum.finaltech.core.item.machine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.taraxacum.common.util.JavaUtil;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.finaltech.core.interfaces.RecipeItem;
import io.taraxacum.finaltech.core.dto.SimpleCargoDTO;
import io.taraxacum.finaltech.core.option.*;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.core.menu.machine.MultiFrameMachineMenu;
import io.taraxacum.finaltech.util.CargoUtil;
import io.taraxacum.finaltech.util.ConfigUtil;
import io.taraxacum.finaltech.util.MachineUtil;
import io.taraxacum.finaltech.util.RecipeUtil;
import io.taraxacum.libs.plugin.dto.AdvancedMachineRecipe;
import io.taraxacum.libs.plugin.dto.InvWithSlots;
import io.taraxacum.libs.plugin.util.InventoryUtil;
import io.taraxacum.libs.plugin.util.ItemStackUtil;
import io.taraxacum.libs.slimefun.dto.AdvancedCraft;
import io.taraxacum.libs.plugin.dto.LocationData;
import io.taraxacum.libs.slimefun.dto.MachineRecipeFactory;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Final_ROOT
 * @since 2.2
 */
public class MultiFrameMachine extends AbstractMachine implements RecipeItem {
    private final String[] offsetKeys = new String[] {"o1", "o2", "o3", "o4", "o5", "o6"};
    private final List<String> allowedIdList = ConfigUtil.getItemStringList(this, "allowed-id");

    public MultiFrameMachine(@Nonnull ItemGroup itemGroup, @Nonnull SlimefunItemStack item, @Nonnull RecipeType recipeType, @Nonnull ItemStack[] recipe) {
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
        return new MultiFrameMachineMenu(this);
    }

    @Override
    protected void tick(@Nonnull Block block, @Nonnull SlimefunItem slimefunItem, @Nonnull LocationData locationData) {
        Inventory inventory = FinalTech.getLocationDataService().getInventory(locationData);
        if(inventory == null) {
            return;
        }

        int point = 0;
        int offset;
        List<AdvancedMachineRecipe> availableRecipe;

        int machineSlot;
        ItemStack machineItem;
        SlimefunItem machineSfItem;
        AdvancedCraft advancedCraft;

        List<int[]> inputs = new ArrayList<>();
        List<int[]> outputs = new ArrayList<>();

        for(int i = 0; i < MultiFrameMachineMenu.MACHINE_SLOT.length; i++) {
            machineSlot = MultiFrameMachineMenu.MACHINE_SLOT[i];
            machineItem = inventory.getItem(machineSlot);
            if(!ItemStackUtil.isItemNull(machineItem)) {
                machineSfItem = SlimefunItem.getByItem(machineItem);
                if(machineSfItem != null && this.allowedIdList.contains(machineSfItem.getId())) {
                    InventoryUtil.stockSlots(inventory, MultiFrameMachineMenu.WORK_INPUT_SLOT[point][i]);

                    if(InventoryUtil.slotCount(inventory, MultiFrameMachineMenu.WORK_OUTPUT_SLOT[point][i]) < MultiFrameMachineMenu.WORK_OUTPUT_SLOT[point][i].length) {
                        offset = Integer.parseInt(JavaUtil.getFirstNotNull(FinalTech.getLocationDataService().getLocationData(locationData, this.offsetKeys[i]), "0"));
                        availableRecipe = MachineRecipeFactory.getInstance().getAdvancedRecipe(machineSfItem.getId());
                        advancedCraft = AdvancedCraft.craftAsc(inventory, MultiFrameMachineMenu.WORK_INPUT_SLOT[point][i], availableRecipe, machineItem.getAmount(), offset);
                        if(advancedCraft != null) {
                            int pushedAmount = InventoryUtil.tryPushItem(inventory, MultiFrameMachineMenu.WORK_OUTPUT_SLOT[point][i], advancedCraft.getMatchCount(), advancedCraft.getOutputItemList());
                            if(pushedAmount > 0) {
                                advancedCraft.setMatchCount(pushedAmount);
                                advancedCraft.consumeItem(inventory);
                                FinalTech.getLocationDataService().setLocationData(locationData, this.offsetKeys[i], String.valueOf(advancedCraft.getOffset()));
                            }
                        }
                    }

                    InventoryUtil.stockSlots(inventory, MultiFrameMachineMenu.WORK_OUTPUT_SLOT[point][i]);

                    inputs.add(MultiFrameMachineMenu.WORK_INPUT_SLOT[point][i]);
                    outputs.add(MultiFrameMachineMenu.WORK_OUTPUT_SLOT[point][i]);
                    point = i + 1;
                }
            }
        }

        if(inputs.size() > 1) {
            SimpleCargoDTO simpleCargoDTO = new SimpleCargoDTO();
            simpleCargoDTO.setInputBlock(block);
            simpleCargoDTO.setInputSize(SlotSearchSize.VALUE_OUTPUTS_ONLY);
            simpleCargoDTO.setInputOrder(SlotSearchOrder.VALUE_ASCENT);
            simpleCargoDTO.setOutputBlock(block);
            simpleCargoDTO.setOutputSize(SlotSearchSize.VALUE_INPUTS_ONLY);
            simpleCargoDTO.setOutputOrder(SlotSearchOrder.VALUE_ASCENT);
            simpleCargoDTO.setCargoNumber(3456);
            simpleCargoDTO.setCargoLimit(CargoLimit.VALUE_ALL);
            simpleCargoDTO.setCargoFilter(CargoFilter.VALUE_BLACK);
            simpleCargoDTO.setFilterInv(inventory);
            simpleCargoDTO.setFilterSlots(new int[0]);

            for(int i = 0; i < inputs.size() - 1; i++) {
                simpleCargoDTO.setInputMap(new InvWithSlots(inventory, outputs.get(i)));
                simpleCargoDTO.setOutputMap(new InvWithSlots(inventory, inputs.get((i + 1) % outputs.size())));
                CargoUtil.doSimpleCargoWeakSymmetry(simpleCargoDTO);
            }
        }
        super.tick(block, slimefunItem, locationData);
    }

    @Override
    protected boolean isSynchronized() {
        return false;
    }

    @Override
    public void registerDefaultRecipes() {
        RecipeUtil.registerDescriptiveRecipeWithBorder(FinalTech.getLanguageManager(), this);

        for(String id : this.allowedIdList) {
            SlimefunItem slimefunItem = SlimefunItem.getById(id);
            if(slimefunItem != null) {
                this.registerDescriptiveRecipe(slimefunItem.getRecipeOutput());
            }
        }
    }
}
