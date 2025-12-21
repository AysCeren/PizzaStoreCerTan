package Iterator;

public class MaterialCollection implements ICollection {
    private String[] materials;
    private int index = 0;

    public MaterialCollection(int capacity) {
        materials = new String[capacity];
    }

    public void addMaterial(String material) {
        if (index < materials.length) {
            materials[index++] = material;
        }
    }

    @Override
    public IIterator<String> createIterator() {
        return new MaterialIterator(materials);
    }
}