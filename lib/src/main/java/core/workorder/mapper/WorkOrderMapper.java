package core.workorder.mapper;

import core.workorder.dto.WorkOrderDto;
import core.workorder.model.WorkOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WorkOrderMapper {
    @Mapping(target = "updatedTimestamp", expression = "java(java.time.Instant.now())")
    public abstract WorkOrder map(WorkOrderDto workOrderDto);
}
