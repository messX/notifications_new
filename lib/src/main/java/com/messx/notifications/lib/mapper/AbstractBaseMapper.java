package com.messx.notifications.lib.mapper;

import com.messx.notifications.lib.dto.EntityDto;
import com.messx.notifications.lib.entity.AbstractBaseEntity;
import org.springframework.stereotype.Component;

@Component
public class AbstractBaseMapper<Entity extends AbstractBaseEntity, EntityDTO extends EntityDto> {
    public EntityDTO mapToDTO(Entity entity){
        return (EntityDTO) EntityDTO.builder().id(entity.getId())
                .status(entity.getStatus())
                .createdTimestamp(entity.getCreatedTimestamp())
                .updatedTimestamp(entity.getUpdatedTimestamp())
                .build();
    };

    public Entity mapToEntity(EntityDTO entityDTO){
        return (Entity) Entity.builder().id(entityDTO.getId())
                .status(entityDTO.getStatus())
                .createdTimestamp(entityDTO.getCreatedTimestamp())
                .updatedTimestamp(entityDTO.getUpdatedTimestamp())
                .build();
    };

}
