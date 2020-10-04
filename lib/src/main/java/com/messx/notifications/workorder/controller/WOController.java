package com.messx.notifications.workorder.controller;

import com.messx.notifications.workorder.dto.WorkOrderDto;
import com.messx.notifications.workorder.model.WorkOrder;
import com.messx.notifications.workorder.service.WOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/work_order")
public class WOController {

    @Autowired
    private WOService woService;

    public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody WorkOrderDto workOrderDto){
        WorkOrder workOrder = woService.save(workOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(workOrder);
    }
}
