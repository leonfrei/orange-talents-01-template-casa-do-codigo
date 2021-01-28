package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome de autor já sendo utilizado")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria paraCategoria() {
        return new Categoria(nome);
    }
}
