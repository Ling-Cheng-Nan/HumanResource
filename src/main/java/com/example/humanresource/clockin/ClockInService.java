package com.example.humanresource.clockin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockInService {
     
    @Autowired 
    ClockInRepository clockin_repo;

    public List<ClockIn> allRecords(){
        return this.clockin_repo.findAll();
    }

    public Optional<ClockIn> certainRecord(String id){
        
        Optional<ClockIn> result = this.clockin_repo.findById(id);
		
        return result;
    }
}
