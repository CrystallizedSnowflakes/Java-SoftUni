package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StoreTests {
    //TODO: Test Store class
    private Store store;
    private Product product;

    @Before
    public void testUp(){
        this.store = new Store();
        this.product = new Product("Apple", 10, 2.5);
    }

    //getProducts
    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsByModifyingTheCollection(){
        this.store.getProducts().add(null);
    }

    //getCount
    @Test
    public void testGetCountWorkProperly(){
        this.store.addProduct(product);
        int count = this.store.getCount();
        assertEquals(1, count);
    }

    //addProduct
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullProductShouldThrowEx(){
        this.store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithZeroQuantityShouldThrowEx(){
        product = new Product("Tomato", 0, 5.00);
        this.store.addProduct(product);
    }

    @Test
    public void testAddProductWorkProperly(){
        this.store.addProduct(product);
        Product product = this.store.getProducts().get(0);
        assertEquals(1, this.store.getProducts().size());
        assertEquals("Apple", product.getName());
        assertEquals(2.5, product.getPrice(), 0.00);
    }

    //buyProduct
    @Test(expected = IllegalArgumentException.class)
    public void testBuyNullProductShouldThrowEx(){
        this.store.buyProduct("Banana", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductByNotEnoughQuantityPresentShouldThrowEx(){
        this.store.addProduct(product);
        assertNotNull(this.store);
        this.store.buyProduct("Apple", 20);
    }

    @Test
    public void testBuyProductWorkProperly(){
        this.store.addProduct(product);
        double appleCosts = this.store.buyProduct("Apple", 1);
        assertEquals(2.50, appleCosts, 0.00);
    }

    //getTheMostExpensiveProduct
    @Test
    public void testGetTheMostExpensiveProductWorkProperly(){
        this.store.addProduct(product);
        Product product2 = new Product("Orange", 12, 9.99);
        this.store.addProduct(product2);
        Product theMostExpensiveProduct = this.store.getTheMostExpensiveProduct();
        assertEquals(product2, theMostExpensiveProduct);
    }
}