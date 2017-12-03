package adapter.android.dominando.mobileprojetoctb.BDHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cppde on 02/12/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static  String DATABASE_NAME = "ctb.db";
    private static int DATABASE_VERSION = 1;
    private static  final String TABELA_PESSOA = "CREATE TABLE Pessoas(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                                                "Nome TEXT NOT NULL, Email TEXT NOT NULL, Senha TEXT NOT NULL);";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABELA_PESSOA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
