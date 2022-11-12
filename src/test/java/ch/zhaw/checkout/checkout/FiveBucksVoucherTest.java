package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ch.zhaw.checkout.checkout.model.FiveBucksVoucher;
import ch.zhaw.checkout.checkout.model.Product;

public class FiveBucksVoucherTest {

    @Test
    public void testEmpty() {

        ArrayList<Product> emptyList = new ArrayList<>();
        FiveBucksVoucher fbv = new FiveBucksVoucher();
        double dicount = fbv.getDiscount(emptyList);
        assertEquals(0.0, dicount);

    }

    @Test
    public void testTen(){
        ArrayList<Product> productList = new ArrayList<>();
        FiveBucksVoucher fbv = new FiveBucksVoucher();
        Product priceTestTen = new Product("1", "Soap", "toiletries", 10.0);
        productList.add(priceTestTen);
        double dicount = fbv.getDiscount(productList);
        assertEquals(5.0, dicount);

    }

}
