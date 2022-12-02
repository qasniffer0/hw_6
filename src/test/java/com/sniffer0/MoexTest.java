package com.sniffer0;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MoexTest extends Base {

    @BeforeEach
    void openGeneralPage() {
        open("https://www.moex.com/");

    }

    @DisplayName("Checking the provision of a user agreement when accessing a currency")
    @Tag("BLOCKER")
    @Test
    void checkCurrency() {
        $("a[href='/s11']").click();
        $("[class='btn2 btn2-primary']").click();
        $("h1").shouldHave(text("Валютный рынок"));
    }

    @CsvSource(value = {
            "Selenide| Ничего не найдено",
            "JUnit| Ничего не найдено"

    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Проверка по запросу {0}" + " ответ {1}")
    @Tag("CRITICAL")
    void searchTest(String searchQuery, String expectedResult) {
        $("[name=searchString]").setValue(searchQuery);
        $("#search-results__message").shouldHave(text(expectedResult));
    }

    static Stream<Arguments> moexMenuTestRu() {
        return Stream.of(
                Arguments.of("Ru", List.of(
                        "Продукты и услуги",
                        "Биржевая информация",
                        "Документы",
                        "Обучение",
                        "Медиа",
                        "О компании"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка меню из списка {1} на сайте MOEX в локали {0}")
    @Tag("CRITICAL")
    void moexMenuTestRu(String locale, List<String> menu) {
        $x("//a[@href=\"/\"]").click();
        $$(".header__menu-wrapper li").filter(visible)
                .shouldHave(CollectionCondition.texts(menu));
    }

    static Stream<Arguments> moexMenuTestEn() {
        return Stream.of(
                Arguments.of("En", List.of(
                        "Markets",
                        "Indices",
                        "Market data",
                        "Listing",
                        "Connectivity",
                        "News and events",
                        "About MOEX",
                        "Investor Relations"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка меню из списка {1} на сайте MOEX в локали {0}")
    @Tag("CRITICAL")
    void moexMenuTestEn(String locale, List<String> menu) {
        $x("//a[@href=\"/en\"]").click();
        $$(".header__menu-wrapper li").filter(visible)
                .shouldHave(CollectionCondition.texts(menu));
    }
}
