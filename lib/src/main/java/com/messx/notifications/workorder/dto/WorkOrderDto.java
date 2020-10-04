package com.messx.notifications.workorder.dto;

import com.messx.notifications.lib.dto.EntityDto;
import com.messx.notifications.workorder.enums.WOClientType;
import com.messx.notifications.workorder.enums.WOStatus;
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
