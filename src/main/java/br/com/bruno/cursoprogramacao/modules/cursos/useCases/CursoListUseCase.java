package br.com.bruno.cursoprogramacao.modules.cursos.useCases;

import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import br.com.bruno.cursoprogramacao.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoListUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute() {
        System.out.println("Listando Cursos!");
        return this.cursoRepository.findByActiveTrue();
    }

}
