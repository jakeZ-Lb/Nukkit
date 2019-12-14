package cn.nukkit.level.generator.populator.impl;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.chunk.Chunk;
import cn.nukkit.level.generator.populator.helper.EnsureCover;
import cn.nukkit.level.generator.populator.helper.EnsureGrassBelow;
import cn.nukkit.level.generator.populator.type.PopulatorSurfaceBlock;
import cn.nukkit.math.NukkitRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Angelic47, Niall Lindsay (Niall7459)
 * <p>
 * Nukkit Project
 * </p>
 */
public class PopulatorFlower extends PopulatorSurfaceBlock {
    private static final Block AIR = Block.get(BlockID.AIR);

    private final List<Block> flowerTypes = new ArrayList<>();

    public void addType(Block block) {
        this.flowerTypes.add(block);
    }

    public List<Block> getTypes() {
        return this.flowerTypes;
    }

    @Override
    protected void placeBlock(int x, int y, int z, Block block, Chunk chunk, NukkitRandom random) {
        if (flowerTypes.size() != 0) {
            Block type = flowerTypes.get(ThreadLocalRandom.current().nextInt(flowerTypes.size()));
            chunk.setBlock(x, y, z, type);
            if (type.getId() == DOUBLE_PLANT) {
                chunk.setBlock(x, y + 1, z, type);
            }
        }
    }

    @Override
    protected boolean canStay(int x, int y, int z, Chunk chunk, ChunkManager level) {
        return EnsureCover.ensureCover(x, y, z, chunk) && EnsureGrassBelow.ensureGrassBelow(x, y, z, chunk);
    }

    @Override
    protected Block getBlock(int x, int z, NukkitRandom random, Chunk chunk) {
        return AIR;
    }
}
