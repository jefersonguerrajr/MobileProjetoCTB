package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import adapter.android.dominando.mobileprojetoctb.BDHelper.PessoasBd;
import adapter.android.dominando.mobileprojetoctb.BDHelper.ServicoBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;
import adapter.android.dominando.mobileprojetoctb.basicas.Servicos;

/**
 * Created by desenvolvimento on 28/11/2017.
 */

public class FormularioServicos extends Activity {

    Servicos editarServico, servico;
    private FormularioHelpesServicos bdHelperServico;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formcadastroservico);
        Intent intent = getIntent();

        final Servicos servicosAlterar = (Servicos) intent.getSerializableExtra("servicoSelecionado");

        Toast.makeText(this,"Servicos:"+servicosAlterar,Toast.LENGTH_SHORT).show();
        bdHelperServico = new FormularioHelpesServicos(this);
        Button botao =(Button) findViewById(R.id.salvarServicos);

        if (servicosAlterar !=null){
            botao.setText("Alterar Serviço");
            bdHelperServico.colocarServico(servicosAlterar);
        }


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Servicos servicos = bdHelperServico.pegarServicodoFormulario();

                ServicoBd servicoBd = new ServicoBd(FormularioServicos.this);
                if (servicosAlterar==null){
                    servicoBd.salvarServico(servicos);
                }else {
                    servicos.setId(servicosAlterar.getId());
                    servicoBd.altera(servicos);
                }


                servicoBd.close();
                finish();



            }
        });


            //

  //
    //










    }
}
