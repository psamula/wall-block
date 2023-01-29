package wallblock;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class ConcreteCompositeBlock implements CompositeBlock {
    List<Block> blocks;

    public ConcreteCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }
    public ConcreteCompositeBlock() {}

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor() {
        return getBlocks().get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return getBlocks().get(0).getMaterial();
    }

    @Override
    public int getCount() {
        return getBlocks().stream()
                .map(Block::getCount)
                .reduce(0, Integer::sum);
    }
}
