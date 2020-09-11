package core.workorder.dto;

import core.lib.dto.EntityDto;
import core.workorder.enums.WOClientType;
import core.workorder.enums.WOStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class WorkOrderDto extends EntityDto {
    private String description;
    private WOStatus actionStatus;
    private WOClientType clientType;
    private String agent;
    private Instant createdTimestamp;
    private Instant updatedTimestamp;
}
