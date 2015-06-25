package org.agecraft.age.prehistory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.agecraft.ACComponentClient;
import org.agecraft.Age;
import org.agecraft.AgeClient;

public class AgePrehistory extends Age {

    public AgePrehistory(int id) {
        super(id, "prehistory");
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    @Override
    public ACComponentClient getComponentClient() {
        return AgeClient.prehistory;
    }

    @Override
    public Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
