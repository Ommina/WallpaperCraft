package net.ommina.wallpapercraft.recipes;

import com.google.gson.JsonObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.IDecorativeBlock;
import net.ommina.wallpapercraft.items.*;

import javax.annotation.Nonnull;

public class PressCraftingRecipe implements CraftingRecipe {

    public static final ResourceLocation NAME = Wallpapercraft.getId( "presscrafting" );
    public static final Serializer SERIALIZER = new Serializer();

    public static final RecipeType<PressCraftingRecipe> RECIPE_TYPE = new RecipeType<PressCraftingRecipe>() {
//region Overrides
        @Override
        public String toString() {
            return Wallpapercraft.getId( "presscrafting" ).toString();
        }
//endregion Overrides
    };

    private final ResourceLocation id;

    public PressCraftingRecipe( final ResourceLocation id ) {
        this.id = id;
    }

//region Overrides
    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public boolean matches( @Nonnull final CraftingContainer inv, @Nonnull final Level world ) {

        int patternPressCount = 0;
        int colourPressCount = 0;
        int variantPressCount = 0;
        int decorativeCount = 0;

        for ( int k = 0; k < inv.getContainerSize(); k++ ) {

            final ItemStack stack = inv.getItem( k );

            if ( !stack.isEmpty() ) {

                if ( stack.getItem() instanceof PressPattern ) {
                    patternPressCount++;
                } else if ( stack.getItem() instanceof PressColour ) {
                    colourPressCount++;
                } else if ( stack.getItem() instanceof PressVariant ) {
                    variantPressCount++;
                } else {
                    if ( !(stack.getItem() instanceof DecorativeItem) ) {
                        return false;
                    }
                    decorativeCount++;
                }

                if ( decorativeCount > 1 || patternPressCount > 1 || colourPressCount > 1 || variantPressCount > 1 ) {
                    return false;
                }

            }
        }

        return decorativeCount == 1 && (patternPressCount == 1 || colourPressCount == 1 || variantPressCount == 1);

    }

    @Override
    @Nonnull
    public ItemStack assemble( @Nonnull final CraftingContainer inv ) {

        String pattern = "";
        String colour = "";
        String suffix = "";
        String postfix = "";
        String sourceModNamespace = "";

        boolean hasChanged = false;

        for ( int i = 0; i < inv.getContainerSize(); i++ ) {

            final ItemStack stack = inv.getItem( i );

            if ( !stack.isEmpty() && stack.getItem() instanceof DecorativeItem ) {

                final Block block = ForgeRegistries.BLOCKS.getValue( stack.getItem().getRegistryName() );

                if ( !(block instanceof IDecorativeBlock) )
                    return ItemStack.EMPTY;

                sourceModNamespace = block.getRegistryName().getNamespace();

                final IDecorativeBlock decorativeBlock = (IDecorativeBlock) block;

                pattern = decorativeBlock.getPattern();
                colour = decorativeBlock.getColour();
                suffix = decorativeBlock.getSuffix();
                postfix = decorativeBlock.getPostfix();

                break;

            }

        }

        for ( int i = 0; i < inv.getContainerSize(); i++ ) {

            final ItemStack stack = inv.getItem( i );

            if ( !stack.isEmpty() && stack.getItem() instanceof Press ) {

                final Press press = (Press) stack.getItem();

                if ( press instanceof PressPattern ) {

                    pattern = press.getVariant();
                    hasChanged = true;

                } else if ( press instanceof PressColour ) {

                    colour = press.getVariant();
                    hasChanged = true;

                } else if ( press instanceof PressVariant ) {

                    suffix = press.getVariant();
                    hasChanged = true;

                }

            }

        }

        if ( !hasChanged )
            return ItemStack.EMPTY;

        final Item item = ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( sourceModNamespace, pattern + colour + suffix + postfix ) );

        if ( item == null )
            return ItemStack.EMPTY;

        return new ItemStack( item, 1 );

    }

    @Override
    public boolean canCraftInDimensions( final int width, final int height ) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Nonnull
    @Override
    public NonNullList<ItemStack> getRemainingItems( final CraftingContainer inv ) {

        final NonNullList<ItemStack> list = NonNullList.withSize( inv.getContainerSize(), ItemStack.EMPTY );

        for ( int i = 0; i < inv.getContainerSize(); i++ ) {

            final ItemStack stack = inv.getItem( i );

            if ( stack.getItem() instanceof Press ) {

                final ItemStack stack1 = stack.copy();
                stack1.setCount( 1 );
                list.set( i, stack1 );

            }

        }

        return list;
    }

    @Override
    public boolean isSpecial() {
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
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }
//endregion Overrides

    public static final class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<PressCraftingRecipe> {

        private Serializer() {
            setRegistryName( Wallpapercraft.getId( "presscrafting" ) );
        }

//region Overrides
        @Nonnull
        @Override
        public PressCraftingRecipe fromJson( @Nonnull final ResourceLocation recipeId, @Nonnull final JsonObject json ) {

            return new PressCraftingRecipe( recipeId );

        }

        @Override
        public PressCraftingRecipe fromNetwork( final ResourceLocation recipeId, final FriendlyByteBuf buffer ) {
            return new PressCraftingRecipe( recipeId );
        }

        @Override
        public void toNetwork( FriendlyByteBuf buffer, PressCraftingRecipe recipe ) {
        }
//endregion Overrides

    }

}
