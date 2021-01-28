package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Pais já cadastrado")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais paraPais() {
        return new Pais(nome);
    }
}
