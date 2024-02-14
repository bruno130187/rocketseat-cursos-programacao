package br.com.bruno.cursoprogramacao.modules.cursos.useCases;

import br.com.bruno.cursoprogramacao.exceptions.CursoNotFoundException;
import br.com.bruno.cursoprogramacao.exceptions.RequiredObjectIsNullException;
import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import br.com.bruno.cursoprogramacao.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CursoActiveUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(UUID id) {
        System.out.println("Atualizando active de um Curso!");

        if (id == null) {
            throw new RequiredObjectIsNullException();
        }

        var cursoEncontrado = this.cursoRepository.findById(id);

        if (!cursoEncontrado.isPresent()) {
            throw new CursoNotFoundException();
        } else {

            if (cursoEncontrado.get().getActive()) {
                cursoEncontrado.get().setActive(false);
            } else {
                cursoEncontrado.get().setActive(true);
            }

            return this.cursoRepository.save(cursoEncontrado.get());
        }
    }

}
