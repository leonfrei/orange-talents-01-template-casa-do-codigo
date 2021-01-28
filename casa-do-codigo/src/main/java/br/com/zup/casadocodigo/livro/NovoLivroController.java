package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autores.AutorRepository;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class NovoLivroController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest){
        Livro livro = novoLivroRequest.paraLivro(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }


}
