package io.taraxacum.finaltech.core.inventory.simple;

import io.taraxacum.finaltech.core.inventory.AbstractOrdinaryMachineInventory;
import io.taraxacum.finaltech.core.item.machine.AbstractMachine;
import io.taraxacum.finaltech.core.option.Icon;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;

/**
 * @author Final_ROOT
 */
public class GeneratorMachineInventory extends AbstractOrdinaryMachineInventory {
    private final int[] border = new int[] {45, 46, 47, 51, 52, 53};
    private final int[] inputBorder = new int[] {48, 50};
    private final int[] outputBorder = new int[] {36, 37, 38, 39, 41, 42, 43, 44};
    private final int[] inputSlot = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
    private final int[] outputSlot = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

    public final int statusSlot = 40;
    public final int moduleSlot = 49;

    public GeneratorMachineInventory(@Nonnull AbstractMachine abstractMachine) {
        super(abstractMachine);
    }

    @Override
    protected int[] getBorder() {
        return this.border;
    }

    @Override
    protected int[] getInputBorder() {
        return this.inputBorder;
    }

    @Override
    protected int[] getOutputBorder() {
        return this.outputBorder;
    }

    @Nonnull
    @Override
    public int[] getInputSlot() {
        return this.inputSlot;
    }

    @Nonnull
    @Override
    public int[] getOutputSlot() {
        return this.outputSlot;
    }

    @Override
    public void updateInventory(@Nonnull Inventory inventory, @Nonnull Location location) {

    }

    @Override
    public int getSize() {
        return 54;
    }

    @Override
    protected void initSelf() {
        this.defaultItemStack.put(this.statusSlot, Icon.QUANTITY_MODULE_ICON);
    }
}