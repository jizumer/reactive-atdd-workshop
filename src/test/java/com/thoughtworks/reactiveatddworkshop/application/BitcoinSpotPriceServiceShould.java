package com.thoughtworks.reactiveatddworkshop.application;

import com.thoughtworks.reactiveatddworkshop.domain.Price;
import com.thoughtworks.reactiveatddworkshop.infrastructure.CoinBaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BitcoinSpotPriceServiceShould {

    @InjectMocks
    private BitcoinSpotPriceService sud;

    @Mock
    private CoinBaseRepository coinBaseRepository;


    @Test
    void return_current_btc_spot_price_in_usd() {
        Price priceMock = Mockito.mock(Price.class);
        Mockito.when(coinBaseRepository.getBitcoinSpotPrice())
                .thenReturn(Mono.just(priceMock));
        assertEquals(priceMock, sud.getBitcoinSpotPrice().block());
        Mockito.verify(coinBaseRepository, Mockito.atLeastOnce()).getBitcoinSpotPrice();
    }
}