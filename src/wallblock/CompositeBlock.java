package wallblock;
import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();

    @Override
    String getColor();

    @Override
    String getMaterial();

    @Override
    int getCount();
}