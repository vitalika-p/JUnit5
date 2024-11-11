package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchInput;


public class YaMarketFindItemTests extends TestBase {

        @ValueSource(strings = {
                "ноутбук", "смартфон андроид", "gsktcjc бош"
        })
        @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список")
        @Tag("BLOCKER")
        void searchResultTest(String searchQuery) {
                SearchInput
                        .openMainPage()
                        .searchSomething(searchQuery);
        }

        @CsvSource(value = {
                "шампунь, мужской",
                "шампунь, женский",
        })
        @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать результат в зависимости от заданного")
        @Tag("BLOCKER")
        void searchResultGenderTest(String searchQuery, String expectedGender) {
                SearchInput
                        .openMainPage()
                        .searchSomething(searchQuery)
                        .checkProductByGender(expectedGender);
        }

        @CsvFileSource(resources = "/test_data/searchResult.csv", numLinesToSkip = 1)
        @ParameterizedTest(name = "Для поискового запроса {0} в результате поиска должен быть бренд {1}")
        void searchResultBrandFromCsvTest(String searchQuery, String expectedBrand) {
                SearchInput
                        .openMainPage()
                        .searchSomething(searchQuery)
                        .checkProductByBrand(expectedBrand);
        }
}