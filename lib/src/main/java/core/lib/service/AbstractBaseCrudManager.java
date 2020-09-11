package core.lib.service;

import core.lib.entity.AbstractBaseEntity;
import core.lib.repository.AbstractBaseRepository;
import core.lib.enums.Status;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Data
@Transactional
public class AbstractBaseCrudManager<T extends AbstractBaseEntity, ID extends Serializable> implements IAbstractBaseCrudManager<T, ID> {

    @Autowired
    private AbstractBaseRepository abstractBaseRepository;

    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) abstractBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return (Optional<T>) abstractBaseRepository.findById(id);
    }

    @Override
    public void delete(T entity) {
        if(!entity.getStatus().equals(Status.ACTIVE)){
            entity.setStatus(Status.INACTIVE);
        }
        update(entity);
    }

    @Override
    public void deleteById(ID id) {
        Optional<T> oldEntity= findById(id);
        if(oldEntity.isPresent()){
            delete(oldEntity.get());
        }
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID id) {
        Optional<T> oldEntity= findById((ID) entity.getId());
        if(oldEntity.isPresent()){
            return update(entity);
        }
        else{
            return null;
        }
    }

}
