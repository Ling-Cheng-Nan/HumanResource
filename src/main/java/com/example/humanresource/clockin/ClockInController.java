package com.example.humanresource.clockin;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clockin")
public class ClockInController {


	@Autowired 
	private  ClockInService clockin_service;

    // public ClockInController(ClockInService clockin_service) {
	// 	this.clockin_service = clockin_service;
	// }
	
	@GetMapping("/test")
	public String test() {
		return "test successfully";
	}

	@GetMapping
	public ResponseEntity getAll() {
		return ResponseEntity.ok(this.clockin_service.fetchAllRecords());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClockIn> getCertain(@PathVariable("id") String id) {
		
		Optional<ClockIn> result = this.clockin_service.certainRecord(id);
		
		if(result.isPresent()) {
			return new ResponseEntity<>(result.get() ,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<ClockIn> createNew(@RequestBody ClockIn newRecord) {
		try {
			ClockIn clockin = this.clockin_service.create(newRecord);
			
			return new ResponseEntity<>(clockin, HttpStatus.CREATED);
		
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// @PutMapping("/{id}")
	// public ResponseEntity<ClockIn> updateCertain(@PathVariable("id") String id, @RequestBody ClockIn record)
	@PutMapping
	public ResponseEntity<ClockIn> updateCertain(@RequestBody ClockIn source) {
		
		/* find the record is existing in the database or not first*/
		Optional<ClockIn> record_found = this.clockin_service.certainRecord(source.getPrimary_key());
		
		if(record_found.isPresent()) {

			ClockIn target = record_found.get();
			
			/* update the infomation of the desired one */
			target.setEmpid(source.getEmpid());
			target.setPerson_name(source.getPerson_name());
			target.setStatus(source.getStatus());
			target.setCheck_date(source.getCheck_date());
			target.setDescription(source.getDescription());
			target.setLatitude(source.getLatitude());
			target.setLongitude(source.getLongitude());

			/* save the target record in the service */
			return new ResponseEntity<>(this.clockin_service.save(target), HttpStatus.OK);
		}
		else {
			/*create a new one if there is no id founded*/
			try {
				ClockIn newRecord = this.clockin_service.create(new ClockIn());
				
				return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
			
			} catch (Exception e) {
				
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			/*return NOT founded error*/
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCertain(@PathVariable("id") String id) {
		
		try {
		
			this.clockin_service.deleteCertainRecord(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		} catch (Exception e) {
		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> clearAll() {
		try {
			this.clockin_service.clearAllRecords();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
