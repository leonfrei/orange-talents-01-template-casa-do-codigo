package br.com.zup.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
       Categoria categoria = novaCategoriaRequest.paraCategoria();
       System.out.println(categoria);
       categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
