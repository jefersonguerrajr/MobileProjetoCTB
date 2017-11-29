package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

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
        bdHelperServico = new FormularioHelpesServicos(this);



        Button botao =(Button) findViewById(R.id.salvarServicos);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Servicos servicos = bdHelperServico.pegarServicodoFormulario();
                ServicoBd servicoBd = new ServicoBd(FormularioServicos.this);
                servicoBd.salvarServico(servicos);
                servicoBd.close();
                finish();



            }
        });


            //

  //
    //










    }
}
