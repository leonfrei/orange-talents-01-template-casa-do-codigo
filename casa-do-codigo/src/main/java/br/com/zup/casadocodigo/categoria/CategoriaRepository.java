package br.com.zup.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
