package com.abdelalielbihari.msscbeerservice.repositories;

import com.abdelalielbihari.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
