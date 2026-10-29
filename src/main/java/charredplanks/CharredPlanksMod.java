package charredplanks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharredPlanksMod implements ModInitializer {
    public static final String MOD_ID = "charredplanks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.initialize();

        // Дополнительное поведение: при клике пустой рукой по обугленным доскам выводим сообщение
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockState state = world.getBlockState(hitResult.getBlockPos());

            // Проверяем, что это наш блок, рука основная и она пустая
            if (!state.isOf(ModBlocks.CHARRED_PLANKS) || hand != Hand.MAIN_HAND
                    || !player.getStackInHand(hand).isEmpty()) {
                return ActionResult.PASS;
            }

            // Отправляем сообщение только на сервере, чтобы не дублировалось
            if (!world.isClient()) {
                player.sendMessage(Text.literal("Обугленные доски: тепло от угля"), false);
            }
            return ActionResult.SUCCESS;
        });

        LOGGER.info("Проект загружен успешно");
    }
}