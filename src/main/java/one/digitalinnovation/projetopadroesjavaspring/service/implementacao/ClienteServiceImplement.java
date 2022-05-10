package one.digitalinnovation.projetopadroesjavaspring.service.implementacao;

import one.digitalinnovation.projetopadroesjavaspring.model.entity.Cliente;
import one.digitalinnovation.projetopadroesjavaspring.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplement implements ClienteService {
    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
