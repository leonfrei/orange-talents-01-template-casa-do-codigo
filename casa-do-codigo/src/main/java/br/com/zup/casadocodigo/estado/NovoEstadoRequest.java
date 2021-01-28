package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado já cadastrado")
    private String nome;
    @NotNull
    private Long idPais;

    public NovoEstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado paraEstado(PaisRepository paisRepository){
        Pais pais = paisRepository.getOne(idPais);
        return new Estado(nome, pais);
    }
}
