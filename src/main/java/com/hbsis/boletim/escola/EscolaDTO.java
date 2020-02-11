package com.hbsis.boletim.escola;

public class EscolaDTO {
    private long id;
    private String nomeEscola;
    private String endereco;
    private String telefone;
    private String codigoEscola;

    public EscolaDTO() {}

    public EscolaDTO(long id, String nomeEscola, String endereco, String telefone, String codigoEscola) {
        this.id = id;
        this.nomeEscola = nomeEscola;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigoEscola = codigoEscola;
    }

    public static EscolaDTO of(Escola escola) {
        return new EscolaDTO(
                escola.getId(),
                escola.getNomeEscola(),
                escola.getEndereco(),
                escola.getTelefone(),
                escola.getCodigoEscola()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodigoEscola() {
        return codigoEscola;
    }

    public void setCodigoEscola(String codigoEscola) {
        this.codigoEscola = codigoEscola;
    }

    @Override
    public String toString() {
        return "EscolaDTO{" +
                "id=" + id +
                ", nomeEscola='" + nomeEscola + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", codigoEscola='" + codigoEscola + '\'' +
                '}';
    }
}
