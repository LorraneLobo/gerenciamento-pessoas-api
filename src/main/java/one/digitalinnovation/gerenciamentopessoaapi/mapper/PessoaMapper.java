package one.digitalinnovation.gerenciamentopessoaapi.mapper;

import one.digitalinnovation.gerenciamentopessoaapi.dto.request.PessoaDTO;
import one.digitalinnovation.gerenciamentopessoaapi.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    Pessoa toModel(PessoaDTO dto);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
    PessoaDTO toDTO(Pessoa dto);
}
