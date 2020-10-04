package com.messx.notifications.workorder.model;

import com.messx.notifications.lib.entity.AbstractBaseEntity;
import com.sun.istack.NotNull;
import com.messx.notifications.workorder.enums.WOClientType;
import com.messx.notifications.workorder.enums.WOStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrder extends AbstractBaseEntity {

    @Lob
    private String description;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name="action_status", columnDefinition = "varchar(20) DEFAULT 'initiated'")
    private WOStatus actionStatus;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "client_type")
    private WOClientType clientType;

    @NotNull
    private String agent;

}
