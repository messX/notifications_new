package com.messx.notifications.lib.service;

import com.messx.notifications.lib.dto.EntityDto;
import com.messx.notifications.lib.entity.AbstractBaseEntity;
import com.messx.notifications.lib.mapper.AbstractBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbstractBaseCrudService<Entity extends AbstractBaseEntity, EntityDTO extends EntityDto> implements IAbstractBaseCrudServiceInterface<Entity,EntityDTO> {

    @Autowired
    private AbstractBaseCrudManager<Entity, Long> abstractBaseCrudManager;

    @Autowired
    private AbstractBaseMapper<Entity, EntityDTO> abstractBaseMapper;

    @Override
    public List<Entity> findAll() {
        return abstractBaseCrudManager.findAll();
    }

    @Override
    public Entity save(EntityDTO entityDto) {
        return abstractBaseCrudManager.save(abstractBaseMapper.mapToEntity(entityDto));
    }

    @Override
    public Optional<Entity> findById(long id) {
        return abstractBaseCrudManager.findById(id);
    }

    @Override
    public void delete(Entity entity) {
        abstractBaseCrudManager.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        abstractBaseCrudManager.deleteById(id);
    }

    @Override
    public Entity update(EntityDTO entityDto, long id) {
        return abstractBaseCrudManager.updateById(abstractBaseMapper.mapToEntity(entityDto), id);
    }
}
