package com.abdelalielbihari.msscbeerservice.web.controller;

import com.abdelalielbihari.msscbeerservice.repositories.BeerRepository;
import com.abdelalielbihari.msscbeerservice.web.mappers.BeerMapper;
import com.abdelalielbihari.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  private final BeerRepository beerRepository;
  private final BeerMapper mapper;

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(mapper.beerToBeerDto(beerRepository.findById(beerId).get()), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpStatus> saveNewBeer(@RequestBody BeerDto beerDto) {
    beerRepository.save(mapper.beerDtoToBeer(beerDto));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<HttpStatus> updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
    beerRepository.findById(beerId).ifPresent(beer -> {
      beer.setBeerName(beerDto.getBeerName());
      beer.setBeerStyle(beer.getBeerStyle());
      beer.setPrice(beerDto.getPrice());
      beer.setUpc(beerDto.getUpc());
    });
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
