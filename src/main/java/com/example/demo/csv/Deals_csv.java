package com.example.demo.csv;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;



//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Deals_csv {


    @CsvBindByName(column = "costs")
    private Long costs;

    @CsvBindByName(column = "number")
    private String number;

    @CsvBindByName(column = "ClientID")
    private Long ClientID;

    @CsvBindByName(column = "FO")
    private String FO;

    public Long getCosts() {
        return costs;
    }

    public void setCosts(Long costs) {
        this.costs = costs;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getClientID() {
        return ClientID;
    }

    public void setClientID(Long clientID) {
        ClientID = clientID;
    }

    public String getFo() {
        return FO;
    }

    public void setFo(String fo) {
        this.FO = FO;
    }


}
