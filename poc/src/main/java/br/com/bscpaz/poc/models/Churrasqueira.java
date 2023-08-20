package br.com.bscpaz.poc.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_churrasqueira", schema = "public")
public class Churrasqueira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_churrasqueira")
    private Long id;

    @Column(name = "ds_setor")
    private String setor;

}
