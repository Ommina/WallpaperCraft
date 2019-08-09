package net.ommina.wallpapercraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JustEnoughItems implements IModPlugin {

    private static final ResourceLocation PLUGIN_UID = Wallpapercraft.getId( "plugin/main" );

    public static final ResourceLocation PRESS_CRAFTING = Wallpapercraft.getId( "category/presscrafting" );

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerCategories( final IRecipeCategoryRegistration registration ) {

        registration.addRecipeCategories( new PressCraftingCategory( registration.getJeiHelpers().getGuiHelper() ) );

    }

    @Override
    public void registerRecipes( IRecipeRegistration registration ) {

        registration.addRecipes( getRecipesOfType( PressCraftingRecipe.RECIPE_TYPE ), PRESS_CRAFTING );


    }

    @Override
    public void onRuntimeAvailable( IJeiRuntime jeiRuntime ) {

        List<ItemStack> removals = new ArrayList<>();

        removals.add( new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressstamp" ) ) ) );
        removals.add( new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressjewel" ) ) ) );

        jeiRuntime.getIngredientManager().removeIngredientsAtRuntime( VanillaTypes.ITEM, removals );

    }

    private static List<IRecipe> getRecipesOfType( IRecipeType<?> recipeType ) {

        return Minecraft.getInstance().world.getRecipeManager().getRecipes().stream().filter( r -> r.getType() == recipeType ).collect( Collectors.toList() );

    }

}
