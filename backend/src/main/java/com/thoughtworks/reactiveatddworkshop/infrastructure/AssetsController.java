package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.application.AssetsService;
import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    private final AssetsService assetsService;

    @Autowired
    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Asset> create(@RequestBody Asset asset) {
        return assetsService.createAsset(asset);
    }

    @GetMapping
    public Flux<Asset> getAllAssets() {
        return assetsService.getAllAssets();
    }

    @GetMapping("/value")
    public Mono<Double> getMyAssetsValue() {
        return assetsService.getAssetsValue();
    }


    @GetMapping("/{assetId}")
    public Mono<ResponseEntity<Asset>> getAssetById(@PathVariable String assetId) {
        Mono<Asset> user = assetsService.findById(assetId);
        return user.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Asset> getAssetsByName(@PathVariable String name) {
        return assetsService.findByAssetName(name);
    }

    @DeleteMapping("/{assetId}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String assetId) {
        return assetsService.deleteAsset(assetId)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
