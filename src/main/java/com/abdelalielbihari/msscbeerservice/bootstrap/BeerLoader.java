package com.abdelalielbihari.msscbeerservice.bootstrap;

import com.abdelalielbihari.msscbeerservice.domain.Beer;
import com.abdelalielbihari.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

  private final BeerRepository beerRepository;

  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() == 0) {
      beerRepository.save(Beer.builder()
          .beerName("Mango Bobs")
          .beerStyle("IPA")
          .upc(337010000001L)
          .quantityToBrew(200)
          .minOnHand(12)
          .price(new BigDecimal("10"))
          .build());

      beerRepository.save(Beer.builder()
          .beerName("Galaxy Cat")
          .beerStyle("PALE_ALE")
          .upc(337010000002L)
          .quantityToBrew(200)
          .minOnHand(12)
          .price(new BigDecimal("12"))
          .build());
    }

    System.out.println("Loaded beers: " + beerRepository.count());
  }
}
