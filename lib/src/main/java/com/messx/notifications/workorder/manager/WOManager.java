package com.messx.notifications.workorder.manager;

import com.messx.notifications.lib.entity.AbstractBaseEntity;
import com.messx.notifications.lib.service.AbstractBaseCrudManager;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WOManager<WorkOrder extends AbstractBaseEntity, Long extends Serializable> extends AbstractBaseCrudManager<WorkOrder, Long> {
}
