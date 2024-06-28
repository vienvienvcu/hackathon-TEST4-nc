package ra.model;

import ra.service.CatalogService;
import ra.service.ProductService;

import java.util.Scanner;

public class CartItem {
    private int cartItemId;
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemId, Product product, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputItemCart(Scanner scanner) {
        System.out.print("Enter cart id: ");
        this.cartItemId = Integer.parseInt(scanner.nextLine());
        this.product = inputProduct(scanner);
        System.out.print("Enter quantity: ");
        this.quantity = Integer.parseInt(scanner.nextLine());
    }

    public Product inputProduct(Scanner scanner) {
        System.out.println("Enter product Name : ");
        do {
            for (int i = 0; i < ProductService.products.size(); i++){
                System.out.println((i+1)+ ". " + ProductService.products.get(i).getProductName());
            }
            System.out.println("enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >0 && choice <= ProductService.products.size()){
                return this.product =  ProductService.products.get(choice-1);
            }else {
                System.err.println("Product Name is not exist,please try again");
            }
        }while (true);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", product=" + this.product.getProductName() +
                ", quantity=" + quantity +
                '}';
    }
}
