package io.taraxacum.finaltech.core.items.usable.accelerate;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.taraxacum.finaltech.util.TextUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class MatrixMachineActivateCard extends AbstractMachineActivateCard {
    private static final int TIMES = 21600;
    private static final double ENERGY = Integer.MAX_VALUE / 2 + 0.5;

    public MatrixMachineActivateCard(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected int times() {
        return TIMES;
    }

    @Override
    protected double energy() {
        return ENERGY;
    }

    @Override
    protected boolean consume() {
        return true;
    }

    @Override
    protected boolean conditionMatch(@Nonnull Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2, 1));
        player.setTotalExperience(0);
        player.setLevel(0);
        player.setExp(0);
        player.setSaturation(0);
        player.leaveVehicle();
        player.setFlying(false);
        player.setVelocity(new Vector(0, 0, 0));
        GameMode gameMode = player.getGameMode();
        player.setGameMode(GameMode.SURVIVAL);
        player.setInvulnerable(false);
        for (int i = 0; i < 48; i++) {
            player.setHealth(0);
            if (player.isDead()) {
                player.setGameMode(gameMode);
                return true;
            }
            player.damage(player.getMaxHealth());
            if (player.isDead()) {
                player.setGameMode(gameMode);
                return true;
            }
            player.damage(Integer.MAX_VALUE / 48);
            if (player.isDead()) {
                player.setGameMode(gameMode);
                return true;
            }
        }
        player.setGameMode(gameMode);
        return true;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerDescriptiveRecipe(TextUtil.COLOR_INITIATIVE + "????????????",
                "",
                TextUtil.COLOR_ACTION + "[??????] " + TextUtil.COLOR_NORMAL + "????????????",
                TextUtil.COLOR_NORMAL + "???????????? " + TextUtil.COLOR_NUMBER + TIMES + "???",
                TextUtil.COLOR_NORMAL + "????????????????????? ?????? " + TextUtil.COLOR_NUMBER + (int)(Math.floor(ENERGY)) + "J + " + String.format("%.2f", (ENERGY - Math.floor(ENERGY)) * 100) + "%J" + TextUtil.COLOR_NORMAL + " ?????????",
                TextUtil.COLOR_NEGATIVE + "????????????????????????????????????",
                TextUtil.COLOR_NEGATIVE + "?????????????????? ?????? ????????? ??? ?????? ?????????",
                TextUtil.COLOR_NEGATIVE + "?????????");
    }
}
