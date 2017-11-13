package adapter.android.dominando.mobileprojetoctb.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

/**
 * Created by cppde on 13/11/2017.
 */

public class Read extends SQLiteOpenHelper {

    public static final  String NOME_BANCO = "CTB_BANCO";
    public static final int VERSAO_DB = 1;
    public static final String TABELA_PESSOA = "TABELA_PESSOA";

    public static final String PATH_DB = "/data/user/0/adapter.android.dominando.mobileprojetoctb/databases/CTB_BANCO";
    private Context mContext;
    private SQLiteDatabase db;

    public Read(Context context) {
        super(context, NOME_BANCO, null, VERSAO_DB);
        this.mContext = context;
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Logica para atualizar o DB
    }


    public ArrayList<Pessoa> getPessoas(){
        openDB();
        ArrayList<Pessoa> pArray = new ArrayList<>();
        String getPessoas = "SELECT * FROM " + TABELA_PESSOA;

        try {
            Cursor c = db.rawQuery(getPessoas, null);

            if (c.moveToFirst()){
                do {
                Pessoa p = new Pessoa();
                p.setNome(c.getString(0));
                p.setEmail(c.getString(1));
                p.setSenha(c.getString(2));
                p.setCpf(c.getInt(3));
                pArray.add(p);

                }while (c.moveToNext());
                c.close();
            }

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }finally {
            db.close();
        }
        return pArray;
    }







    private void openDB(){
        if (!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }



}
