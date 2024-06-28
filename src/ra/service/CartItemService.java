package ra.service;

import ra.model.CartItem;
import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

import static ra.service.CatalogService.categories;

public class CartItemService implements ICartItemFuture {
    public static List<CartItem> cartItems = new ArrayList<>();


    @Override
    public List<CartItem> getAll() {
        return cartItems;
    }

    @Override
    public void save(CartItem cartItem) {
        CartItem checkIndex = findById(cartItem.getCartItemId());
        if (checkIndex == null) {
            cartItems.add(cartItem);
        }else {
            cartItems.set(checkIndex.getCartItemId(), cartItem);
        }
    }

    @Override
    public CartItem findById(Integer id) {
        for (CartItem cartItem: cartItems) {
            if (cartItem.getCartItemId() == id){
                return cartItem;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        CartItem indexDelete = findById(id);
        if (indexDelete == null) {
            cartItems.remove(indexDelete);
        }else {
            System.err.println("product such not,cannot delete");
        }
    }
}
