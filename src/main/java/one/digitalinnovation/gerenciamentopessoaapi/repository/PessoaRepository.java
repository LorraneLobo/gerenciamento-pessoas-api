package one.digitalinnovation.gerenciamentopessoaapi.repository;

import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
