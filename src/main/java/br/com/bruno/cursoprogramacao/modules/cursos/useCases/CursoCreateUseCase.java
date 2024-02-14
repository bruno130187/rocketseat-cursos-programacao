package br.com.bruno.cursoprogramacao.modules.cursos.useCases;

import br.com.bruno.cursoprogramacao.exceptions.CursoFoundException;
import br.com.bruno.cursoprogramacao.exceptions.RequiredObjectIsNullException;
import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import br.com.bruno.cursoprogramacao.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoCreateUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoEntity cursoEntity) {
        System.out.println("Criando um Curso!");

        if (cursoEntity == null) {
            throw new RequiredObjectIsNullException();
        }

        this.cursoRepository
                .findByName(cursoEntity.getName())
                .ifPresent((curso) -> {
                    throw new CursoFoundException();
                });

        cursoEntity.setActive(true);

        return this.cursoRepository.save(cursoEntity);
    }

}
