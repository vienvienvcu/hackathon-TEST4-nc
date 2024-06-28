package run;

import ra.model.Product;

import java.util.Comparator;

public class SortProductByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o2.getProductPrice(), o1.getProductPrice());
    }
}
