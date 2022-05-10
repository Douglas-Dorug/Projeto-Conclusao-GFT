package one.digitalinnovation.projetopadroesjavaspring.model.repository;

import one.digitalinnovation.projetopadroesjavaspring.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends CrudRepository<Cliente, Long> {
}
