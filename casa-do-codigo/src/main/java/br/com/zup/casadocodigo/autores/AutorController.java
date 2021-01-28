package br.com.zup.casadocodigo.autores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid NovoAutorRequest novoAutorRequest){
        Autor autor = novoAutorRequest.paraAutor();
        System.out.println(autor);
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
