import com.thoughtworks.reactiveatddworkshop.ReactiveAtddWorkshopApplication;
import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@ContextConfiguration(classes = ReactiveAtddWorkshopApplication.class)
public class AssetsIntegrationTest {

    Flux<Asset> getAssets() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();

        return webClient.get()
                .uri("/assets/")
                .retrieve()
                .bodyToFlux(Asset.class);
    }

}
