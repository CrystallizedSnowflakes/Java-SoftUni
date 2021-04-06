import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

// Test Interface

public class ProductStockTest {
    private ProductStock instock;
    private Product product;

    @Before
    public void setUp(){
        instock = new Instock();
        product = new Product("default_test_label", 100, 1);
    }

    // has same amount of products as added or 0 if empty
    @Test
    public void testGetCountShouldReturnTen_WhenTenProductAreAdded(){
        addProducts();
        // Act & Assert
        int expectedCount = 10;
        Integer actualCount = instock.getCount();
        assertEquals(Integer.valueOf(expectedCount), actualCount);
    }

    @Test
    public void testGetCountShouldReturnZero_WhenEmpty(){
        // Act & Assert
        int expectedCount = 0;
        Integer actualCount = instock.getCount();
        assertEquals(Integer.valueOf(expectedCount), actualCount);
    }

    @Test
    public void testAddProductShouldStoreTheProductByValidatingWithContains(){
        instock.add(product);
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(product)); // Supplier -> no input () -> has only the result
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAllowAdditionOfTheSameProductTwice(){
        instock.add(product);
        instock.add(product);
        int expectedCount = 1;
        Integer actualCount = assertNotNullReturnedObject(() -> instock.getCount()); // Supplier -> no input () -> has only the result
        assertEquals(Integer.valueOf(expectedCount), actualCount);
    }

