package io.taraxacum.finaltech.core.helper;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.taraxacum.finaltech.FinalTech;
import io.taraxacum.libs.slimefun.dto.BlockStorageHelper;
import io.taraxacum.libs.slimefun.dto.BlockStorageIconHelper;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public final class CargoFilter {
    public static final String KEY = "cf";

    public static final String VALUE_BLACK = "b";
    public static final String VALUE_WHITE = "w";

    public static final ItemStack FILTER_MODE_BLACK_ICON = new CustomItemStack(Material.BLACK_WOOL, FinalTech.getLanguageString("helper", "CARGO_FILTER", "black-filter-mode", "name"), FinalTech.getLanguageStringArray("helper", "CARGO_FILTER", "black-filter-mode", "lore"));
    public static final ItemStack FILTER_MODE_WHITE_ICON = new CustomItemStack(Material.WHITE_WOOL, FinalTech.getLanguageString("helper", "CARGO_FILTER", "white-filter-mode", "name"), FinalTech.getLanguageStringArray("helper", "CARGO_FILTER", "white-filter-mode", "lore"));

    public static final BlockStorageIconHelper HELPER = BlockStorageIconHelper.newInstanceOrGet(BlockStorageHelper.ID_CARGO, KEY, new LinkedHashMap<>() {{
        this.put(VALUE_BLACK, FILTER_MODE_BLACK_ICON);
        this.put(VALUE_WHITE, FILTER_MODE_WHITE_ICON);
    }});
}
