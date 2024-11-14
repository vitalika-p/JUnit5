package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchInput {
    private final SelenideElement searchField = $("#header-search");
    private final SelenideElement searchButton =$("button[data-auto='search-button']");
    private final SelenideElement resultList =$(".page");

    public static SearchInput openMainPage() {
        open("");
        return new SearchInput();  // Возвращаем новый экземпляр
    }

    public SearchInput searchSomething(String searchQuery) {
        searchField.setValue(searchQuery);
        searchButton.click();
        return this;
    }

    public SearchInput checkProductByGender(String gender) {
        resultList.shouldHave(text(gender));

        return this;
    }

    public SearchInput checkProductByBrand(String brandName) {
        resultList.shouldHave(text(brandName));

        return this;
    }

}


