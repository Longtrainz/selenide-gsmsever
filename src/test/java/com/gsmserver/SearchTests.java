package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.SearchResultPage;
import com.gsmserver.product.ProductComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends BaseTest {

    private final String productName = "Z3X Easy-Jtag Plus Full Set";
    private final  String productId = "872994";

    @BeforeEach
    void openHomePage() {
        open("/");
    }


    @Test
    void searchProductByTitleAndAddToCartTest() {
        $("[name='searchword']").val(productName).pressEnter();
        $(".search-title-highlight").shouldHave(text(productName));

        SearchResultPage searchResultPage = new SearchResultPage();
        ProductComponent targetProduct = searchResultPage.targetProduct(productId);

        targetProduct.getProductTitle().shouldHave(text(productName));
        targetProduct.clickOnAddToCart();
        targetProduct.clickOnGoToCart();

        $("#cart h1").shouldHave(text("Cart"));
        $$("#cart tr[data-product-id]").shouldHaveSize(1);
        searchResultPage.targetProduct(productId).getProductTitle().shouldHave(text(productName));

    }

    @Test
    void searchProductByTitleTest() {
        new HomePage().searchComponent.searchFor(productName);

        SearchResultPage searchResultPage = new SearchResultPage();

        String actualSearchResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

        int actualSizeOfSearchResult = searchResultPage.getSearchResultListSize();
        Assertions.assertEquals(actualSizeOfSearchResult, 3);

        String actualFirstProductTitle = searchResultPage.getFirstProductInfoTitle();
        Assertions.assertEquals(productName, actualFirstProductTitle);
    }


    @Test
    void searchForProductViaClickOnSeeAllTest() {
        new HomePage().searchComponent.fillSearchQuery(productName).clickOnSeeAll();
        SearchResultPage searchResultPage = new SearchResultPage();

        String actualSearchResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);
    }




    }
