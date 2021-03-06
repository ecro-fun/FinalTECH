package io.taraxacum.finaltech.core.menu.function;

import io.taraxacum.common.util.StringNumberUtil;
import io.taraxacum.finaltech.core.items.machine.AbstractMachine;
import io.taraxacum.finaltech.core.items.machine.cargo.RemoteAccessor;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import io.taraxacum.finaltech.util.ParticleUtil;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class RemoteAccessorMenu extends AbstractMachineMenu {
    private static final int[] BORDER = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] INPUT_BORDER = new int[0];
    private static final int[] OUTPUT_BORDER = new int[0];
    private static final int[] INPUT_SLOT = new int[0];
    private static final int[] OUTPUT_SLOT = new int[0];
    public RemoteAccessorMenu(@Nonnull AbstractMachine machine) {
        super(machine);
    }

    @Override
    protected int[] getBorder() {
        return BORDER;
    }

    @Override
    protected int[] getInputBorder() {
        return INPUT_BORDER;
    }

    @Override
    protected int[] getOutputBorder() {
        return OUTPUT_BORDER;
    }

    @Override
    public int[] getInputSlot() {
        return INPUT_SLOT;
    }

    @Override
    public int[] getOutputSlot() {
        return OUTPUT_SLOT;
    }

    @Override
    public void newInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block block) {
        super.newInstance(blockMenu, block);
        blockMenu.addMenuOpeningHandler(p -> {
            String value = BlockStorage.getLocationInfo(block.getLocation(), RemoteAccessor.KEY);
            if(value == null) {
                value = RemoteAccessor.THRESHOLD;
            }
            if(StringNumberUtil.compare(value, StringNumberUtil.ZERO) <= 0) {
                p.closeInventory();
                return;
            }
            BlockStorage.addBlockInfo(block, RemoteAccessor.KEY, StringNumberUtil.sub(value));

            BlockData blockData = block.getState().getBlockData();
            List<Block> blockList = new ArrayList<>();
            if(blockData instanceof Directional) {
                BlockFace blockFace = ((Directional) blockData).getFacing();
                Block targetBlock = block;
                for(int i = 0; i < RemoteAccessor.SEARCH_LIMIT; i++) {
                    targetBlock = targetBlock.getRelative(blockFace);
                    blockList.add(targetBlock);
                    if(BlockStorage.hasInventory(targetBlock)) {
                        BlockMenu targetBlockMenu = BlockStorage.getInventory(targetBlock);
                        if(targetBlockMenu.canOpen(targetBlock, p)) {
                            ParticleUtil.drawCubeByBlock(Particle.COMPOSTER, 0, blockList);
                            blockMenu.close();
                            targetBlockMenu.open(p);
                            return;
                        }
                    }
                }
            }
            blockMenu.close();
        });
    }

    @Override
    protected void updateMenu(@Nonnull BlockMenu blockMenu, @Nonnull Block block) {

    }
}
