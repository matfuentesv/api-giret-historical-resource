package com.giret.apigiretresources.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HISTORIAL_RECURSO", schema = "ADMIN")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HistoricalResource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historial_seq")
    @SequenceGenerator(name = "historial_seq", sequenceName = "ADMIN.historial_SEQ", allocationSize = 1)
    @Column(name = "IDHISTORIAL", nullable = false)
    @JsonProperty("idHistorial")
    private Long idHistorial;

    @Column(name = "RECURSO_IDRECURSO", nullable = false)
    @JsonProperty("recursoId")
    private Long recursoId;

    @Column(name = "FECHACAMBIOESTADO", nullable = false, length = 50)
    @JsonProperty("fechaCambioEstado")
    private String fechaCambioEstado;

    @Column(name = "ACCION", nullable = false, length = 50)
    @JsonProperty("accion")
    private String accion;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    @JsonProperty("descripcion")
    private String descripcion;
}
