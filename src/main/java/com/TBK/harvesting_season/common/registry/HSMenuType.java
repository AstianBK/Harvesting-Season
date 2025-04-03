package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.client.gui.CookingpotContainerMenu;
import com.TBK.harvesting_season.client.gui.KettleContainerMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSMenuType {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HarvestingSeason.MODID);

    public static final RegistryObject<MenuType<CookingpotContainerMenu>> FURNACE_MENU = registerMenuType(CookingpotContainerMenu::new,"furnace_menu");
    public static final RegistryObject<MenuType<KettleContainerMenu>> KETTLE_MENU = registerMenuType(KettleContainerMenu::new,"kettle_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENU_TYPE.register(name, () -> IForgeMenuType.create(factory));
    }
}
