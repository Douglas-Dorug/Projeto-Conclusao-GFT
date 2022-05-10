package one.digitalinnovation.projetopadroesjavaspring.model.repository;

import one.digitalinnovation.projetopadroesjavaspring.model.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
