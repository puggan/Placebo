package shadows.placebo.loot;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.StandaloneLootEntry;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.functions.ILootFunction;

public class LambdaLootEntry extends StandaloneLootEntry {

	private final BiConsumer<Consumer<ItemStack>, LootContext> loot;

	public LambdaLootEntry(BiConsumer<Consumer<ItemStack>, LootContext> loot, int weight, int quality) {
		super(weight, quality, new ILootCondition[0], new ILootFunction[0]);
		this.loot = loot;
	}

	@Override
	protected void func_216154_a(Consumer<ItemStack> list, LootContext ctx) {
		loot.accept(list, ctx);
	}

}
