package com.thoughtworks.reactiveatddworkshop.application;

import com.thoughtworks.reactiveatddworkshop.domain.Price;
import com.thoughtworks.reactiveatddworkshop.infrastructure.CoinBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BitcoinSpotPriceService {

    private final CoinBaseRepository coinBaseRepository;

    @Autowired
    public BitcoinSpotPriceService(CoinBaseRepository coinBaseRepository) {
        this.coinBaseRepository = coinBaseRepository;
    }

    public Mono<Price> getBitcoinSpotPrice() {
        return coinBaseRepository.getBitcoinSpotPrice();
    }
}
