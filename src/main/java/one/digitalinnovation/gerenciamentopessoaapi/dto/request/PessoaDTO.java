package one.digitalinnovation.gerenciamentopessoaapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Telefone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 120)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    private LocalDate dataNascimento;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sobrenome = pessoa.getSobrenome();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento();
        this.telefones = pessoa.getTelefones();
    }
}
