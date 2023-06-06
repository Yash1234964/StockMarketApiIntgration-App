package pr.project.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pr.project.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceController {

	@Autowired
	private IStockPriceService service;
	
	@GetMapping("/stockprice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName){
		
		Double price=service.findByCompanyName(companyName);
		System.out.println(price+" "+companyName);
		
		return new ResponseEntity<Double>(price,HttpStatus.OK);
		
	}
	
}
