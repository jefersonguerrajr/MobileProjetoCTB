package adapter.android.dominando.mobileprojetoctb.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

/**
 * Created by cppde on 26/11/2017.
 */

public class PessoasBd extends SQLiteOpenHelper {

    private static final String DATABASE = "cbtBD";
    private static final int VERSION = 1;

    public PessoasBd (Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String pessoa = "CREATE TABLE pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " emailPessoa TEXT NOT NULL, senhaPessoa TEXT NOT NULL);";
        db.execSQL(pessoa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String pessoa = "DROP TABLE IF EXISTS pessoas";
        db.execSQL(pessoa);
    }
    // Metodo Salvar conluido
    public void salvarPessoa(Pessoa pessoa){
        ContentValues values = new ContentValues();

        values.put("emailPessoa", pessoa.getEmail());
        values.put("senhaPessoa", pessoa.getSenha());

        getWritableDatabase().insert("pessoas", null, values);
    }
    //Metodo alterar Concluido
    public void alterarPessoa(Pessoa pessoa){
        ContentValues values = new ContentValues();

        values.put("emailPessoa", pessoa.getEmail());
        values.put("senhaPessoa", pessoa.getSenha());

        String [] args = {pessoa.getId().toString()};
        getWritableDatabase().update("pessoas", values, "id=?",args);
    }
    //Metodo deletar concluido
    public void deletarPessoa(Pessoa pessoa){
        String [] args = {pessoa.getId().toString()};
        getWritableDatabase().delete("pessoas",  "id=?",args);
    }

    public ArrayList<Pessoa> getLista(){
        String[] columns = {"id", "emailPessoa", "senhaPessoa"};
        Cursor cursor = getWritableDatabase().query("pessoas", columns, null, null, null, null, null, null);
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (cursor.moveToNext()){
            Pessoa pessoa = new Pessoa();
            pessoa.setId(cursor.getLong(0));
            pessoa.setEmail(cursor.getString(1));
            pessoa.setSenha(cursor.getString(2));

            pessoas.add(pessoa);
        }
        return pessoas;
    }
}

/*Passo para verificar o arquivo do banco de dados na maquina

Faça os seguintes passos:

No Android Studio, vá em Tools > Android > Device Monitor
No Device Monitor, no canto esquerdo, selecione o dispositivo que está em execução
Selecione a aba File Explorer do Device Monitor. Nesse momento irão aparecer as pastas
que estão no dispositivo em execução
Selecione data > data > pacote.da.sua.aplicação > databases
Se você quiser baixar e visualizar o arquivo de banco de dados,
basta selecionar o arquivo e clicar na opção Pull a file from device,
que é um icone de um disquete com uma seta rosa que fica no canto superior
direito, entre as abas e o explorador de arquivo


 */