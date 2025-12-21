package Iterator;

public class MaterialIterator implements IIterator<String> {
    private String[] materials;
    private int position = 0;

    public MaterialIterator(String[] materials) {
        this.materials = materials;
    }

    @Override
    public boolean hasNext() {
        return position < materials.length && materials[position] != null;
    }

    @Override
    public String next() {
        return materials[position++];
    }
}