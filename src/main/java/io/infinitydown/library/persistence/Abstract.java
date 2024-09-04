package io.infinitydown.library.persistence;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Base class for entities providing common fields.
 * This class is used as a superclass for entities that need
 * an ID and version field for optimistic locking.
 */
@Data
@MappedSuperclass
public class Abstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer version;
}
