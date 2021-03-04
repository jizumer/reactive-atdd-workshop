package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AssetsRepository extends ReactiveCrudRepository<Asset, String> {
    @Query("select * from assets where name = $1")
    Flux<Asset> findByName(String assetName);
}
