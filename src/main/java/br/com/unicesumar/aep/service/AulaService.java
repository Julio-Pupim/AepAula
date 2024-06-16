package br.com.unicesumar.aep.service;

import br.com.unicesumar.aep.abstractcrud.AbstractService;
import br.com.unicesumar.aep.entity.Aula;
import br.com.unicesumar.aep.repository.AulaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class AulaService extends AbstractService<Aula, AulaRepository> {

  public AulaService(AulaRepository repository, EntityManager em) {
    super(repository, em);
  }

}
