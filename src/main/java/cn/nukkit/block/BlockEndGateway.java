package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.utils.BlockColor;

/**
 * @author PikyCZ
 */
public class BlockEndGateway extends BlockSolid {

    public BlockEndGateway(int id, int meta) {
        super(id, meta);
    }

    @Override
    public String getName() {
        return "End Gateway";
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public boolean isBreakable(Item item) {
        return false;
    }

    @Override
    public double getHardness() {
        return -1;
    }

    @Override
    public double getResistance() {
        return 18000000;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public boolean hasEntityCollision() {
        return true;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.AIR_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(BlockID.AIR, 0, 0);
    }

}
