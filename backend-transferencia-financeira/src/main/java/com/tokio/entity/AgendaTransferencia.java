package com.tokio.entity;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "agendamento")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaTransferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contaOrigem;

    private String contaDestino;

    private BigDecimal valorTransferencia;

    private BigDecimal taxa;

    private Date dataAgendamento;

    private Date dataTransferencia;
}
