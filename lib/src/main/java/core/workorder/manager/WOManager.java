package core.workorder.manager;

import core.lib.entity.AbstractBaseEntity;
import core.lib.service.AbstractBaseCrudManager;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WOManager<WorkOrder extends AbstractBaseEntity, Long extends Serializable> extends AbstractBaseCrudManager<WorkOrder, Long> {
}
