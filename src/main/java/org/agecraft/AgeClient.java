package org.agecraft;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.agecraft.prehistory.PrehistoryAgeClient;

@SideOnly(Side.CLIENT)
public abstract class AgeClient extends ACComponentClient {

    public static PrehistoryAgeClient prehistory = new PrehistoryAgeClient(Age.prehistory);
    public static AgeClient agriculture;
    public static AgeClient ancientEgypt;
    public static AgeClient ancientChina;
    public static AgeClient romanGreek;
    public static AgeClient medieval;
    public static AgeClient earlyModern;
    public static AgeClient industrial;
    public static AgeClient modern;
    public static AgeClient future;

    public AgeClient(Age age) {
        super(age);
    }
}
