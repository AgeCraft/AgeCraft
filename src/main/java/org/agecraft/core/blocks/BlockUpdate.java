package org.agecraft.core.blocks;

public class BlockUpdate {

    /**
     * Notify all neighbor blocks of a tile entity update (only in the horizontal plane).
     */
    public static final int TILE_ENTITIES = 1;

    /**
     * Mark the block for update on both the client and server side.
     */
    public static final int DEFAULT = 2;
    
    /**
     * Mark the block for update only on the server side.
     * Used by command blocks and dispensers for example.
     */
    public static final int SERVER_SIDE = 4;
}
