package com.example.demo.Entity;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Deals")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)

public class Deals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CsvBindByName(column = "costs")
    @Column(name = "costs")
    private Long costs;

    @CsvBindByName(column = "number")
    @Column(name = "number")
    private String number;

    @CsvBindByName(column = "ClientID")
    @Column(name = "ClientID")
    private Long ClientID;

    @CsvBindByName(column = "FO")
    @Column(name = "FO")
    private String FO;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getCosts() {
//        return costs;
//    }
//
//    public void setCosts(Long costs) {
//        this.costs = costs;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public Long getClientID() {
//        return ClientID;
//    }
//
//    public void setClientID(Long clientID) {
//        ClientID = clientID;
//    }
//
//    public String getFo() {
//        return FO;
//    }
//
//    public void setFo(String fo) {
//        this.FO = FO;
//    }
//
//    @Override
//    public String toString() {
//        return "Deals{" +
//                "id=" + id +
//                ", costs=" + costs +
//                ", number='" + number + '\'' +
//                ", ClientID=" + ClientID +
//                ", FO='" + FO + '\'' +
//                '}';
//    }

}
