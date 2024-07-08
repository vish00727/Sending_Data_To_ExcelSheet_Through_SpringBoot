package com.example.poiji.area_master.repo;

import com.example.poiji.area_master.entity.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StateRepo extends JpaRepository<StateMaster,Long> {
    @Query(value = " select * from state_country_dropdown_fun2()", nativeQuery = true)
    List<Map<String, Object>> getStateDropDown();
}
