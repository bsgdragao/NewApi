package one.digitalinovation.bootcamp.repository;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import one.digitalinovation.bootcamp.model.Stock;
import one.digitalinovation.bootcamp.model.dto.StockDTO;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	void save(@Valid StockDTO dto);

	Optional<Stock> findByNameAndDate(String name, LocalDate date);

	@Query("SELECT stock FROM Stock stock WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id ")	
	Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);
	
	

}
