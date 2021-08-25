package one.digitalinnovation.gerenciamentopessoaapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.gerenciamentopessoaapi.dto.request.PessoaDTO;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import one.digitalinnovation.gerenciamentopessoaapi.mapper.PessoaMapper;
import one.digitalinnovation.gerenciamentopessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public List<PessoaDTO> findAll(){
        List<Pessoa> allPessoa = pessoaRepository.findAll();
        return allPessoa.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(long id) {
        Pessoa pessoa = verifyIfExists(id);
        return pessoaMapper.toDTO(pessoa);
    }

    public void createPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        pessoaRepository.save(pessoa);
    }

    public PessoaDTO updateById(Long id, PessoaDTO pessoaDTO){
        verifyIfExists(id);
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        pessoa.setId(id);
        return pessoaMapper.toDTO(pessoaRepository.save(pessoa));
    }

    public void deleteById(Long id){
        verifyIfExists(id);
        pessoaRepository.deleteById(id);
    }

    private Pessoa verifyIfExists(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa nao encontrada com o ID informado!"));
    }
}
