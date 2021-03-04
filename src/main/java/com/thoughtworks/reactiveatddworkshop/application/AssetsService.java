package com.thoughtworks.reactiveatddworkshop.application;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import com.thoughtworks.reactiveatddworkshop.infrastructure.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;

    @Autowired
    public AssetsService(AssetsRepository assetsRepository) {
        this.assetsRepository = assetsRepository;
    }

    public Flux<Asset> findByAssetName(String assetName) {
        return assetsRepository.findByName(assetName);
    }
}
