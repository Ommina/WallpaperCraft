package net.ommina.wallpapercraft.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public abstract class SpecialRecipe implements ICraftingRecipe {

    private final ResourceLocation id;

    public SpecialRecipe ( final ResourceLocation resource ) {
        this.id = resource;
    }

    @Nonnull
    public ResourceLocation getId () {
        return this.id;
    }

    public boolean isDynamic () {
        return true;
    }

    @Nonnull
    public ItemStack getRecipeOutput () {
        return ItemStack.EMPTY;
    }

}
