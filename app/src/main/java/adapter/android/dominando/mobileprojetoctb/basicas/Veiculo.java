package adapter.android.dominando.mobileprojetoctb.basicas;

import java.io.Serializable;

/**
 * Created by cppde on 30/10/2017.
 */

public class Veiculo implements Serializable {

    private Long id;
    private String placa;
    private String fabricante;
    private String modelo;
    private String chassi;
    private int anoDeFabricacao;
    private int kilometragem;
    private int capacidadeDoTanque;

    private String nomeSeguradora;
    private String apoliceDoSeguro;
    private String contatoSeguradora;

    @Override
    public String toString() {
        return modelo.toString();
    }

    //Construtor
    public Veiculo() {
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.chassi = chassi;
        this.anoDeFabricacao = anoDeFabricacao;
        this.kilometragem = kilometragem;
        this.capacidadeDoTanque = capacidadeDoTanque;
        this.nomeSeguradora = nomeSeguradora;
        this.apoliceDoSeguro = apoliceDoSeguro;
        this.contatoSeguradora = contatoSeguradora;
    }
    // Métodos getters e Setters
    public String getPlaca() {
        return placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public int getCapacidadeDoTanque() {
        return capacidadeDoTanque;
    }

    public void setCapacidadeDoTanque(int capacidadeDoTanque) {
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getApoliceDoSeguro() {
        return apoliceDoSeguro;
    }

    public void setApoliceDoSeguro(String apoliceDoSeguro) {
        this.apoliceDoSeguro = apoliceDoSeguro;
    }

    public String getContatoSeguradora() {
        return contatoSeguradora;
    }

    public void setContatoSeguradora(String contatoSeguradora) {
        this.contatoSeguradora = contatoSeguradora;
    }
}
