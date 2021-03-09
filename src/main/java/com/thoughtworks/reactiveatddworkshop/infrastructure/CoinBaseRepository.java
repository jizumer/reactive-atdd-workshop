package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.domain.CoinBaseData;
import com.thoughtworks.reactiveatddworkshop.domain.Price;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class CoinBaseRepository {

    private static final String COINBASE_BASE_URL = "https://api.coinbase.com/v2";
    private final WebClient webClient;

    public CoinBaseRepository() {
        this.webClient = WebClient.builder()
                .baseUrl(COINBASE_BASE_URL)
                .build();
    }

    public Mono<Price> getBitcoinSpotPrice() {
        return webClient
                .get()
                .uri("/prices/spot")
                .retrieve()
                .bodyToMono(CoinBaseData.class)
                .flatMap(coinBaseData -> Mono.just(coinBaseData.getData()));
    }


}
