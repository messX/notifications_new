package core.lib.dto;

import core.lib.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    private long id;
    private Status status;
    private Instant createdTimestamp;
    private Instant updatedTimestamp;
}
