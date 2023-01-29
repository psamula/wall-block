package wallblock;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Setter
@Getter
public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }
    @Override
    public int count() {
        return blocks.stream()
                .map(Block::getCount)
                .reduce(0, Integer::sum);
    }
}
