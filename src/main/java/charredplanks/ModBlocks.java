package charredplanks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CHARRED_PLANKS = Registry.register(
            Registries.BLOCK,
            Identifier.of(CharredPlanksMod.MOD_ID, "charred_planks"),
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)));

    public static final Item CHARRED_PLANKS_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of(CharredPlanksMod.MOD_ID, "charred_planks"),
            new BlockItem(CHARRED_PLANKS, new Item.Settings()));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> entries.add(CHARRED_PLANKS_ITEM));
    }
}
