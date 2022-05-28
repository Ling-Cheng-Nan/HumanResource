package com.example.humanresource.clockin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="clockin")
public class ClockIn {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String primary_key;

    public String empid;
    
    public String person_name;
    
    public String status;
    
    public Date check_date;
    
    public String description;

}
