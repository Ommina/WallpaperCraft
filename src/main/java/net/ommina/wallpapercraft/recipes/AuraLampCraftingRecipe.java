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
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.DecorativeBlock;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressAuraLamp;
import net.ommina.wallpapercraft.tags.Tags;

import javax.annotation.Nonnull;

public class AuraLampCraftingRecipe implements ICraftingRecipe {

    public static final String VARIANT = "auralamp";
    public static final ResourceLocation NAME = Wallpapercraft.getId( VARIANT + "crafting" );
    public static final Serializer SERIALIZER = new Serializer();

    @Override
    public boolean matches( @Nonnull final CraftingInventory inv, @Nonnull final World world ) {

        int i = 0;
        int j = 0;

        for( int k = 0; k < inv.getSizeInventory(); k++ ) {

            final ItemStack stack = inv.getStackInSlot( k );

            if( !stack.isEmpty() ) {

                if( stack.getItem() instanceof PressAuraLamp ) {
                    i++;
                } else {

                    if( !Tags.TAG_SOLID.contains( stack.getItem() ) ) {
                        return false;
                    }

                    j++;

                }

                if( j > 1 || i > 1 ) {
                    return false;
                }

            }
        }

        return i == 1 && j == 1;
    }

    @Override
    @Nonnull
    public ItemStack getCraftingResult( @Nonnull final CraftingInventory inv ) {

        for( int i = 0; i < inv.getSizeInventory(); i++ ) {

            final ItemStack stack = inv.getStackInSlot( i );

            if( !stack.isEmpty() && Tags.TAG_SOLID.contains( stack.getItem() ) ) {

                final DecorativeBlock block = ModBlocks.BLOCKS.get( stack.getItem().getRegistryName().getPath() );

                if( block == null )
                    return ItemStack.EMPTY;

                final Item item = ModItems.ITEMS.get( VARIANT + block.getColour() + block.getSuffix() );

                if( item == null )
                    return ItemStack.EMPTY;

                return new ItemStack( item );

            }

        }

        return ItemStack.EMPTY;

    }

    @Nonnull
    @Override
    public NonNullList<ItemStack> getRemainingItems( final CraftingInventory inv ) {

        final NonNullList<ItemStack> list = NonNullList.withSize( inv.getSizeInventory(), ItemStack.EMPTY );

        for( int i = 0; i < inv.getSizeInventory(); i++ ) {

            final ItemStack stack = inv.getStackInSlot( i );

            if( stack.getItem() instanceof PressAuraLamp ) {

                final ItemStack stack1 = stack.copy();
                stack1.setCount( 1 );
                list.set( i, stack1 );
                break;

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

    @Override
    public ResourceLocation getId() {
        return NAME;
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<AuraLampCraftingRecipe> {

        private Serializer() {

        }

        @Override
        public AuraLampCraftingRecipe read( ResourceLocation recipeId, JsonObject json ) {
            return new AuraLampCraftingRecipe();
        }

        @Override
        public AuraLampCraftingRecipe read( ResourceLocation recipeId, PacketBuffer buffer ) {
            return new AuraLampCraftingRecipe();
        }

        @Override
        public void write( PacketBuffer buffer, AuraLampCraftingRecipe recipe ) {
        }

    }

}
