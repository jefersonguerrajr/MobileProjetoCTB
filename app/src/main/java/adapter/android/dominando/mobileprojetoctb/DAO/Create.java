package adapter.android.dominando.mobileprojetoctb.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cppde on 13/11/2017.
 */

public class Create extends SQLiteOpenHelper {

    public static final  String NOME_BANCO = "CTB_BANCO";
    public static final int VERSAO_DB = 1;
    public static final String TABELA_PESSOA = "TABELA_PESSOA";

    public static final String PATH_DB = "/data/user/0/adapter.android.dominando.mobileprojetoctb/databases/CTB_BANCO";
    private Context mContext;
    private SQLiteDatabase db;

    public Create(Context context) {
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

    public boolean createTable(){
        openDB();
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABELA_PESSOA + "("
                + "NOME TEXT,"
                + "EMAIL TEXT"
                + "SENHA TEXT"
                + "CPF INTEGER";
        try{
            db.execSQL(createTable);
            return true;

        }catch (Exception e){
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
