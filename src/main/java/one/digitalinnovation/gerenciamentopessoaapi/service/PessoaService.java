package one.digitalinnovation.gerenciamentopessoaapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.gerenciamentopessoaapi.dto.request.PessoaDTO;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import one.digitalinnovation.gerenciamentopessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> findAll(){
        List<Pessoa> allPessoa = pessoaRepository.findAll();
        return allPessoa.stream()
                .map(PessoaDTO::new)
                .collect(Collectors.toList());
    }

//    public MessageResponseDTO createPerson(PersonDTO personDTO) {
//        Person personToSave = personMapper.toModel(personDTO);
//
//        Person savedPerson = personRepository.save(personToSave);
//        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
//    }

    public PessoaDTO findById(long id) {
        Pessoa pessoa = verifyIfExists(id);
        return new PessoaDTO(pessoa);
    }

    public void createPessoa(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    private Pessoa verifyIfExists(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa nao encontrada"));
    }
}
