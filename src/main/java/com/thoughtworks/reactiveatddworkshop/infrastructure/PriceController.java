package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.application.BitcoinSpotPriceService;
import com.thoughtworks.reactiveatddworkshop.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final BitcoinSpotPriceService bitcoinSpotPriceService;

    @Autowired
    public PriceController(BitcoinSpotPriceService bitcoinSpotPriceService) {
        this.bitcoinSpotPriceService = bitcoinSpotPriceService;
    }

    @GetMapping(value = "/btc", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Price> getBitcoinSpotPrice() {
        return bitcoinSpotPriceService.getBitcoinSpotPrice();
    }
}
