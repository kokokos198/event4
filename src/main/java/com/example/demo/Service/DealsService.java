package com.example.demo.Service;

import com.example.demo.Entity.Deals;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DealsService {


  //  Optional<Optional<Deals>> getbyid(Long id);
    //  List<Deals> getAllDeals();
    Deals getDeals(Long id);
    Deals update(Deals deals, Long id);
    void delete(Long id);
    Deals create (Deals deals);
    Integer uploadcsv(MultipartFile file) throws IOException;
}
