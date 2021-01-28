package br.com.zup.casadocodigo.livro;

public class ListaLivrosDTO {

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ListaLivrosDTO(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }
}
