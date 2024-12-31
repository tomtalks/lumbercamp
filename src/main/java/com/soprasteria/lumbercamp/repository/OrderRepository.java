package com.soprasteria.lumbercamp.repository;

import com.soprasteria.lumbercamp.model.WoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<WoodOrder, Integer> {


}
