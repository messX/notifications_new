package com.messx.notifications.lib.dto;

import lombok.Data;

import java.util.List;

@Data
public class APIResponse<Entity> {
    private boolean sucessful;
    private Entity entity;
    private List<Entity> entityList;
}
