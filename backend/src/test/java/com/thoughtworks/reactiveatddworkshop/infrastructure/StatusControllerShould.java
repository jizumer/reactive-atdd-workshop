package com.thoughtworks.reactiveatddworkshop.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatusControllerShould {

    @Autowired
    private WebTestClient webClient;

    @Test
    @DisplayName("Result status should be 200 (OK)")
    void returnStatusOk() {
        webClient.get()
                .uri("/status")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectBody()
                .jsonPath("$.numberOfStatusRequests").isNotEmpty()
                .jsonPath("$.startTimestamp").isNotEmpty();
    }

}