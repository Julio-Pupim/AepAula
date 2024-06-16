package br.com.unicesumar.aep.controller;

import br.com.unicesumar.aep.abstractcrud.AbstractResource;
import br.com.unicesumar.aep.entity.Aula;
import br.com.unicesumar.aep.repository.AulaRepository;
import br.com.unicesumar.aep.service.AulaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aula")
@CrossOrigin("*")
public class AulaController extends AbstractResource<Aula, AulaRepository, AulaService> {

  public AulaController(AulaService service) {
    super(service);
  }
}
