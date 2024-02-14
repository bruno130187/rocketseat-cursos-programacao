package br.com.bruno.cursoprogramacao.modules.cursos.useCases;

import br.com.bruno.cursoprogramacao.exceptions.CursoFoundException;
import br.com.bruno.cursoprogramacao.exceptions.CursoNotFoundException;
import br.com.bruno.cursoprogramacao.exceptions.RequiredObjectIsNullException;
import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import br.com.bruno.cursoprogramacao.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoUpdateUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoEntity cursoEntity) {
        System.out.println("Atualizando um Curso!");

        if (cursoEntity == null) {
            throw new RequiredObjectIsNullException();
        }

        var cursoEncontrado = this.cursoRepository.findById(cursoEntity.getId());

        if (!cursoEncontrado.isPresent()) {
            throw new CursoNotFoundException();
        } else {
            cursoEntity.setActive(true);
            cursoEntity.setCreatedAt(cursoEncontrado.get().getCreatedAt());
            return this.cursoRepository.save(cursoEntity);
        }

    }

}
