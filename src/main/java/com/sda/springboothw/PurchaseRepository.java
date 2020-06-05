package com.sda.springboothw;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    public List<Purchase> findByItem(String item);

    @Query("SELECT p FROM Purchase p WHERE p.value >= :value")
    public List<Purchase> listItemsWithPriceOver(@Param("value") double value);
}
