package br.com.zup.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<ListaLivrosDTO>> listar(){
        List<Livro> livros = livroRepository.findAll();
        List<ListaLivrosDTO> listaLivrosDTO = livros.stream().map(ListaLivrosDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(listaLivrosDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity detalhar(@PathVariable("id") Long id){
        Optional<Livro> possivelLivro = livroRepository.findById(id);
        if (possivelLivro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new LivroDetalhadoDTO(possivelLivro.get()));
    }

}
