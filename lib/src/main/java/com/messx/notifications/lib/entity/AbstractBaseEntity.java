package com.messx.notifications.lib.entity;

import com.messx.notifications.lib.enums.Status;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractBaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name="status", columnDefinition = "varchar(20) DEFAULT 'active'")
    private Status status;

    @Column(name="created_timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdTimestamp;

    @Column(name="updated_timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant updatedTimestamp;
}
