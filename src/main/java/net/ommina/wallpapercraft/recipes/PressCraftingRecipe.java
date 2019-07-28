package net.ommina.wallpapercraft.recipes;

import com.google.gson.JsonObject;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.DecorativeBlock;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.items.*;

import javax.annotation.Nonnull;

public class PressCraftingRecipe implements ICraftingRecipe {

    public static final ResourceLocation NAME = Wallpapercraft.getId( "presscrafting" );
    public static final Serializer SERIALIZER = new Serializer();

    private final ResourceLocation id;

    public PressCraftingRecipe( final ResourceLocation id ) {
        this.id = id;
    }

    @Override
    public boolean matches( @Nonnull final CraftingInventory inv, @Nonnull final World world ) {

        int patternPressCount = 0;
        int colourPressCount = 0;
        int variantPressCount = 0;
        int decorativeCount = 0;

        for( int k = 0; k < inv.getSizeInventory(); k++ ) {

            final ItemStack stack = inv.getStackInSlot( k );

            if( !stack.isEmpty() ) {

                if( stack.getItem() instanceof PressPattern ) {
                    patternPressCount++;
                } else if( stack.getItem() instanceof PressColour ) {
                    colourPressCount++;
                } else if( stack.getItem() instanceof PressVariant ) {
                    variantPressCount++;
                } else {
                    if( !(stack.getItem() instanceof DecorativeItem) ) {
                        return false;
                    }
                    decorativeCount++;
                }

                if( decorativeCount > 1 || patternPressCount > 1 || colourPressCount > 1 || variantPressCount > 1 ) {
                    return false;
                }

            }
        }

        return decorativeCount == 1 && (patternPressCount == 1 || colourPressCount == 1 || variantPressCount == 1);

    }

    @Override
    @Nonnull
    public ItemStack getCraftingResult( @Nonnull final CraftingInventory inv ) {

        String pattern = "";
        String colour = "";
        String suffix = "";

        boolean hasChanged = false;

        for( int i = 0; i < inv.getSizeInventory(); i++ ) {

            final ItemStack stack = inv.getStackInSlot( i );

            if( !stack.isEmpty() && stack.getItem() instanceof DecorativeItem ) {

                final DecorativeBlock block = ModBlocks.BLOCKS.get( stack.getItem().getRegistryName().getPath() );

                if( block == null )
                    return ItemStack.EMPTY;

                pattern = block.getPattern();
                colour = block.getColour();
                suffix = block.getSuffix();

                break;

            }

        }

        for( int i = 0; i < inv.getSizeInventory(); i++ ) {

            final ItemStack stack = inv.getStackInSlot( i );

            if( !stack.isEmpty() && stack.getItem() instanceof Press ) {

                Press press = (Press) stack.getItem();

                if( press instanceof PressPattern ) {

                    pattern = press.getVariant();
                    hasChanged = true;

                } else if( press instanceof PressColour ) {

                    colour = press.getVariant();
                    hasChanged = true;

                } else if( press instanceof PressVariant ) {

                    suffix = press.getVariant();
                    hasChanged = true;

                }

            }

        }

        if( !hasChanged )
            return ItemStack.EMPTY;

        Item item = ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( pattern + colour + suffix ) );

        if( item == null )
            return ItemStack.EMPTY;

        return new ItemStack( item, 1 );

    }

    @Nonnull
    @Override
    public NonNullList<ItemStack> getRemainingItems( final CraftingInventory inv ) {

        final NonNullList<ItemStack> list = NonNullList.withSize( inv.getSizeInventory(), ItemStack.EMPTY );

        for( int i = 0; i < inv.getSizeInventory(); i++ ) {

            final ItemStack stack = inv.getStackInSlot( i );

            if( stack.getItem() instanceof Press ) {

                final ItemStack stack1 = stack.copy();
                stack1.setCount( 1 );
                list.set( i, stack1 );

            }

        }

        return list;
    }


    @Override
    public boolean canFit( final int width, final int height ) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isDynamic() {
        return true; // Don't show in recipe book
    }

    @Nonnull
    @Override
    public String getGroup() {
        return Wallpapercraft.MODID;
    }

    @Nonnull
    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<PressCraftingRecipe> {

        private Serializer() {

        }

        @Nonnull
        @Override
        public PressCraftingRecipe read( @Nonnull final ResourceLocation recipeId, @Nonnull final JsonObject json ) {

            return new PressCraftingRecipe( recipeId );

        }

        @Override
        public PressCraftingRecipe read( final ResourceLocation recipeId, final PacketBuffer buffer ) {
            return new PressCraftingRecipe( recipeId );
        }

        @Override
        public void write( PacketBuffer buffer, PressCraftingRecipe recipe ) {
        }

    }

}
