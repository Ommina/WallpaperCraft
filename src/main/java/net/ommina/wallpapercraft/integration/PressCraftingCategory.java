package net.ommina.wallpapercraft.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.gui.ingredient.ITooltipCallback;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;
import net.ommina.wallpapercraft.tags.Tags;
import net.ommina.wallpapercraft.util.Translator;

import java.util.ArrayList;
import java.util.List;

public class PressCraftingCategory implements IRecipeCategory<PressCraftingRecipe> {

    private static final ItemStack BASE_ITEM = new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "solidgray-0" ) ) );
    private static final ResourceLocation GUI = new ResourceLocation( Wallpapercraft.MODID, "textures/gui/gui_vanilla.png" );

    public static final int width = 116;
    public static final int height = 54;

    private final IDrawable background;
    private final IDrawable icon;
    private final String localizedName;

    public PressCraftingCategory( IGuiHelper guiHelper ) {

        //this.modIdHelper = modIdHelper;
        ResourceLocation location = GUI;
        this.background = guiHelper.createDrawable( location, 0, 60, width, height );
        this.icon = guiHelper.createDrawableIngredient( new ItemStack( Blocks.CRAFTING_TABLE ) );
        this.localizedName = Translator.translateToLocal( "gui.wallpapercraft.category.craftingtable" );

    }

    @Override
    public ResourceLocation getUid() {
        return JustEnoughItems.PRESS_CRAFTING;
    }

    @Override
    public Class getRecipeClass() {
        return ICraftingRecipe.class;
    }

    @Override
    public String getTitle() {
        return this.localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients( PressCraftingRecipe recipe, IIngredients ingredients ) {

        final List<ItemStack> baseItem = new ArrayList<>();

        final List<ItemStack> pressPattern = new ArrayList<>();
        final List<ItemStack> pressColour = new ArrayList<>();
        final List<ItemStack> pressVariant = new ArrayList<>();

        final List<ItemStack> output = new ArrayList<>();

        ModBlocks.BLOCKS.values().forEach( b -> output.add( new ItemStack( ForgeRegistries.ITEMS.getValue( b.getRegistryName() ) ) ) );

        baseItem.add( BASE_ITEM );

        //Tags.TAG_DECORATIVE_ITEM.getAllElements().forEach( s -> baseItem.add( new ItemStack( s ) ) );

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

    @Override
    public void setRecipe( IRecipeLayout recipeLayout, PressCraftingRecipe recipe, IIngredients ingredients ) {

        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();

        itemStacks.addTooltipCallback( new ToolTip() );

        itemStacks.init( 0, true, 0, 0 );
        itemStacks.init( 1, true, 18 * 1, 0 );
        itemStacks.init( 2, true, 18 * 2, 0 );
        itemStacks.init( 3, true, 0, 18 * 1 );

        itemStacks.init( 4, false, 94, 18 );

        for ( int i = 0; i <= 3; i++ ) {
            itemStacks.set( i, ingredients.getInputs( VanillaTypes.ITEM ).get( i ) );
        }

        itemStacks.set( 4, ingredients.getOutputs( VanillaTypes.ITEM ).get( 0 ) );

        recipeLayout.setShapeless();

    }

    class ToolTip implements ITooltipCallback<ItemStack> {

        @Override
        public void onTooltip( int slotIndex, boolean input, ItemStack ingredient, List<String> tooltip ) {

            if ( slotIndex == 0 )
                tooltip.add( Translator.translateToLocal( "text.wallpapercraft.tooltip.crafting" ) );


        }

    }

}
