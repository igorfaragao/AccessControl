package com.dio.AccessControl.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Movimentacao {

    
    //Criando Chave composta para o banco de dados
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }
    @Id
    @EmbeddedId
    private MovimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;
    @ManyToOne
    private Ocorrencia ocorrencia;
    @OneToOne
    private Calendario calendario;


    
    
    
}
