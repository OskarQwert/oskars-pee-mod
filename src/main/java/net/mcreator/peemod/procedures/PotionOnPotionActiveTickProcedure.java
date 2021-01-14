package net.mcreator.peemod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.peemod.PeemodModElements;

import java.util.Map;

@PeemodModElements.ModElement.Tag
public class PotionOnPotionActiveTickProcedure extends PeemodModElements.ModElement {
	public PotionOnPotionActiveTickProcedure(PeemodModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PotionOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PotionOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack lol = ItemStack.EMPTY;
		boolean airbelow = false;
		double xplayer = 0;
		double yplayer = 0;
		double zplayer = 0;
		xplayer = (double) (entity.getPosX());
		yplayer = (double) ((entity.getPosY()) - 1);
		zplayer = (double) (entity.getPosZ());
		airbelow = (boolean) (world.isAirBlock(new BlockPos((int) (xplayer), (int) (yplayer), (int) (zplayer))));
		if (((airbelow) == (false))) {
			world.setBlockState(new BlockPos((int) (xplayer), (int) (yplayer), (int) (zplayer)), Blocks.WATER.getDefaultState(), 3);
		}
	}
}
