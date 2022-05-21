package clockin;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clockin")
public class ClockInController {
    
    @Autowired
    private  ClockInRepository clockin_Repository;

	@Autowired 
	private  ClockInService clockIn_Service;

    public ClockInController(ClockInRepository clockin_Repository) {
		this.clockin_Repository = clockin_Repository;
	}
	
	@GetMapping
	public ResponseEntity getAll() {
		return ResponseEntity.ok(this.clockin_Repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClockIn> findById(@PathVariable("id") Long id) {
		
		Optional<ClockIn> result = this.clockin_Repository.findById(id);
		
		if(result.isPresent()) {
			return new ResponseEntity<>(result.get() ,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// @PostMapping
	// public ResponseEntity<ClockIn> createProduct(@RequestBody ClockIn newProduct) {
	// 	try {
	// 		ClockIn clockin = clockin_Repository
	// 				.save(new ClockIn(newProduct.getName(), newProduct.getDescription() ));
			
	// 		return new ResponseEntity<>(clockin, HttpStatus.CREATED);
		
	// 	} catch (Exception e) {
			
	// 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }
	
	// @PutMapping("/{id}")
	// public ResponseEntity<ClockIn> updateProduct(@PathVariable("id") Long id, @RequestBody ClockIn newProduct) {
		
	// 	Optional<ClockIn> desired_Product = this.clockin_Repository.findById(id);
		
	// 	if(desired_Product.isPresent()) {
	// 		ClockIn product_to_be_updated = desired_Product.get();
			
	// 		product_to_be_updated.setId(id);
	// 		product_to_be_updated.setName(newProduct.getName());
	// 		product_to_be_updated.setDescription(newProduct.getDescription());
			
	// 		return new ResponseEntity<>(this.clockin_Repository.save(product_to_be_updated), HttpStatus.OK);
	// 	}
	// 	else {
	// 		/*create a new one if there is no id founded*/
	// 		try {
	// 			ClockIn product = clockin_Repository
	// 					.save(new Product(newProduct.getName(), newProduct.getDescription() ));
				
	// 			return new ResponseEntity<>(product, HttpStatus.CREATED);
			
	// 		} catch (Exception e) {
				
	// 			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// 		}
			
	// 		/*return NOT founded error*/
	// 		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
		
	// }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
		try {
			
			this.clockin_Repository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			
			this.clockin_Repository.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
