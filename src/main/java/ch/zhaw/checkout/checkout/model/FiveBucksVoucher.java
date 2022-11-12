package ch.zhaw.checkout.checkout.model;

import java.util.List;

import ch.zhaw.checkout.checkout.interfaces.Voucher;

public class FiveBucksVoucher implements Voucher {

    public FiveBucksVoucher() {
    }

    @Override
    public double getDiscount(List<Product> products) {
        double sum = 0;
        for(int i = 0; i < products.size(); i++)
            sum += products.get(i).getPrice();
        
        if (sum >= 10.0) {

            return 5.0;
        }
        return 0.0;
    }

}
