package pr.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pr.project.entity.StockPrice;
import pr.project.exception.StockNotFoundException;
import pr.project.repository.StockRepo;

@Service
public class StockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private StockRepo repo;
	
	@Override
	public Double findByCompanyName(String companyName) {
	
		StockPrice stockPrice=repo.findByCompanyName(companyName);
		if(stockPrice==null) {
			throw new StockNotFoundException("Company not available");
		}
		
		return stockPrice.getCompanyPrice();
	}

}
