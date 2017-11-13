package adapter.android.dominando.mobileprojetoctb.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

/**
 * Created by cppde on 13/11/2017.
 */

public class Update extends SQLiteOpenHelper {

    public static final  String NOME_BANCO = "CTB_BANCO";
    public static final int VERSAO_DB = 1;
    public static final String TABELA_PESSOA = "TABELA_PESSOA";

    public static final String PATH_DB = "/data/user/0/adapter.android.dominando.mobileprojetoctb/databases/CTB_BANCO";
    private Context mContext;
    private SQLiteDatabase db;

    public Update(Context context) {
        super(context, NOME_BANCO, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Logica para atualizar o DB
    }

    public boolean insertPessoa(Pessoa p){
        openDB();
        try{
            ContentValues cv = new ContentValues();
            cv.put("NOME", p.getNome());
            cv.put("EMAIL", p.getEmail());
            cv.put("SENHA", p.getSenha());
            cv.put("CPF", p.getCpf());
            db.insert(TABELA_PESSOA, null, cv);
            return true;


        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }

    }

    public boolean updatePessoa(Pessoa p){
        openDB();
        try{
            String where = "NOME = '" + p.getNome() + "'";
            ContentValues cv = new ContentValues();
            cv.put("NOME", p.getNome());
            cv.put("EMAIL", p.getEmail());
            cv.put("SENHA", p.getSenha());
            cv.put("CPF", p.getCpf());
            db.update(TABELA_PESSOA, cv, where, null);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }

    }





    private void openDB(){
        if (!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }



}
