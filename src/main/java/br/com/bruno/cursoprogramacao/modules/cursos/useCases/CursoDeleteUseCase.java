package br.com.bruno.cursoprogramacao.modules.cursos.useCases;

import br.com.bruno.cursoprogramacao.exceptions.CursoNotFoundException;
import br.com.bruno.cursoprogramacao.exceptions.RequiredObjectIsNullException;
import br.com.bruno.cursoprogramacao.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CursoDeleteUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public String execute(UUID id) {
        System.out.println("Excluindo um Curso!");

        if (id == null) {
            throw new RequiredObjectIsNullException();
        }

        var cursoEncontrado = this.cursoRepository.findById(id);

        if (!cursoEncontrado.isPresent()) {
            throw new CursoNotFoundException();
        } else {
            this.cursoRepository.deleteById(cursoEncontrado.get().getId());
            return "Curso (" + cursoEncontrado.get().getName() + ") deletado!";
        }
    }

}
