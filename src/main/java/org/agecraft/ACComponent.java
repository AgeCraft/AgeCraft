package org.agecraft;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.agecraft.core.AgeCraftCore;
import org.agecraft.metals.Metals;

public abstract class ACComponent {

    public static ArrayList<ACComponent> components = new ArrayList<ACComponent>();

    public static AgeCraftCore core = new AgeCraftCore();
    public static Metals metals = new Metals();

    public String name;

    public ACComponent(String name) {
        this.name = name;

        components.add(this);
    }

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();

    public abstract Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z);

    @SideOnly(Side.CLIENT)
    public abstract ACComponentClient getComponentClient();
}
