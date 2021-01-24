package net.mehvahdjukaar.supplementaries.mixins;

import net.mehvahdjukaar.supplementaries.common.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxTileEntity.class)
public class ShulkerBoxTileEntityMixin {


    @Inject(method = "canInsertItem", at = @At("HEAD"), cancellable = true)
    public void canInsertItem(int index, ItemStack itemStackIn, Direction direction, CallbackInfoReturnable<Boolean> info ) {
        ITag<Item> t = ItemTags.getCollection().get(Resources.SHULKER_BLACKLIST_TAG);
        if(t!=null && itemStackIn.getItem().isIn(t))
            info.setReturnValue(false);
    }
}