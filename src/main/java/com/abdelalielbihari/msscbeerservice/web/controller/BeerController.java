package com.abdelalielbihari.msscbeerservice.web.controller;

import com.abdelalielbihari.msscbeerservice.web.model.BeerDto;
import com.abdelalielbihari.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

    // todo impl
    return new ResponseEntity<>(BeerDto.builder().beerStyle(BeerStyleEnum.ALE).upc(145453L).price(BigDecimal.ONE).build(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpStatus> updateBeerById(@RequestBody BeerDto beer) {

    // todo impl
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<HttpStatus> saveNewBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beer) {

    // todo impl
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
