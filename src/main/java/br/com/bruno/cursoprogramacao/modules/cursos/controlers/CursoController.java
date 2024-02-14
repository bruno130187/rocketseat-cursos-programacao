package br.com.bruno.cursoprogramacao.modules.cursos.controlers;

import br.com.bruno.cursoprogramacao.modules.cursos.entities.CursoEntity;
import br.com.bruno.cursoprogramacao.modules.cursos.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/curso")
public class CursoController {

    @Autowired
    private CursoCreateUseCase cursoCreateUseCase;

    @Autowired
    private CursoListUseCase cursoListUseCase;

    @Autowired
    private CursoUpdateUseCase cursoUpdateUseCase;

    @Autowired
    private CursoDeleteUseCase cursoDeleteUseCase;

    @Autowired
    private CursoActiveUseCase cursoActiveUseCase;

    @PostMapping(path = "/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity) {
        try {
            var result = this.cursoCreateUseCase.execute(cursoEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<Object> list() {
        try {
            var result = this.cursoListUseCase.execute();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable UUID id, @RequestBody CursoEntity cursoEntity) {
        try {
            cursoEntity.setId(id);
            var result = this.cursoUpdateUseCase.execute(cursoEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            var result = this.cursoDeleteUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}/active")
    public ResponseEntity<Object> active(@PathVariable UUID id) {
        try {
            var result = this.cursoActiveUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
