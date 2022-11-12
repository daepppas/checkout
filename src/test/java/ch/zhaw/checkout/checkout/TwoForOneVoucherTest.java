package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import ch.zhaw.checkout.checkout.model.Product;
import ch.zhaw.checkout.checkout.model.TwoForOneVoucher;

class TwoForOneVoucherTest {

    @Test
    public void testVoucherTwoProducts() {
        ArrayList<Product> shoppingCartList = new ArrayList<>();
        Product firstProduct = new Product("1", "Soap", "Toiletries", 42.0);
        Product secondProduct = new Product("2", "Soap-Premium", "Toiletries", 77.0);
        shoppingCartList.add(firstProduct);
        shoppingCartList.add(secondProduct);
        TwoForOneVoucher tfov = new TwoForOneVoucher(firstProduct);
        double discount = tfov.getDiscount(shoppingCartList);
        assertEquals(0.0, discount);
    }

    @ParameterizedTest
    @CsvSource(value = { "0,0", "1,0", "2,1", "3,1", "4,2" })
    public void testVoucherWithDiscount(ArgumentsAccessor accessor) {
        ArrayList<Product> shoppingCartList = new ArrayList<>();
        int amountOfSameProducts = accessor.getInteger(0);
        int amountOfFreeProducts = accessor.getInteger(1);
        double price = 77.0;
        Product productToAdd = new Product("1", "Soap", "Toiletries", price);
        for (int i = 0; i < amountOfSameProducts; i++) {
            shoppingCartList.add(productToAdd);
        }
        TwoForOneVoucher tfov = new TwoForOneVoucher(productToAdd);
        double discount = tfov.getDiscount(shoppingCartList);
        assertEquals(amountOfFreeProducts * price, discount);
    }
}
