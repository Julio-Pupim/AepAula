package br.com.unicesumar.aep.abstractcrud;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<Entity extends AbstractEntity, Repository extends AbstractRepository<Entity>> {

  private final Repository repository;

  @Autowired
  protected AbstractService(Repository repository) {
    this.repository = repository;
  }

  public Entity save(Entity entity){
    return repository.save(entity);
  }

  public Entity findById(Long id){
    return repository.findById(id).orElse(null);
  }

  public void deleteById(Long id){
    repository.deleteById(id);
  }

  public List<Entity> getAll(){
    return repository.findAll();
  }

  public Entity update(Long id, Entity entity){
    repository.findById(id).map(e-> {
      e.setId(id);
      return repository.save(entity);
    });
    return null;
  }
}