package br.com.unicesumar.aep.controller;

import br.com.unicesumar.aep.abstractcrud.AbstractResource;
import br.com.unicesumar.aep.entity.Professor;
import br.com.unicesumar.aep.repository.ProfessorRepository;
import br.com.unicesumar.aep.service.ProfessorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
@CrossOrigin("*")
public class ProfessorController extends AbstractResource<Professor, ProfessorRepository,ProfessorService> {

  public ProfessorController(ProfessorService service) {
    super(service);
  }
}
