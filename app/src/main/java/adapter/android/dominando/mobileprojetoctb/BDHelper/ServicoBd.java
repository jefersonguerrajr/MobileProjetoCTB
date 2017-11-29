package adapter.android.dominando.mobileprojetoctb.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import adapter.android.dominando.mobileprojetoctb.basicas.Servicos;

/**
 * Created by desenvolvimento on 28/11/2017.
 */

public class ServicoBd extends SQLiteOpenHelper {

    private static final String DATABASE = "banco";
    private static final int VERSION = 1;

    public ServicoBd(Context context) {
        super(context, DATABASE, null, VERSION);

    }
    public void salvarServico(Servicos servidoBD) {
        ContentValues values = new ContentValues();

        values.put("nomeEstabelecimento", servidoBD.getNomeEstabelecimento());
        values.put("tipoServico", servidoBD.getTipoServico());
        values.put("valorServico", servidoBD.getValorServico());
        values.put("enderecoEstabelecimentodoServico", servidoBD.getEnderecoEstabelecimentodoServico());
        values.put("telefoneEstabelecimentodoServico", servidoBD.getTelefoneEstabelecimentodoServico());
        values.put("avaliacaoEstavelecimentodoServico", servidoBD.getAvaliacaoEstavelecimentodoServico());
        getWritableDatabase().insert("Servicos", null, values);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String servico = "CREATE TABLE Servicos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " nomeEstabelecimento TEXT NOT NULL, tipoServico TEXT NOT NULL,valorServico REAL,enderecoEstabelecimentodoServico TEXT NOT NULL,telefoneEstabelecimentodoServico TEXT NOT NULL,avaliacaoEstavelecimentodoServico REAL);";
        db.execSQL(servico);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String servico = "DROP TABLE IF EXISTS Servicos";
        db.execSQL(servico);
        this.onCreate(db);


    }

    public List<Servicos> getListaServico() {
        String[] colunas ={"id","nomeEstabelecimento","tipoServico","valorServico","enderecoEstabelecimentodoServico","telefoneEstabelecimentodoServico","avaliacaoEstavelecimentodoServico"};
        Cursor cursor = getWritableDatabase().query("Servicos",colunas,null,null,null,null,null);

        ArrayList<Servicos>servicos = new ArrayList<Servicos>();
       while (cursor.moveToNext()){
           Servicos servico = new Servicos();

           servico.setId(cursor.getLong(0));
           servico.setNomeEstabelecimento(cursor.getString(1));
           servico.setEnderecoEstabelecimentodoServico(cursor.getString(2));
           servico.setTelefoneEstabelecimentodoServico(cursor.getString(3));
           servico.setTipoServico(cursor.getString(4));
           servico.setAvaliacaoEstavelecimentodoServico(cursor.getDouble(5));
           servico.setValorServico(cursor.getDouble(6));

           servicos.add(servico);
       }
        return servicos;
    }
}