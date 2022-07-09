package net.mehvahdjukaar.supplementaries;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import java.util.List;

public class ForgeHelper {

    @ExpectPlatform
    public static boolean canEntityDestroy(Level level, BlockPos blockPos, Animal animal) {
        throw new AssertionError();
    }
    //TODO: fabric
    @ExpectPlatform
    public static void openContainerScreen(ServerPlayer player, MenuProvider menuProvider, BlockPos pos) {
        throw new AssertionError();
    }

    // TODO: fabric
    @ExpectPlatform
    public static boolean onExplosionStart(Level level, Explosion explosion) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void onExplosionDetonate(Level level, Explosion explosion, List<Entity> entities, double diameter) {
        throw new AssertionError();
    }
}
