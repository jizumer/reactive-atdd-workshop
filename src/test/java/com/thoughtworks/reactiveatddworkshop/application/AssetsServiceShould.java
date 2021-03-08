package com.thoughtworks.reactiveatddworkshop.application;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import com.thoughtworks.reactiveatddworkshop.infrastructure.AssetsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetsServiceShould {


    String id;
    Asset mock;

    @Mock
    private AssetsRepository assetsRepository;

    @InjectMocks
    private AssetsService sut;

    @BeforeEach
    void setUp() {
        id = "whateverId";
        mock = new Asset(id, "name", 1.0);
    }

    @Test
    void should_save_entities() {
        when(assetsRepository.save(any())).thenReturn(Mono.just(mock));
        assertEquals(mock, sut.createAsset(mock).block());
        verify(assetsRepository, times(1)).save(eq(mock));
    }

    @Test
    void return_all_entities_stored_in_assets() {
        when(assetsRepository.findAll()).thenReturn(Flux.just(mock));
        assertEquals(1, sut.getAllAssets().count().block());
        verify(assetsRepository, times(1)).findAll();
    }

    @Test
    void return_the_entity_with_the_id_requested() {
        when(assetsRepository.findById(eq(id))).thenReturn(Mono.just(mock));
        assertEquals(id, sut.findById(id).block().getId());
        verify(assetsRepository, atLeastOnce()).findById(eq(id));
    }

    @Test
    void update_asset() {
        String modifiedAssetName = "modifiedAssetName";
        Double modifiedAssetAmount = 3.0;
        Asset assetMock = mock(Asset.class);

        when(assetMock.getAmount()).thenReturn(modifiedAssetAmount);
        when(assetMock.getName()).thenReturn(modifiedAssetName);

        when(assetsRepository.findById(eq(id))).thenReturn(Mono.just(assetMock));
        when(assetsRepository.save(eq(assetMock))).thenReturn(Mono.just(assetMock));

        assertEquals(assetMock, sut.updateAsset(id, assetMock).block());

        verify(assetsRepository, times(1)).findById(eq(id));
        verify(assetsRepository, times(1)).save(eq(assetMock));

        verify(assetMock, times(1)).setName(modifiedAssetName);
        verify(assetMock, times(1)).getName();
        verify(assetMock, times(1)).setAmount(modifiedAssetAmount);
        verify(assetMock, times(1)).getAmount();

    }

    @Test
    void delete_assets() {
        when(assetsRepository.findById(eq(id))).thenReturn(Mono.just(mock));
        when(assetsRepository.delete(mock)).thenReturn(Mono.empty());
        assertEquals(mock, sut.deleteAsset(id).block());
        verify(assetsRepository, times(1)).delete(eq(mock));
        verify(assetsRepository, times(1)).findById(eq(id));
    }

    @Test
    void find_asset_by_name() {
        when(assetsRepository.findByName(anyString())).thenReturn(Flux.just(mock));
        String anyName = "anyName";
        assertEquals(1, sut.findByAssetName(anyName).count().block());

        verify(assetsRepository, times(1)).findByName(anyName);
    }
}