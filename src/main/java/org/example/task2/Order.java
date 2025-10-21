package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String formOrderBill(Cart cart) {

        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id);
        builder.append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;

        Item[] items = cart.getContents();

        for (Item item : items) {

            sum += item.getPrice();

            builder.append("Item id: ");
            builder.append(item.getId());
            builder.append(" name: ");
            builder.append(item.getName());
            builder.append(" price: ");
            builder.append(item.getPrice());
            builder.append("\n");
        }

        builder.append("------------------\n");
        builder.append("РАХУНОК: ");
        builder.append(sum);

        return builder.toString();
    }
}