package com.abdelalielbihari.msscbeerservice.repositories;

import com.abdelalielbihari.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface BeerRepository extends CrudRepository<Beer, UUID> {

}
