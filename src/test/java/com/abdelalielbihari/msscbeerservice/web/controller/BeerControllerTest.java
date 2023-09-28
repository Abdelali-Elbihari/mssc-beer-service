package com.abdelalielbihari.msscbeerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.abdelalielbihari.msscbeerservice.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;

@WebMvcTest
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void getBeerById() throws Exception {
    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = BeerDto.builder().beerName("Updated Beer").build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID())
            .content(beerDtoJson)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = BeerDto.builder().build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(post("/api/v1/beer")
            .content(beerDtoJson)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }
}