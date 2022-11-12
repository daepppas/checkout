package ch.zhaw.checkout.checkout.model;

import java.util.List;

import ch.zhaw.checkout.checkout.interfaces.Voucher;

public class PercentageVoucher implements Voucher {

    private int discount;

    public PercentageVoucher(int discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount(List<Product> products) {
        double sum = 0;
        for(int i = 0; i < products.size(); i++)
            sum += products.get(i).getPrice();
        
        return (sum/100)*discount;

}
}
