package com.thoughtworks.reactiveatddworkshop.config;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import com.thoughtworks.reactiveatddworkshop.infrastructure.AssetsRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.util.stream.DoubleStream;

@Configuration
public class CustomConnectionFactoryInitializer {
    @Bean
    public ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("ddl.sql")));
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

    @Bean
    public CommandLineRunner init(AssetsRepository assetsRepository) {
        return args ->
                DoubleStream.of(0.1, 0.2, 0.05).
                        forEach(amount ->
                                assetsRepository
                                        .save(new Asset(null, "BTC", amount)).subscribe());
    }

}