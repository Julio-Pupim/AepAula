package br.com.unicesumar.aep.abstractcrud;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class AbstractResource<Entity extends AbstractEntity,Repository extends AbstractRepository<Entity>,
                              Service extends AbstractService<Entity,Repository>>{

  private final Service service;

  @Autowired
  public AbstractResource(Service service){
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Entity> save(@RequestBody Entity entity){
    Entity save = service.save(entity);
    if(Objects.nonNull(save)){
    return  ResponseEntity.ok(save);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Entity> findById(@PathVariable Long id){
    Entity result = service.findById(id);
    if(Objects.nonNull(result)){
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping
  public ResponseEntity<List<Entity>> findAll(){
    return ResponseEntity.ok(service.getAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Entity> upadte(@RequestBody Entity atualizado, @PathVariable Long id ){
    Entity resultUpdate = service.update(id, atualizado);
    if(Objects.nonNull(resultUpdate)){
      return ResponseEntity.ok(resultUpdate);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id){
    service.deleteById(id);
    return ResponseEntity.ok().build();

  }

}
