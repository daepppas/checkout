package ch.zhaw.checkout.checkout.model;

import java.util.List;

import ch.zhaw.checkout.checkout.interfaces.Voucher;

public class TwoForOneVoucher implements Voucher {

    private Product product;

    public TwoForOneVoucher(Product product) {
        this.product = product;
    }

    @Override
    public double getDiscount(List<Product> products) {
        int occurences = 0;
        for (Product cartProduct : products) {
            if (cartProduct.equals(product)) {
                occurences++;
            }
        }
        return (occurences / 2) * product.getPrice();
    }

}
