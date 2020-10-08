package com.gsmserver;

import com.gsmserver.product.ProductDto;
import com.gsmserver.product.ProductComponentSteps;
import com.gsmserver.product.Products;
import com.gsmserver.utils.Calculator;
import com.gsmserver.utils.PriceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.gsmserver.product.Products.MedusaBox;

public class ProductPageTests extends BaseTest {


    @Test
//    @ParameterizedTest
//    @EnumSource()
    void increaseAndDecreaseProductCountTest(/*Products unit*/) {
        ProductDto productDto = MedusaBox.getDto();
//        ProductDto productDto = unit.getDto();

        open(productDto.getBasePath());

        ProductComponentSteps productSteps = ProductComponentSteps.targetProduct(productDto);

        Assertions.assertEquals(productSteps.getProductPageTitle(), productDto.getTitle());

        productSteps.addToCartProduct()
                .increaseProductCountTo(1)
                .decreaseProductCountTo(1);

        Calculator.multiply("126.99", 3);
        new PriceCalculator("126.99").multiply(3);

        PriceCalculator priceCalculator = new PriceCalculator("232");
        priceCalculator.multiply(3);

        Assertions.assertEquals(productSteps.getProductCount(), "1");
    }
//    @Test
//    void increaseAndDecreaseProductCountTest() {
//        String productDto = Products.MedusaBox.getDto();
//
//        openPage(productDto.getBasePath());
//
//        var productSteps = ProductComponentSteps.targetProduct(productDto);
//
//        Assertions.assertEquals(productSteps.getProductPageTitle(), productDto.getTitle());
//
//        productSteps
//                .addToCartProduct()
//                .increaseProductCountTo(2)
//                .decreaseProductCountTo(2);
//
//        Calculator.multiply("126.99", 4);
//        new PriceCalculator("126.99").multiply(4);
//
//        Assertions.assertEquals(productSteps.getProductCount(), "1");
//    }

}
