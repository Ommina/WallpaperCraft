package net.ommina.wallpapercraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.category.extensions.IExtendableRecipeCategory;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class JustEnoughItems implements IModPlugin {

    private static final ResourceLocation PLUGIN_UID = Wallpapercraft.getId( "plugin/main" );

    //region Overrides
    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerVanillaCategoryExtensions( IVanillaCategoryExtensionRegistration registration ) {

        IExtendableRecipeCategory<CraftingRecipe, ICraftingCategoryExtension> category = registration.getCraftingCategory();

        category.addCategoryExtension( PressCraftingRecipe.class, PressCraftingCategory::new );

    }

    @Override
    public void registerRecipes( IRecipeRegistration registration ) {

        registration.addRecipes( getRecipesOfType( RecipeType.CRAFTING ), VanillaRecipeCategoryUid.CRAFTING );

        addInfoPage( registration, PressCraftingCategory.BASE_ITEM.getItem() );
        addInfoPage( registration, ModItems.PAINTBRUSH );

    }

    @Override
    public void onRuntimeAvailable( IJeiRuntime jeiRuntime ) {

        List<ItemStack> removals = new ArrayList<>();

        removals.add( new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressstamp" ) ) ) );
        removals.add( new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressjewel" ) ) ) );

        jeiRuntime.getIngredientManager().removeIngredientsAtRuntime( VanillaTypes.ITEM, removals );

    }
//endregion Overrides

    private static List<Recipe> getRecipesOfType( RecipeType<?> recipeType ) {

        return Minecraft.getInstance().level.getRecipeManager().getRecipes().stream().filter( r -> r instanceof PressCraftingRecipe ).collect( Collectors.toList() );

    }

    private static void addInfoPage( IRecipeRegistration reg, ItemLike item ) {

        String key = getDescKey( Objects.requireNonNull( item.asItem().getRegistryName() ) );
        ItemStack stack = new ItemStack( item );

        reg.addIngredientInfo( stack, VanillaTypes.ITEM, new TextComponent( key ) );

    }

    private static String getDescKey( ResourceLocation name ) {
        return "jei." + name.getNamespace() + "." + name.getPath() + ".desc";
    }

}
