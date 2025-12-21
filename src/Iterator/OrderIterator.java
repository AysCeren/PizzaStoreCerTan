package Iterator;

import java.util.List;
import Builder.PizzaOrder;

public class OrderIterator implements IIterator<PizzaOrder> {
    private List<PizzaOrder> orders;
    private int position = 0;

    public OrderIterator(List<PizzaOrder> orders) {
        this.orders = orders;
    }

    @Override
    public boolean hasNext() {
        return position < orders.size();
    }

    @Override
    public PizzaOrder next() {
        if (hasNext()) {
            return orders.get(position++);
        }
        return null;
    }
}