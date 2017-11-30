package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import adapter.android.dominando.mobileprojetoctb.BDHelper.VeiculoBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Veiculo;

public class FormularioVeiculoActivity extends AppCompatActivity {
    private  EditText edtModelo, edtPlaca, edtFabricante, edtChassi, edtKilometratem;
    private Button btnPolimorf;
    Veiculo editarVeiculo, veiculo;
    VeiculoBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

        veiculo = new Veiculo();
        bdHelper = new VeiculoBd(FormularioVeiculoActivity.this);

        Intent intent = getIntent();
        editarVeiculo = (Veiculo) intent.getSerializableExtra("veiculo-escolhido");

        edtModelo = (EditText) findViewById(R.id.edModeloID);
        edtPlaca = (EditText) findViewById(R.id.edtPlacaID);
        edtFabricante = (EditText) findViewById(R.id.edFabricanteID);
        edtChassi = (EditText) findViewById(R.id.edtChassiID);
        edtKilometratem = (EditText) findViewById(R.id.edKilometragem);

        btnPolimorf = (Button) findViewById(R.id.btnPolimorfVeiculo);

        if (editarVeiculo != null){
            btnPolimorf.setText("Modificar");

            edtModelo.setText(editarVeiculo.getModelo());
            edtPlaca.setText(editarVeiculo.getPlaca());
            edtFabricante.setText(editarVeiculo.getFabricante());
            edtChassi.setText(editarVeiculo.getChassi());
            edtKilometratem.setText(editarVeiculo.getKilometragem()+"");

            veiculo.setId(editarVeiculo.getId());

        }else {
            btnPolimorf.setText("Cadastrar");
        }

        btnPolimorf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veiculo.setModelo(edtModelo.getText().toString());
                veiculo.setPlaca(edtPlaca.getText().toString());
                veiculo.setFabricante(edtFabricante.getText().toString());
                veiculo.setChassi(edtChassi.getText().toString());
                veiculo.setKilometragem(Integer.parseInt(edtKilometratem.getText().toString()));

                if (btnPolimorf.getText().toString().equals("Cadastrar")){
                    bdHelper.salvarVeiculo(veiculo);
                    bdHelper.close();
                }else{
                    bdHelper.alterarVeiculo(veiculo);
                    bdHelper.close();
                }
            }
        });

    }
}
