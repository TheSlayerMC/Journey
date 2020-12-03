package net.jitl.init.internal;

import net.jitl.JITL;
import net.jitl.common.helper.JArmorMaterial;
import net.jitl.common.helper.JToolTiers;
import net.jitl.common.item.*;
import net.jitl.init.JTabs;
import net.jitl.util.JItemProperties;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import ru.timeconqueror.timecore.api.client.resource.StandardItemModelParents;
import ru.timeconqueror.timecore.registry.AutoRegistrable;
import ru.timeconqueror.timecore.registry.newreg.ItemRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistrator {
    @AutoRegistrable
    private static final ItemRegister REGISTER = new ItemRegister(JITL.MODID);

    @AutoRegistrable.InitMethod
    private static void register() {

        //OVERWORLD ITEMS
        registerItem("sapphire", "Sapphire");
        registerItem("iridium_nugget", "Iridium Nugget");
        registerItem("lunium_ingot", "Lunium Ingot");
        registerItem("shadium_ingot", "Shadium Ingot");
        registerItem("obsidian_rod", "Obsidian Rod");

        //NETHER ITEMS
        registerItem("bloodcrust_ingot", "Bloodcrust Ingot");
        registerItem("firestone_shard", "Firestone Shard", () -> new JFuelItem(new Item.Properties().fireResistant().tab(JTabs.ITEMS), 200));
        registerItem("firestone_clump", "Firestone Clump", () -> new JFuelItem(new Item.Properties().fireResistant().tab(JTabs.ITEMS), 2000));

        //END ITEMS
        registerItem("enderillium_shard", "Enderillium Shard");

        //BOILING POINT ITEMS
        registerItem("ash", "Ash");

        //EUCA ITEMS
        registerItem("celestium_ingot", "Celestium Ingot");
        registerItem("korite_ingot", "Korite Ingot");
        registerItem("mekyum_ingot", "Mekyum Ingot");
        registerItem("storon_ingot", "Storon Ingot");

        //DEVELOPER ITEMS
        registerItem("test_bug", "Test Bug", TestBugItem::new);

        //OVERWORLD TOOLSETS
        registerArmorAndToolSet("sapphire", "Sapphire", JToolTiers.SAPPHIRE, JArmorMaterial.SAPPHIRE);
        registerArmorAndToolSet("lunium", "Lunium", JToolTiers.LUNIUM, JArmorMaterial.LUNIUM);
        registerArmorAndToolSet("shadium", "Shadium", JToolTiers.SHADIUM, JArmorMaterial.SHADIUM);

        //NETHER TOOLSETS
        registerArmorAndToolSet("bloodcrust", "Bloodcrust", JToolTiers.BLOODCRUST, JArmorMaterial.BLOODCRUST);

        //EUCA TOOLSETS
        registerArmorAndToolSet("celestium", "Celestium", JToolTiers.CELESTIUM, JArmorMaterial.CELESTIUM);
        registerToolSet("korite", "Korite", JToolTiers.KORITE);
        registerToolSet("mekyum", "Mekyum", JToolTiers.MEKYUM);
        registerToolSet("storon", "Storon", JToolTiers.STORON);
    }

    /**
     * Registers an armor set and a tool set.
     *
     * @param name          Registry name
     * @param engName       English name
     * @param toolTiers     Stats for the tool set
     * @param armorMaterial Stats for the armor set
     */
    public static void registerArmorAndToolSet(String name, String engName, JToolTiers toolTiers, JArmorMaterial armorMaterial) {
        registerToolSet(name, engName, toolTiers);
        registerArmorSet(name, engName, armorMaterial);
    }

    /**
     * Registers a full armor set.
     *
     * @param name          Registry name
     * @param engName       English name
     * @param armorMaterial Stats for the armor set
     */
    public static void registerArmorSet(String name, String engName, JArmorMaterial armorMaterial) {
        registerArmorItem(name + "_helmet", engName + " Helmet", () -> new JItemArmor(armorMaterial, EquipmentSlotType.HEAD));
        registerArmorItem(name + "_chestplate", engName + " Chestplate", () -> new JItemArmor(armorMaterial, EquipmentSlotType.CHEST));
        registerArmorItem(name + "_leggings", engName + " Leggings", () -> new JItemArmor(armorMaterial, EquipmentSlotType.LEGS));
        registerArmorItem(name + "_boots", engName + " Boots", () -> new JItemArmor(armorMaterial, EquipmentSlotType.FEET));
    }

    /**
     * Registers an armor set and a tool set.
     *
     * @param name      Registry name
     * @param engName   English name
     * @param toolTiers Stats for the tool set
     */
    public static void registerToolSet(String name, String engName, JToolTiers toolTiers) {
        registerSwordItem(name + "_sword", engName + " Sword", toolTiers);

        registerToolItem(name + "_multitool", engName + " Multitool", () -> new ItemMultitool(toolTiers));
        registerToolItem(name + "_pickaxe", engName + " Pickaxe", () -> new JItemPickaxe(toolTiers));
        registerToolItem(name + "_axe", engName + " Axe", () -> new JItemAxe(toolTiers));
        registerToolItem(name + "_shovel", engName + " Shovel", () -> new JItemShovel(toolTiers));
        registerToolItem(name + "_hoe", engName + " Hoe", () -> new JItemHoe(toolTiers));
    }

    /**
     * Registers an armor piece. The stats of which vary on the supplier's class and the args within its constructor.
     *
     * @param name          Registry name
     * @param enName        English name
     * @param armorSupplier Supplier for the JArmorItem class
     */
    private static void registerArmorItem(String name, String enName, Supplier<JItemArmor> armorSupplier) {
        REGISTER.register(name, armorSupplier)
                .genModel(StandardItemModelParents.DEFAULT)
                .genLangEntry(enName);
    }

    /**
     * Registers a sword item. The stats of which vary on the tool material given.
     *
     * @param name     Registry name
     * @param enName   English name
     * @param material Stats for the sword item
     */
    private static void registerSwordItem(String name, String enName, JToolTiers material) {
        REGISTER.register(name, () -> new JItemSword(material))
                .genModel(StandardItemModelParents.HANDHELD)
                .genLangEntry(enName);
    }

    /**
     * Registers a tool. The stats of which vary on the supplier's class and the args within its constructor.
     *
     * @param name             Registry name
     * @param enName           English name
     * @param toolItemSupplier Supplier for the ToolItem class
     */
    private static void registerToolItem(String name, String enName, Supplier<ToolItem> toolItemSupplier) {
        REGISTER.register(name, toolItemSupplier)
                .genModel(StandardItemModelParents.HANDHELD)
                .genLangEntry(enName);
    }

    private static void registerItem(String name, String enName, Supplier<Item> itemSupplier) {
        REGISTER.register(name, itemSupplier)
                .genModel(StandardItemModelParents.DEFAULT)
                .genLangEntry(enName);
    }

    private static void registerItem(String name, String enName) {
        Function<Item.Properties, ? extends Item> itemFactory = Item::new;

        REGISTER.register(name, () -> itemFactory.apply(JItemProperties.DEFAULT.create()))
                .genModel(StandardItemModelParents.DEFAULT)
                .genLangEntry(enName);
    }

    private static void registerItem(String name, String enName, Function<Item.Properties, ? extends Item> itemFactory) {
        REGISTER.register(name, () -> itemFactory.apply(JItemProperties.DEFAULT.create()))
                .genModel(StandardItemModelParents.DEFAULT)
                .genLangEntry(enName);
    }

    private static void registerItem(String name, String enName, Function<Item.Properties, ? extends Item> itemFactory, StandardItemModelParents modelType) {
        REGISTER.register(name, () -> itemFactory.apply(JItemProperties.DEFAULT.create()))
                .genModel(modelType)
                .genLangEntry(enName);
    }
}