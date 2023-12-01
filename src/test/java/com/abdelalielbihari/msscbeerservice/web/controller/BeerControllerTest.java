package com.abdelalielbihari.msscbeerservice.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.abdelalielbihari.msscbeerservice.domain.Beer;
import com.abdelalielbihari.msscbeerservice.repositories.BeerRepository;
import com.abdelalielbihari.msscbeerservice.web.model.BeerDto;
import com.abdelalielbihari.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class})
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.abdelalielbihari.msscbeerservice.web.mappers")
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  BeerRepository beerRepository;

  @Test
  void getBeerById() throws Exception {
    given(beerRepository.findById(any())).willReturn(Optional.of(Beer.builder().build()));

    mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID())
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(document("v1/beer", pathParameters(
            parameterWithName("beerId").description("UUID of desired beer to get")
        )));
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = BeerDto.builder().beerName("Updated Beer").beerStyle(BeerStyleEnum.ALE).upc(45645L).price(BigDecimal.valueOf(4.5)).build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID())
            .content(beerDtoJson)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = BeerDto.builder().beerStyle(BeerStyleEnum.ALE).upc(1455255L).price(BigDecimal.valueOf(4.5)).build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(post("/api/v1/beer")
            .content(beerDtoJson)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }
}