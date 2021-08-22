package one.digitalinnovation.gerenciamentopessoaapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import one.digitalinnovation.gerenciamentopessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public Pessoa findById(long id) {
        return this.pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
}
