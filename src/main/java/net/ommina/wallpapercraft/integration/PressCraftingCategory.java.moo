package net.ommina.wallpapercraft.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;
import net.ommina.wallpapercraft.tags.Tags;

import java.util.ArrayList;
import java.util.List;

public class PressCraftingCategory implements ICraftingCategoryExtension {

    public static final ItemStack BASE_ITEM = new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "solidgray-0" ) ) );

    public PressCraftingCategory( PressCraftingRecipe recipe ) {
    }

//region Overrides
    @Override
    public void setIngredients( IIngredients ingredients ) {

        final List<ItemStack> baseItem = new ArrayList<>();

        final List<ItemStack> pressPattern = new ArrayList<>();
        final List<ItemStack> pressColour = new ArrayList<>();
        final List<ItemStack> pressVariant = new ArrayList<>();

        final List<ItemStack> output = new ArrayList<>();

        ModBlocks.BLOCKS.values().forEach( b -> output.add( new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( b.getName() ) ) ) ) );

        baseItem.add( BASE_ITEM );

        Tags.TAG_PRESS_PATTERN.getAllElements().forEach( s -> pressPattern.add( new ItemStack( s ) ) );
        Tags.TAG_PRESS_COLOUR.getAllElements().forEach( s -> pressColour.add( new ItemStack( s ) ) );
        Tags.TAG_PRESS_VARIANT.getAllElements().forEach( s -> pressVariant.add( new ItemStack( s ) ) );


        final List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
        final List<List<ItemStack>> outputs = new ArrayList<List<ItemStack>>();

        inputs.add( baseItem );

        inputs.add( pressPattern );
        inputs.add( pressColour );
        inputs.add( pressVariant );

        outputs.add( output );

        ingredients.setInputLists( VanillaTypes.ITEM, inputs );
        ingredients.setOutputLists( VanillaTypes.ITEM, outputs );

    }
//endregion Overrides

}
