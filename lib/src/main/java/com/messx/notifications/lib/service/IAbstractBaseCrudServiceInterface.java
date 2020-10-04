package com.messx.notifications.lib.service;

import com.messx.notifications.lib.dto.EntityDto;
import com.messx.notifications.lib.entity.AbstractBaseEntity;

import java.util.List;
import java.util.Optional;

public interface IAbstractBaseCrudServiceInterface<Entity extends AbstractBaseEntity, EntityDTO extends EntityDto> {
    List<Entity> findAll();
    Entity save(EntityDTO entityDto);
    Optional<Entity> findById(long id);
    void delete(Entity entity);
    void deleteById(long id);
    Entity update(EntityDTO entityDto, long id);
}
