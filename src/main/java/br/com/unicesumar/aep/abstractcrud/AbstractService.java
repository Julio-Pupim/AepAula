package br.com.unicesumar.aep.abstractcrud;



import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<Entity extends AbstractEntity, Repository extends AbstractRepository<Entity>> {

  private final Repository repository;
  private final EntityManager em;

  @Autowired
  public AbstractService(Repository repository, EntityManager em) {
    this.repository = repository;
    this.em = em;
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
    Optional<Entity> entityOptional = repository.findById(id);
    if(entityOptional.isPresent()){
      Entity entityPresent = entityOptional.get();
      em.detach(entityPresent);
      BeanUtils.copyProperties(entity,entityPresent);
    return repository.save(entityPresent);
    }
    return null;
  }
}