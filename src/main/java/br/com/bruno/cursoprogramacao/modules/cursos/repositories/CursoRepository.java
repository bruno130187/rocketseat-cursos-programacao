package br.com.bruno.cursoprogramacao.modules.cursos.repositories;

import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {

    Optional<CursoEntity> findByName(String name);

    @Override
    Optional<CursoEntity> findById(UUID id);

    List<CursoEntity> findByActiveTrue();

}
