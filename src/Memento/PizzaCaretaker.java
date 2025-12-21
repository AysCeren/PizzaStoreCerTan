package Memento;

import Builder.PizzaOrder;

import java.util.Stack;

public class PizzaCaretaker {
    private Stack<Memento> history = new Stack<>();

    public void saveState(PizzaOrder pizza) throws InterruptedException {
        history.push(pizza.save());
    }

    public void undo(PizzaOrder pizza) throws InterruptedException {
        if (!history.isEmpty()) {
            // We pop the current state and restore the one before it
            history.pop();
            if (!history.isEmpty()) {
                pizza.undo(history.peek());
                Thread.sleep(1000);
            }
        }
    }
    public boolean isHistoryEmpty() {
        return history.isEmpty();
    }
}
