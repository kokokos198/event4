package com.example.demo.Repository;

import com.example.demo.Entity.Deals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DealsRepository extends JpaRepository<Deals, Long> {

    /*    @Query(value = """
select * from Deals """, nativeQuery = true)
    List<Deals> findAllById();  */
}

