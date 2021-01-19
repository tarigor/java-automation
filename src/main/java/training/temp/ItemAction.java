package training.temp;

import java.util.concurrent.Exchanger;

public class ItemAction {
    private static Exchanger<Item> exchanger = new Exchanger<>();

    public void doActionPrice(Item item, float discount) {
        try {
            item.setPrice(item.getPrice() * discount);
            item = exchanger.exchange(item);
            item.setPrice(item.getPrice() * discount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doActionDescription(Item item, String addDescription) {
        try {
            item.setDescription(item.getDescription() + addDescription);
            item = exchanger.exchange(item);
            item.setDescription((item.getDescription() + addDescription));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
