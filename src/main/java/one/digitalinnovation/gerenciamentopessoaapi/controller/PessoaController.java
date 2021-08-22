package one.digitalinnovation.gerenciamentopessoaapi.controller;

import one.digitalinnovation.gerenciamentopessoaapi.dto.request.PessoaDTO;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import one.digitalinnovation.gerenciamentopessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Pessoa findById(@PathVariable Long id){
        return this.pessoaService.findById(id);
    }
}
