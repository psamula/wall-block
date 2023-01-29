package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import wallblock.Block;
import wallblock.ConcreteBlock;
import wallblock.ConcreteCompositeBlock;
import wallblock.Wall;

import java.util.ArrayList;
import java.util.List;

public class WallBlockTest {
    @Test
    public void shouldCalculateComponentsOfCompositeBlocks() {
        //given
        List<Block> blocks = blocksLevel1Factory(10);
        Wall wall = new Wall();
        List<Block> blocksLevel2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blocksLevel2.addAll(blocksLevel1Factory(10));
        }

        blocks.addAll(blocksLevel2);
        blocks.addAll(blockLevel0Factory(10));

        //when
        wall.setBlocks(blocks);
        int actual = wall.count();


        //then
        int expected = 1110;
        Assertions.assertEquals(expected, actual);

    }
    private List<Block> blockLevel0Factory(int amount) {
        List<Block> blocksLevel0 = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            blocksLevel0.add(new ConcreteBlock());
        }
        return blocksLevel0;
    }
    private List<Block> blocksLevel1Factory(int amount) {
        List<Block> blocksLevel1 = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            blocksLevel1.add(new ConcreteCompositeBlock(blockLevel0Factory(amount)));
        }
        return blocksLevel1;
    }
}