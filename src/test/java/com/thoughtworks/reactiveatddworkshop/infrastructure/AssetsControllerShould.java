package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.thoughtworks.reactiveatddworkshop.config.CustomConnectionFactoryInitializer.BTC_ASSET_NAME;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AssetsControllerShould {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Return all the results.")
    void returnAllAssets() {
        Assertions.assertEquals(BTC_ASSET_NAME,
                webTestClient.get()
                        .uri("/assets")
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBodyList(Asset.class)
                        .hasSize(3)
                        .returnResult()
                        .getResponseBody()
                        .get(0)
                        .getName());
    }

}
