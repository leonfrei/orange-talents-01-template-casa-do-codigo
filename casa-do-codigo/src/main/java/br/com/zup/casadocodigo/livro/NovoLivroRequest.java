package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autores.AutorRepository;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;
import br.com.zup.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(fieldName = "titulo", domainClass = Livro.class, message = "Já existe um livro com este nome")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @DecimalMin(value = "20")
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @UniqueValue(fieldName = "isbn", domainClass = Livro.class, message = "Já existe um livro com este isbn")
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    private Long idCategoria;
    @NotNull
    private Long idAutor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro paraLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autorRepository.getOne(idAutor), categoriaRepository.getOne(idCategoria));
    }
}
