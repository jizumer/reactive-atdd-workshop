package com.thoughtworks.reactiveatddworkshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class CoinBaseData {
    @Getter
    @Setter
    private Price data;

    @JsonCreator
    public CoinBaseData(@JsonProperty("data") Price data) {
        this.data = data;
    }
}
