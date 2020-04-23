package mate.academy.internetshop.model;

import java.util.List;

public class Order {
    private Long id;
    private List<Product> products;
    private User user;

    public Order(Long id, List<Product> products, User user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getItems() {
        return products;
    }

    public void setItems(List<Product> items) {
        this.products = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}