package com.hbsis.boletim.sala;

public class SalaDTO {
    private long id;
    private String nomeSala;
    private String codigoSala;
    private long escola;

    public SalaDTO() {}

    public SalaDTO(long id, String nomeSala, String codigoSala, long escola) {
        this.id = id;
        this.nomeSala = nomeSala;
        this.codigoSala = codigoSala;
        this.escola = escola;
    }

    public static SalaDTO of(Sala sala) {
        return new SalaDTO(
                sala.getId(),
                sala.getNomeSala(),
                sala.getCodigoSala(),
                sala.getEscola().getId()
        );
    }

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

    public long getEscola() {
        return escola;
    }

    public void setEscola(long escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "SalaDTO{" +
                "id=" + id +
                ", nomeSala='" + nomeSala + '\'' +
                ", codigoSala='" + codigoSala + '\'' +
                ", escola=" + escola +
                '}';
    }
}
