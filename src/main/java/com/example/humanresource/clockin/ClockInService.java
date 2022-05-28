package com.example.humanresource.clockin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockInService {
     
    @Autowired 
    ClockInRepository clockin_repo;
    
    /* CREATE */
    public ClockIn create(ClockIn newRecord){
        // ClockIn clockin = this.clockin_repo.save(new ClockIn());
        return this.clockin_repo.saveAndFlush(newRecord);
        
    }

    public ClockIn save(ClockIn record){
        return this.clockin_repo.saveAndFlush(record);
    }


    /* QUERY */
    public List<ClockIn> fetchAllRecords(){
        return this.clockin_repo.findAll();
    }

    public Optional<ClockIn> certainRecord(String id){
        
        Optional<ClockIn> result = this.clockin_repo.findById(id);
		
        return result;
    }

    /* UPDATE */


    /* DELETE */
    public void deleteCertainRecord(String id){
        this.clockin_repo.deleteById(id);
    }

    public void clearAllRecords(){
        this.clockin_repo.deleteAll();
    }
}
