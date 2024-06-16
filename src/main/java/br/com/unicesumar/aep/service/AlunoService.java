package br.com.unicesumar.aep.service;

import br.com.unicesumar.aep.abstractcrud.AbstractService;
import br.com.unicesumar.aep.entity.Aluno;
import br.com.unicesumar.aep.repository.AlunoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class AlunoService extends AbstractService<Aluno, AlunoRepository> {

  public AlunoService(AlunoRepository repository, EntityManager em) {
    super(repository, em);
  }

}
