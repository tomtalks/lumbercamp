package com.soprasteria.lumbercamp.repository;

import com.soprasteria.lumbercamp.api.dto.IStockDto;
import com.soprasteria.lumbercamp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
      //select sum(quantity) as sum from stock where type = 'oak';
    @Query(value ="select sum(s.quantity) as stock from stock as s where s.type = :type",
          nativeQuery = true)
  List<Integer> getStock(@Param("type") String type);

  List<Stock> findByType(String type);

  @Query(value= "select type from stock group by type;",nativeQuery = true)
  List<String> findType();


  @Query(value ="select sum(s.quantity) as quantity, s.type as type from stock as s group by type;",nativeQuery = true)
  List<IStockDto> sumQuantityByType();

}
