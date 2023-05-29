package com.example.Insurance_and_Claims.Model;

import com.example.Insurance_and_Claims.Model.Insurance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "vehicle_insurance_condition")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private long vehicle_id;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "vehicle_insurance",
//            joinColumns = @JoinColumn(name = "vehicle_id"),
//            inverseJoinColumns = @JoinColumn(name = "insurance_id"))
//    private Set<Insurance> enrolled_vehicle_condition=new HashSet<>();

    @Column(name = "vehicle_type")
    private String type;

    @Column(name = "vehicle_classification")
    private String classification;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @JsonBackReference
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "insurance_id",referencedColumnName = "insurance_id")
//    private Insurance insurance;

    public Vehicle(long vehicle_id, String type, String classification,Integer amount) {
        this.vehicle_id = vehicle_id;
        this.type = type;
        this.classification = classification;
        this.amount = amount;
    }

    public Vehicle() {
    }

    public void assignInsurance(Insurance insurance) {
        this.insurance=insurance;
    }

//    public void assignInsurance(Insurance insurance) {
//        this.enrolled_vehicle_condition.add(insurance);
//    }

//    public void assignInsurance(Insurance insurance) {
//        this.insurance=insurance;
//    }
}
