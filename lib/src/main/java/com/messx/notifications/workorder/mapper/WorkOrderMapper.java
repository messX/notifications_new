package com.messx.notifications.workorder.mapper;

import com.messx.notifications.workorder.model.WorkOrder;
import com.messx.notifications.workorder.dto.WorkOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WorkOrderMapper {
    @Mapping(target = "updatedTimestamp", expression = "java(java.time.Instant.now())")
    public abstract WorkOrder map(WorkOrderDto workOrderDto);
}
