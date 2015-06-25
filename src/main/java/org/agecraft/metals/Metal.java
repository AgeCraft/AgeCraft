package org.agecraft.metals;

import net.minecraft.item.ItemStack;

import org.agecraft.core.registry.RegistryObject;

public class Metal extends RegistryObject {

    public OreType type;

    public float hardness;
    public float resistance;
    public int harvestLevel;
    public float blockHardness;
    public float blockResistance;

    public ItemStack drop;
    public int dropMin;
    public int dropMax;
    public boolean fortune;

    public boolean hasOre;
    public boolean hasIngot;
    public boolean hasBlock;
    public boolean hasDoor;
    public boolean hasDust;

    public int redstonePower;
    public int fireSpreadSpeed;
    public int flammability;

    public int metalColor;

    // TODO: add ore generation settings to custom world type

    public int oreGenSize;
    public int oreGenPerChunk;
    public int oreGenMinY;
    public int oreGenMaxY;

    public Metal(int id, String name, OreType type, float hardness, float resistane, int harvestLevel, float blockHardness, float blockResistane, ItemStack drop, int dropMin, int dropMax, boolean fortune, boolean hasOre, boolean hasIngot, boolean hasBlock, boolean hasDoor, boolean hasDust, int redstonePower, int fireSpreadSpeed, int flammability, int metalColor, int oreGenSize, int oreGenPerChunk, int oreGenMinY, int oreGenMaxY) {
        super(id, name);
        this.type = type;

        this.hardness = hardness;
        this.resistance = resistane;
        this.harvestLevel = harvestLevel;
        this.blockHardness = blockHardness;
        this.blockResistance = blockResistane * 3.0F;

        drop.stackSize = 1;
        this.drop = drop;
        this.dropMin = dropMin;
        this.dropMax = dropMax;
        this.fortune = fortune;

        this.hasOre = hasOre;
        this.hasIngot = hasIngot;
        this.hasBlock = hasBlock;
        this.hasDoor = hasDoor;
        this.hasDust = hasDust;

        this.redstonePower = redstonePower;
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;

        this.metalColor = metalColor;

        this.oreGenSize = oreGenSize;
        this.oreGenPerChunk = oreGenPerChunk;
        this.oreGenMinY = oreGenMinY;
        this.oreGenMaxY = oreGenMaxY;
    }
}
