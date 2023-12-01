package com.abdelalielbihari.msscbeerservice.repositories;

import com.abdelalielbihari.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface BeerRepository extends CrudRepository<Beer, UUID> {

}