    @Test
    public void testContainsShouldReturnFalse_WhenProductIsNotPresent(){
        instock.add(product);
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(new Product("test_label", 100, 1))); // Supplier -> no input () -> has only the result
        assertFalse(contains);
    }

    @Test
    public void testContainsShouldReturnFalse_WhenEmpty(){
        Boolean contains = assertNotNullReturnedObject(() -> instock.contains(product)); // Supplier -> no input () -> has only the result
        assertFalse(contains);
    }

    @Test
    public void testFindShouldReturnTheCorrect1stProductAdded(){
        assertFindReturnsCorrectProduct(0);
    }

    @Test
    public void testFindShouldReturnTheCorrect6thProductAdded(){
        assertFindReturnsCorrectProduct(6);
    }

    @Test
    public void testFindShouldReturnTheCorrect10thProductAdded(){
        assertFindReturnsCorrectProduct(9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFail_WhenIndexOutOfBoundsWhenNegativeIndex(){
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFail_WhenIndexOutOfBoundsWhenIndexIsEqualsToCount(){
        addProducts();
        instock.find(instock.getCount());
    }

    @Test
    public void testChangeQuantityShouldUpdateTheProductQuantityValue(){
        instock.add(product);
        int quantityBeforeUpdate = product.getQuantity();
        instock.changeQuantity(product.getLabel(), 10);
        Integer expectedUpdatedQuantity = quantityBeforeUpdate + 10;
        Integer actualUpdatedQuantity = product.getQuantity();
        assertEquals(expectedUpdatedQuantity, actualUpdatedQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailForMissingProduct(){
        addProducts();
        instock.changeQuantity(product.getLabel(), 10);
    }

    @Test
    public void testFindByLabelShouldReturnCorrectProduct(){
        addProducts();
        instock.add(product);
        /*Product foundByLabel = instock.findByLabel(product.label);
        assertNotNull(foundByLabel);*/
        Product foundByLabel = assertNotNullReturnedObject(() -> instock.findByLabel(product.label)); // Supplier -> no input () -> has only the result
        String expectedLabel = product.getLabel();
        String actualLabel = foundByLabel.getLabel();
        assertEquals(expectedLabel, actualLabel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowIfProductIsMissing(){
        addProducts();
        instock.findByLabel(product.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfCountIsOutOfRange(){
        addProducts();
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(instock.getCount() + 1);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProductsThatAreOrderedAlphabetically(){
        int expectedCount = 5;
        List<String> expectedLabels = addProducts().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(expectedCount)
                .map(Product::getLabel)
                .collect(Collectors.toList());

        List<Product> actualProducts = getListFromIterable(instock.findFirstByAlphabeticalOrder(expectedCount));
        assertEquals(expectedCount, actualProducts.size());

        for (int i = 0; i < actualProducts.size(); i++) {
            assertEquals(expectedLabels.get(i), actualProducts.get(i).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionIfNullProductsInThatRangeArePresent(){
        addProducts();
        Iterable<Product> iterable = instock.findAllInRange(10000, 11000);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindAllInRangeShouldReturnCorrectRangeWithOrderedPricesDescending(){
        double lowRange = 0.10;
        double upperRange = 100.50;
        List<Product> expectedProducts = addProducts().stream()
                .filter(p -> p.getPrice() > lowRange && p.getPrice() <= upperRange) // predicate - Boolean
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        List<Product> actualProducts = getListFromIterable(instock.findAllInRange(lowRange, upperRange));

        assertEquals(expectedProducts.size(), actualProducts.size());

        for (int i = 0; i < actualProducts.size(); i++) {
            assertEquals(expectedProducts.get(i).getPrice(), actualProducts.get(i).getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnOnlyProductsWithEqualPrice(){
        instock.add(product);
        instock.add(new Product("test_Label", product.getPrice(), 1));
        List<Product> actualProducts = getListFromIterable(instock.findAllByPrice(product.getPrice()));
        assertEquals(2, actualProducts.size());
        assertTrue(actualProducts.stream().allMatch(p -> p.getPrice() == product.getPrice())); // Predicate Boolean
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfNoSuchPricedProductPresent(){
        addProducts();
        List<Product> actualProducts = getListFromIterable(instock.findAllByPrice(100));
        assertTrue(actualProducts.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectNumberOfProductsThatAreOrderedByPriceDescending(){
        int expectedCount = 3;
        List<Double> expectedLabels = addProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(expectedCount)
                .map(Product::getPrice)
                .collect(Collectors.toList());

        List<Product> actualProducts = getListFromIterable(instock.findFirstMostExpensiveProducts(expectedCount));

        assertEquals(expectedCount, actualProducts.size());

        for (int i = 0; i < actualProducts.size(); i++) {
            assertEquals(expectedLabels.get(i), actualProducts.get(i).getPrice(), 0);
        }
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnEmptyCollectionIfCountIsOutOfRange(){
        addProducts();
        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(instock.getCount() + 1);
        assertEmptySequence(iterable);
    }

    @Test
    public void testFindAllByQuantityShouldReturnOnlyProductsWithEqualQuantity(){
        addProducts();
        instock.add(product);
        instock.add(new Product("test_Label", product.getPrice(), product.getQuantity()));
        List<Product> actualProducts = getListFromIterable(instock.findAllByQuantity(product.getQuantity()));
        assertEquals(3, actualProducts.size());
        assertTrue(actualProducts.stream().allMatch(p -> p.getQuantity() == product.getQuantity()));
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionIfNoSuchQuantityProductPresent(){
        addProducts();
        List<Product> actualProducts = getListFromIterable(instock.findAllByQuantity(1000)); // there is no such quantity 1000
        assertTrue(actualProducts.isEmpty());
    }

    @Test
    public void testGetIteratorShouldReturnAllProductsInTheOrderOfAddition(){
        List<Product> expectedProducts = addProducts();
        Iterator<Product> iterator = instock.iterator();
        List<Product> actualProducts = new ArrayList<>();
        while (iterator.hasNext()){
            actualProducts.add(iterator.next());
        }

        assertEquals(expectedProducts.size(), actualProducts.size());

        for (int i = 0; i < expectedProducts.size(); i++) {
            assertEquals(expectedProducts.get(i).getLabel(), actualProducts.get(i).getLabel());
        }
     }

    private <T> List<T> getListFromIterable(Iterable<T> iterable){
        assertNotNull(iterable);
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }


    private void assertFindReturnsCorrectProduct(int index){
        addProducts();
        assertEquals(Integer.valueOf(10), instock.getCount());
        /*Product product = instock.find(index);
        assertNotNull(product);*/
        Product product = assertNotNullReturnedObject(() -> instock.find(index));
        assertEquals("test_label_" + index, product.getLabel());
    }

    private List<Product> addProducts(){
        List<Product> products = Arrays.asList(new Product("test_label_0", 13, 1),
        new Product("test_label_1", 95.8, 10),
        new Product("test_label_2", 1000, 13),
        new Product("test_label_3", 100.50, 42),
        new Product("test_label_4", 42.69, 69),
        new Product("test_label_5", 10000, 32),
        new Product("test_label_6", 0.90, 2),
        new Product("test_label_7", 0.10, 7),
        new Product("test_label_8", 1, 99),
        new Product("test_label_9", 0.94, 73));

        for (Product p : products) {
            instock.add(p);
        }
        return products;
    }

    private void assertEmptySequence(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        assertTrue(products.isEmpty());
    }

    private <T> T assertNotNullReturnedObject(Supplier<T> supplier){ // no input, only result
        T result = supplier.get();
        assertNotNull(result);
        return result;
    }
}