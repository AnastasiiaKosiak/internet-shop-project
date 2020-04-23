package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.db.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product item) {
        Storage.addItem(item);
        return item;
    }

    @Override
    public Optional<Product> get(Long id) {
        return Storage.products
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }

    @Override
    public Product update(Product item) {
        IntStream.range(0, Storage.products.size())
                .filter(indx -> item.getId().equals(Storage.products.get(indx).getId()))
                .forEach(i -> Storage.products.set(i, item));
        return item;
    }

    @Override
    public boolean deleteById(Long id) {
        return Storage.products.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public boolean delete(Product item) {
        return Storage.products.remove(item);
    }

}