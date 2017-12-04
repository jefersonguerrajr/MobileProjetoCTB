package adapter.android.dominando.mobileprojetoctb.basicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by desenvolvimento on 03/12/2017.
 */
@SuppressWarnings("serial")
public class Relatorio implements Serializable {
    private String servicoRelacorio;
    private String dataServico;
    private String descricaoServico;
    private List<String> topicos = new ArrayList<String>();

    public Relatorio(){

    }
    public Relatorio(String dataServico,String servicoRelacorio){
        this.dataServico = dataServico;
        this.servicoRelacorio = servicoRelacorio;
    }

    @Override
    public String toString() {
        return servicoRelacorio + " - " + dataServico;
    }

    public String getServicoRelacorio() {
        return servicoRelacorio;
    }

    public void setServicoRelacorio(String servicoRelacorio) {
        this.servicoRelacorio = servicoRelacorio;
    }

    public String getDataServico() {
        return dataServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public List<String> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<String> topicos) {
        this.topicos = topicos;
    }
}