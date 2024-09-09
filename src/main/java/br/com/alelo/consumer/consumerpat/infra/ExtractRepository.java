package br.com.alelo.consumer.consumerpat.infra;

import br.com.alelo.consumer.consumerpat.domain.entity.Extract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractRepository extends JpaRepository<Extract, Integer> {
}