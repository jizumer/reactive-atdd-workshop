package com.thoughtworks.reactiveatddworkshop.acceptance;

import com.thoughtworks.reactiveatddworkshop.domain.Asset;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetAssetsTest extends AssetsIntegrationTest {

    private List<Asset> assets;
    private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

    @When("I request the amount of my assets")
    public void whenIRequestTheAmountOfMyAssets() {
        log.info("Running: I request the amount of my assets at " + new Date());
        assets = getAssets().collectList().block();
    }

    @Then("I get the list of the increments of amount of my assets")
    public void thenIGetTheListOfTheIncrementsOfAmountOfMyAssets() {
        log.info("Running: I get the list of the increments of amount of my assets at " + new Date());

        assertEquals(3, assets.size());
        assertAll("asset",
                () -> assertTrue(assets.contains(new Asset("1", "BTC", 0.1))),
                () -> assertTrue(assets.contains(new Asset("2", "BTC", 0.2))),
                () -> assertTrue(assets.contains(new Asset("3", "BTC", 0.05)))
        );
    }

    @After
    public void tearDown() {
        log.info("After all test execution");
    }

}
