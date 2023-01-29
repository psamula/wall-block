package wallblock;

import lombok.Setter;

@Setter
public class ConcreteBlock implements Block {
    private String color;
    private String material;
    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public String getMaterial() {
        return this.material;
    }
    @Override
    public int getCount() {
        return 1;
    }
}
