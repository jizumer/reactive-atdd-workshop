package com.thoughtworks.reactiveatddworkshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class Price {
    @Getter
    @Setter
    private String base;
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private Double amount;

    @JsonCreator
    public Price(@JsonProperty("base") String base,
                 @JsonProperty("currency") String currency,
                 @JsonProperty("amount") Double amount) {
        this.base = base;
        this.currency = currency;
        this.amount = amount;
    }
}
