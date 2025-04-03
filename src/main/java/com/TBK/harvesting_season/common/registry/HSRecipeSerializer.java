package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.server.data.recipe.CookingpotRecipe;
import com.TBK.harvesting_season.server.data.recipe.KettleRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HarvestingSeason.MODID);

    public static final RegistryObject<RecipeSerializer<CookingpotRecipe>> NEW_FURNACE_RECIPE = RECIPE_SERIALIZERS.register("jap_furnace_recipe", CookingpotRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<KettleRecipe>> KETTLE_RECIPE = RECIPE_SERIALIZERS.register("kettle_recipe", KettleRecipe.Serializer::new);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, HarvestingSeason.MODID);

    public static final RegistryObject<RecipeType<CookingpotRecipe>> FURNACE_RECIPE_TYPE = RECIPE_TYPES.register("furnace_recipe_type",()->new RecipeType<CookingpotRecipe>() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    });

    public static final RegistryObject<RecipeType<KettleRecipe>> KETTLE_RECIPE_TYPE = RECIPE_TYPES.register("kettle_recipe_type",()->new RecipeType<KettleRecipe>() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    });
}
