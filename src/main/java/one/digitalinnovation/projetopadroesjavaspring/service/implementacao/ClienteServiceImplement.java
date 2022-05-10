package one.digitalinnovation.projetopadroesjavaspring.service.implementacao;

import one.digitalinnovation.projetopadroesjavaspring.model.entity.Cliente;
import one.digitalinnovation.projetopadroesjavaspring.model.entity.Endereco;
import one.digitalinnovation.projetopadroesjavaspring.model.repository.ClienteRespository;
import one.digitalinnovation.projetopadroesjavaspring.model.repository.EnderecoRepository;
import one.digitalinnovation.projetopadroesjavaspring.service.ClienteService;
import one.digitalinnovation.projetopadroesjavaspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRespository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRespository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBancoDeDados = clienteRespository.findById(id);
        if (clienteBancoDeDados.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRespository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById((cep))
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        cliente.setEndereco(endereco);
        clienteRespository.save(cliente);
    }
}
