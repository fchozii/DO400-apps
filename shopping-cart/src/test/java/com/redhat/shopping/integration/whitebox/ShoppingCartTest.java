package com.redhat.shopping.integration.whitebox;

import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class ShoppingCartTest {

    @Inject
    CartService cartService;

    @BeforeEach
    void clearCart() {
        this.cartService.clear();
    }

    @Test
    void addingNonExistingProductInCatalogRaisesAnException() {
    assertThrows(
        ProductNotFoundInCatalogException.class,
        () -> this.cartService.addProduct(9999, 10));
    }

    @Test
    void addingNonExistingProductInCartTheTotalItemsMatchTheInitialQuantity()
        throws ProductNotFoundInCatalogException {

    //Given
    //an empty shopping cart done by ClearCart method before each test

    //When
    this.cartService.addProduct(1, 10);

    //Then
    assertEquals(10, this.cartService.totalItems());
    }

    @Test
    void addingProductThatIsInTheCartTheTotalItemsMatchTheSumOfQuantities()
        throws ProductNotFoundInCatalogException {

    //Given
    //an empty shopping cart done by ClearCart method before each test
    this.cartService.addProduct(2, 10);

    //When
    this.cartService.addProduct(2, 100);

    //Then
    assertEquals(110, this.cartService.totalItems());
}
}