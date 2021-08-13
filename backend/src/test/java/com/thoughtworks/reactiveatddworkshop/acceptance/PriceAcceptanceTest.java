import com.thoughtworks.reactiveatddworkshop.ReactiveAtddWorkshopApplication;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

@ContextConfiguration(classes = ReactiveAtddWorkshopApplication.class)
public class PriceAcceptanceTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private WebClient webClient;
    private Double calculatedAssetsValueInUsd;

    @Before
    @Given("that public crypto currencies prices are available through APIs")
    public void givenThatPublicCryptoApisAreAvailable() {
        log.info("Given that  public crypto currencies prices are available through APIs");
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @When("I request the value of my assets in USD")
    public void whenIRequestValueOfMyAssetsInUsd() {
        log.info("When I request the value of my assets in USD");
        this.calculatedAssetsValueInUsd = webClient.get()
                .uri("/assets/value/")
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }

    @Then("I get the calculated the value of my assets specified in USD")
    public void thenIRetrieveTheAmountsOfMyAssetsFromDb() {
        log.info("I get the calculated the value of my assets specified in USD.");
        Assertions.assertNotNull(this.calculatedAssetsValueInUsd);
        Assertions.assertTrue(this.calculatedAssetsValueInUsd > 0);
    }

}
