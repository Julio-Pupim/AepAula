package br.com.unicesumar.aep.controller;

import br.com.unicesumar.aep.abstractcrud.AbstractResource;
import br.com.unicesumar.aep.entity.Aluno;
import br.com.unicesumar.aep.repository.AlunoRepository;
import br.com.unicesumar.aep.service.AlunoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController extends AbstractResource<Aluno, AlunoRepository, AlunoService> {

  public AlunoController(AlunoService service) {
    super(service);
  }

}
