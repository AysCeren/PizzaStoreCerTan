package Iterator;

import java.util.ArrayList;
import java.util.List;
import Builder.PizzaOrder; // Importing from your existing Builder package

public class OrderCollection implements ICollection {
    private List<PizzaOrder> pendingOrders;

    public OrderCollection() {
        this.pendingOrders = new ArrayList<>();
    }

    public void addOrder(PizzaOrder order) {
        this.pendingOrders.add(order);
    }

    @Override
    public IIterator<PizzaOrder> createIterator() {
        return new OrderIterator(this.pendingOrders);
    }
}