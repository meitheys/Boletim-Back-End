package com.hbsis.boletim.sala;

import com.hbsis.boletim.escola.Escola;

import javax.persistence.*;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nome_sala")
    private String nomeSala;
    @Column(name = "codigo_sala")
    private String codigoSala;
    //Varias salas para uma escola
    @ManyToOne
    @JoinColumn(name = "escola", referencedColumnName = "id")
    private Escola escola;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nomeSala='" + nomeSala + '\'' +
                ", codigoSala='" + codigoSala + '\'' +
                ", escola=" + escola +
                '}';
    }
}
