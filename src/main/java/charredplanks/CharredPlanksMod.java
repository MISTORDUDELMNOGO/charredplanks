package charredplanks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharredPlanksMod implements ModInitializer {
    public static final String MOD_ID = "charredplanks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block CHARRED_PLANKS = new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f));

    @Override
    public void onInitialize() {
        Identifier blockId = Identifier.of(MOD_ID, "charred_planks");

        Registry.register(Registries.BLOCK, blockId, CHARRED_PLANKS);
        Registry.register(Registries.ITEM, blockId, new BlockItem(CHARRED_PLANKS, new Item.Settings()));

        LOGGER.info("Проект загружен успешно");
    }
}