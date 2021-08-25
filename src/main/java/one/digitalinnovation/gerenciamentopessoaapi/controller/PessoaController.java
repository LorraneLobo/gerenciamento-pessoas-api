package one.digitalinnovation.gerenciamentopessoaapi.controller;

import one.digitalinnovation.gerenciamentopessoaapi.dto.request.PessoaDTO;
import one.digitalinnovation.gerenciamentopessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pessoa", value = "/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> findAll(){
        return this.pessoaService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.pessoaService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PessoaDTO pessoaDTO){
        pessoaService.createPessoa(pessoaDTO);
    }

    @PutMapping(path = "/{id}")
    public PessoaDTO updateById(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        return pessoaService.updateById(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        pessoaService.deleteById(id);
    }
}
