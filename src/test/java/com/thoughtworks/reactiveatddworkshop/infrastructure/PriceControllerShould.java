package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerShould {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Return the current spot price for Bitcoin.")
    void returnAllAssets() {
        Price retrievedPrice = webTestClient.get()
                .uri("/price/btc")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Price.class)
                .returnResult()
                .getResponseBody();

        assertEquals("USD", retrievedPrice.getCurrency());
        assertEquals("BTC", retrievedPrice.getBase());
    }
}