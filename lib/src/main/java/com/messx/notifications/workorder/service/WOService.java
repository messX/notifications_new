package com.messx.notifications.workorder.service;

import com.messx.notifications.lib.service.AbstractBaseCrudManager;
import com.messx.notifications.lib.service.IAbstractBaseCrudServiceInterface;
import com.messx.notifications.workorder.dto.WorkOrderDto;
import com.messx.notifications.workorder.mapper.WorkOrderMapper;
import com.messx.notifications.workorder.model.WorkOrder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WOService implements IAbstractBaseCrudServiceInterface<WorkOrder, WorkOrderDto> {

    @Autowired
    private final AbstractBaseCrudManager abstractBaseCrudManager;

    @Autowired
    private final WorkOrderMapper workOrderMapper;

    @Override
    public List<WorkOrder> findAll() {
        return abstractBaseCrudManager.findAll();
    }

    @Override
    public WorkOrder save(WorkOrderDto entityDto) {
        return (WorkOrder) abstractBaseCrudManager.save(workOrderMapper.map(entityDto));
    }

    @Override
    public Optional<WorkOrder> findById(long id) {
        return abstractBaseCrudManager.findById(id);
    }

    @Override
    public void delete(WorkOrder entity) {
        abstractBaseCrudManager.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        abstractBaseCrudManager.deleteById(id);
    }

    @Override
    public WorkOrder update(WorkOrderDto entityDto, long id) {
        return (WorkOrder) abstractBaseCrudManager.updateById(workOrderMapper.map(entityDto), id);
    }
}