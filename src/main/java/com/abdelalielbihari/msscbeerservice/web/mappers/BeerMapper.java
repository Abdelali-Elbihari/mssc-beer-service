package com.abdelalielbihari.msscbeerservice.web.mappers;

import com.abdelalielbihari.msscbeerservice.domain.Beer;
import com.abdelalielbihari.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface BeerMapper {
  BeerDto beerToBeerDto(Beer beer);

  Beer beerDtoToBeer(BeerDto beerDto);
}
