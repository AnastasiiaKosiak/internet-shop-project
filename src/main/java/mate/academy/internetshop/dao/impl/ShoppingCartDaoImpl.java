package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.db.Storage;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addShoppingCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        int index = Storage.carts.indexOf(Storage.carts.stream()
                .filter(cart -> cart.getId().equals(shoppingCart.getId())));
        Storage.carts.set(index, shoppingCart);
        return shoppingCart;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.carts.removeIf(cart -> cart.getId().equals(id));
    }

    @Override
    public Optional<ShoppingCart> get(Long userId) {
        return Storage.carts
                .stream()
                .filter(cart -> cart.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<ShoppingCart> getAll() {
        return Storage.carts;
    }

    @Override
    public List<Product> getAllProducts(Long cartId) {
        return Storage.carts.stream()
                .filter(shoppingCart -> shoppingCart.getId().equals(cartId))
                .findFirst()
                .get()
                .getProducts();
    }

    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        return Storage.carts.stream()
                .filter(cart -> cart.getUserId().equals(shoppingCart.getUserId()))
                .findFirst()
                .get()
                .getProducts()
                .remove(product);
    }
}
