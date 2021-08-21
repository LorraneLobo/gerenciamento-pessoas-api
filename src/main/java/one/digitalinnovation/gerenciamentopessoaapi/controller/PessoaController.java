package one.digitalinnovation.gerenciamentopessoaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pessoa", value = "/api/pessoa")
public class PessoaController {

    @GetMapping
    public String getMessage(){
        return "Hello!";
    }
}
