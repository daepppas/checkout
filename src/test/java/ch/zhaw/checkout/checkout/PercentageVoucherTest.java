package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.zhaw.checkout.checkout.model.PercentageVoucher;
import ch.zhaw.checkout.checkout.model.Product;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 9, 17, 30, 60, Integer.MAX_VALUE})
    public void TestPercentageVoucher(int value){
        ArrayList<Product> shoppingCartList = new ArrayList<>();
        Product priceTestTen = new Product("1", "Soap", "toiletries", 10.0);
        shoppingCartList.add(priceTestTen);
        PercentageVoucher pv = new PercentageVoucher(value);
        double dicount = pv.getDiscount(shoppingCartList);
        double expected = (priceTestTen.getPrice()/100)*value;
        assertEquals(expected, dicount);


        
    }

    @Test
    public void testVoucherTwoProducts(){
        ArrayList<Product> shoppingCartList = new ArrayList<>();
        Product firstProduct = new Product("1", "Soap", "toiletries", 10.0);
        Product secondProduct = new Product("2", "Soap-Premium", "toiletries", 50.0);
        shoppingCartList.add(firstProduct);
        shoppingCartList.add(secondProduct);
        PercentageVoucher pv = new PercentageVoucher(42);
        double discount = pv.getDiscount(shoppingCartList);
        double expected = ((firstProduct.getPrice() + secondProduct.getPrice()) / 100) * 42;
        assertEquals(expected, discount);


    }
    
}
