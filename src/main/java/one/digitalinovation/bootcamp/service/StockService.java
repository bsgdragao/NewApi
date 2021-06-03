package one.digitalinovation.bootcamp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.bootcamp.exceptions.BusinessException;
import one.digitalinovation.bootcamp.mapper.StockMapper;
import one.digitalinovation.bootcamp.model.Stock;
import one.digitalinovation.bootcamp.model.dto.StockDTO;
import one.digitalinovation.bootcamp.repository.StockRepository;
import one.digitalinovation.bootcamp.util.MessageUtils;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Transactional
	public StockDTO save(StockDTO dto) {
		
		Optional<Stock> optionalStock = stockRepository.findByNameAndDate(dto.getName(), dto.getDate());
		
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
			
		}
		Stock stock = stockMapper.toEntity(dto);
		stockRepository.save(stock);
		return stockMapper.toDto(stock);
	}

}
