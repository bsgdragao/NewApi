package one.digitalinovation.bootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinovation.bootcamp.exceptions.BusinessException;
import one.digitalinovation.bootcamp.exceptions.NotFoundException;
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
	
	@Transactional
	public StockDTO update(StockDTO dto) {
		
		Optional<Stock> optionalStock = stockRepository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
		
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
			
		}
		
		Stock stock = stockMapper.toEntity(dto);
		stockRepository.save(stock);
		return stockMapper.toDto(stock);
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {
		return stockMapper.toListDto(stockRepository.findAll());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		return stockRepository.findById(id).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO stockDto = this.findById(id);		
		stockRepository.deleteById(stockDto.getId());
		return stockDto;
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		return stockRepository.findByToday(LocalDate.now()).map(stockMapper::toListDto).orElseThrow(NotFoundException::new);
	}
	
	

}
