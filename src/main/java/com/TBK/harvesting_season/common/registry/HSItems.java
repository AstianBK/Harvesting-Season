package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.item.TinctureItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HarvestingSeason.MODID);
    public static final RegistryObject<Item> SAGE = ITEMS.register("sage",
            ()-> new ItemNameBlockItem(HSBlock.SAGE_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));

    public static final RegistryObject<Item> YARROW = ITEMS.register("yarrow",
            ()-> new ItemNameBlockItem(HSBlock.YARROW_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));
    public static final RegistryObject<Item> ARNICA = ITEMS.register("arnica",
            ()-> new ItemNameBlockItem(HSBlock.ARNICA_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));
    public static final RegistryObject<Item> LEMON_BALM = ITEMS.register("lemon_balm",
            ()-> new ItemNameBlockItem(HSBlock.LEMON_BALM_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));
    public static final RegistryObject<Item> COMFREY = ITEMS.register("comfrey",
            ()-> new ItemNameBlockItem(HSBlock.COMFREY_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));
    public static final RegistryObject<Item> YELLOW_WOOD_SORREL = ITEMS.register("yellow_wood_sorrel",
            ()-> new ItemNameBlockItem(HSBlock.YELLOW_WOOD_SORREL_CROP_BLOCK.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).alwaysEat().build())));
    public static final RegistryObject<Item> FLAX_FIBER = ITEMS.register("flax_fiber",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COTTON = ITEMS.register("cotton",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOLETE_MUSHROOM = ITEMS.register("bolete_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.BOLETE_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
            ()->new Item(new Item.Properties().stacksTo(1).durability(30)));
    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DIG_SPEED,2400,0),1.0f)
                    .alwaysEat().build()))));
    public static final RegistryObject<Item> BARLEY = ITEMS.register("barley",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> OAT = ITEMS.register("oat",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> RYE = ITEMS.register("rye",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> UPLAND_RICE = ITEMS.register("upland_rice",
            ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> WHITE_GRAPE = ITEMS.register("white_grape",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> HEMLOCK = ITEMS.register("hemlock",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> LOVAGE = ITEMS.register("lovage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> THYME = ITEMS.register("thyme",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> GINSENG = ITEMS.register("ginseng",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> WOAD_TINCTORIA = ITEMS.register("woad_tinctoria",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASIL = ITEMS.register("basil",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> MUGWORT = ITEMS.register("mugwort",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> CHIVES = ITEMS.register("chives",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> MARIGOLD = ITEMS.register("marigold",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> OREGANO = ITEMS.register("oregano",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> CHICKWEED = ITEMS.register("chickweed",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> EYEBRIGHT = ITEMS.register("eyebright",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> THISTLE = ITEMS.register("thistle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> DAISY = ITEMS.register("daisy",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> CHICORY = ITEMS.register("chicory",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> MUSTARD = ITEMS.register("mustard",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> GINGER = ITEMS.register("ginger",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> SAFFRON = ITEMS.register("saffron",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> ROSEMARY = ITEMS.register("rosemary",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> COMMON_VETCH = ITEMS.register("common_vetch",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> COMMON_CLOVE = ITEMS.register("common_clove",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> COMMON_MALLOW = ITEMS.register("common_mallow",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> COMMON_BROADLEAF = ITEMS.register("common_broadleaf",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> COMMON_EDIBLE_ROOT = ITEMS.register("common_edible_root",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> COMMON_MINT = ITEMS.register("common_mint",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> JUNIPER_BERRY = ITEMS.register("juniper_berry",
            () -> new ItemNameBlockItem( HSBlock.JUNIPER_HEAD.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(3.0F).nutrition(3).build())));
    public static final RegistryObject<Item> ROSESHIP = ITEMS.register("roseship",
            () -> new ItemNameBlockItem(HSBlock.ROSESHIP_HEAD.get() , new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry",
            () -> new ItemNameBlockItem(HSBlock.BLACKBERRY_HEAD.get() , new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> ELDERBERRY = ITEMS.register("elderberry",
            () -> new ItemNameBlockItem(HSBlock.ELDERBERRY_HEAD.get() , new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry",
            () -> new ItemNameBlockItem(HSBlock.RASPBERRY_HEAD.get() , new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> HAWTHORN = ITEMS.register("hawthorn",
            () -> new ItemNameBlockItem(HSBlock.HAWTHORN_HEAD.get() , new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            ()-> new ItemNameBlockItem(HSBlock.BLUEBERRY_BUSH.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> GOOSEBERRY = ITEMS.register("gooseberry",
            ()-> new ItemNameBlockItem(HSBlock.GOOSEBERRY_BUSH.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            ()-> new ItemNameBlockItem(HSBlock.STRAWBERRY_BUSH.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> CLOUDBERRY = ITEMS.register("cloudberry",
            ()-> new ItemNameBlockItem(HSBlock.CLOUDBERRY_BUSH.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> UVA_URSI = ITEMS.register("uva_ursi",
            ()-> new ItemNameBlockItem(HSBlock.UVA_URSI_BUSH.get() ,new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> MILLET = ITEMS.register("millet",
            ()-> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> PURPLE_GRAPES = ITEMS.register("purple_grapes",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> TARRAGON = ITEMS.register("tarragon",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> PARSLEY = ITEMS.register("parsley",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> EGGPLANT = ITEMS.register("eggplant",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> SWEET_PEA = ITEMS.register("sweet_pea",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> BROAD_BEAN = ITEMS.register("broad_bean",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> KALE = ITEMS.register("kale",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> HORSERADISH = ITEMS.register("horseradish",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CAULIFLOWER = ITEMS.register("cauliflower",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> BRUSSEL_SPROUT = ITEMS.register("brussel_sprout",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CHICKPEA = ITEMS.register("chickpea",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));
    public static final RegistryObject<Item> ARTICHOKE = ITEMS.register("artichoke",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> ASPARAGUS = ITEMS.register("asparagus",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> SCALLION = ITEMS.register("scallion",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CORIANDER = ITEMS.register("coriander",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> COLLARD = ITEMS.register("collard",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> NETTLE = ITEMS.register("nettle",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CHARD = ITEMS.register("chard",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> SPINACH = ITEMS.register("spinach",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CELERY = ITEMS.register("celery",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> RADISH = ITEMS.register("radish",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(3).build())));
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> LENTIL = ITEMS.register("lentil",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> PARSNIP = ITEMS.register("parsnip",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));




    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> LEEK = ITEMS.register("leek",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(2).build())));
    public static final RegistryObject<Item> CABBAGE = ITEMS.register("cabbage",
            () -> new Item( new Item.Properties().food(new FoodProperties.Builder().saturationMod(3.0F).nutrition(2).build())));

    public static final RegistryObject<Item> FLY_AGERIC_MUSHROOM = ITEMS.register("fly_ageric_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.FLY_AGERIC_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> MILKCAP_MUSHROOM = ITEMS.register("milkcap_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.MILKCAP_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).effect(new MobEffectInstance(MobEffects.POISON,200,0),1.0F).build())));

    public static final RegistryObject<Item> MOREL_MUSHROOM = ITEMS.register("morel_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.MOREL_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> PARASOL_MUSHROOM = ITEMS.register("parasol_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.PARASOL_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> PINE_MUSHROOM = ITEMS.register("pine_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.PINE_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).nutrition(1).build())));

    public static final RegistryObject<Item> WHITECAP_MUSHROOM = ITEMS.register("whitecap_mushroom",
            ()-> new ItemNameBlockItem(HSBlock.WHITECAP_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.0F).effect(new MobEffectInstance(MobEffects.POISON,200,0),1.0F).nutrition(1).build())));
    public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINE_BEER = ITEMS.register("fine_beer",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> KVASS= ITEMS.register("kvass",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ALE = ITEMS.register("ale",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> WINE = ITEMS.register("wine",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SPIRIT = ITEMS.register("spirit",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RESERVED_WINE = ITEMS.register("reserved_wine",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TINCTURE = ITEMS.register("tincture", () -> {
        return new TinctureItem((new Item.Properties()).stacksTo(3));
    });
}
