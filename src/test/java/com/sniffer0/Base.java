package com.sniffer0;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

abstract class Base {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.moex.com/";
    }
}