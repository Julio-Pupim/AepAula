package br.com.unicesumar.aep.service;

import br.com.unicesumar.aep.abstractcrud.AbstractService;
import br.com.unicesumar.aep.entity.Professor;
import br.com.unicesumar.aep.repository.ProfessorRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService extends AbstractService<Professor, ProfessorRepository> {

  public ProfessorService(ProfessorRepository repository, EntityManager em) {
    super(repository, em);
  }
}
