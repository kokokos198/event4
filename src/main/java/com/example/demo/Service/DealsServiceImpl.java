package com.example.demo.Service;

import com.example.demo.Entity.Deals;
import com.example.demo.Repository.DealsRepository;
import com.example.demo.csv.Deals_csv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated

//@RequiredArgsConstructor
public class DealsServiceImpl implements  DealsService {

    private final DealsRepository dealsRepository;

    public DealsServiceImpl(DealsRepository dealsRepository) {
        this.dealsRepository = dealsRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Deals getDeals(Long id)
        {
            return dealsRepository.findById(id).get();

        }

    @Override
    @Transactional
    public Deals update(Deals deals, Long id) {
        System.out.println(id);
        System.out.println(dealsRepository.findById(id));
        if (dealsRepository.findById(id) != null) {
             dealsRepository.save(deals);
        }
        return deals;
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        if (getDeals(id) != null) {
            dealsRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public Deals create(Deals deals) {
            dealsRepository.save(deals);
        return deals;
    }

    public Integer uploadcsv(MultipartFile file) throws IOException {
        Set<Deals> deals_csv = parse_csv(file);
        dealsRepository.saveAll(deals_csv);
        return null;
    }

private Set<Deals> parse_csv(MultipartFile file) throws IOException {
   try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
   {
       HeaderColumnNameMappingStrategy<Deals_csv> head = new HeaderColumnNameMappingStrategy<>();
head.setType(Deals_csv.class);
       CsvToBean<Deals_csv> csv_bean = new CsvToBeanBuilder<Deals_csv>(reader)
               .withMappingStrategy(head)
               .withSeparator(';')
               .withIgnoreEmptyLine(true)
               .withIgnoreLeadingWhiteSpace(true)
               .build();

    return   csv_bean.parse()
               .stream().map(line -> Deals.builder()
           .costs(line.getCosts())
           .number(line.getNumber())
           .ClientID(line.getClientID())
           .build())
           .collect(Collectors.toSet());

   }
}


}


