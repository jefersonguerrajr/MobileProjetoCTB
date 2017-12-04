package adapter.android.dominando.mobileprojetoctb.basicas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.BDHelper.DbHelper;

/**
 * Created by cppde on 02/12/2017.
 */

public class Pessoa implements Serializable {

    private int id;
    private String nomePessoa;
    private String emailPessoa;
    private String senhaPessoa;
    private boolean excluir;
    private Context context;

    public Pessoa(Context context){
        this.context = context;
        id = -1;
    }

    public int getId() {
        return id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public boolean excluir(){
        DbHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        try{
            dbHelper = new DbHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.delete("Pessoas", "ID = ?", new String[]{String.valueOf(id)});

            excluir = true;


            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;
        }finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }
    }

    public boolean salvar(){
        DbHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        try{
            dbHelper = new DbHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql = "";
            if (id == -1){
                sql = "INSERT INTO Pessoas(Nome, Email,Senha) VALUES (?,?,?)";
            }else{
                sql = "UPDATE Pessoas SET Nome = ?, Email = ?, Senha = ? WHERE ID = ?";
            }
            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1, nomePessoa);
            sqLiteStatement.bindString(2, emailPessoa);
            sqLiteStatement.bindString(3, senhaPessoa);
            if (id != -1)
                sqLiteStatement.bindString(4,String.valueOf(id));
            sqLiteStatement.executeInsert();
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;
        }finally {
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }
    }

   public ArrayList<Pessoa> getPessoas(){
       DbHelper dbHelper = null;
       SQLiteDatabase sqLiteDatabase = null;
       Cursor cursor = null;
       ArrayList<Pessoa> pessoas = new ArrayList<>();
        try{
            dbHelper = new DbHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();
            cursor = sqLiteDatabase.query("Pessoas",null,null,null,null,null,null);
            while(cursor.moveToNext()){
                Pessoa pessoa = new Pessoa(context);
                pessoa.id = cursor.getInt(cursor.getColumnIndex("ID"));
                pessoa.nomePessoa = cursor.getString(cursor.getColumnIndex("Nome"));
                pessoa.emailPessoa = cursor.getString(cursor.getColumnIndex("Email"));
                pessoa.senhaPessoa = cursor.getString(cursor.getColumnIndex("Senha"));

                pessoas.add(pessoa);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((cursor != null) && (! cursor.isClosed()))
                cursor.close();
            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();
        }
       return pessoas;
   }

   public void carregaPessoaPeloID(int id){
       DbHelper dbHelper = null;
       SQLiteDatabase sqLiteDatabase = null;
       Cursor cursor = null;
       try{
           dbHelper = new DbHelper(context);
           sqLiteDatabase = dbHelper.getReadableDatabase();
           cursor = sqLiteDatabase.query("Pessoas",null, "ID = ?", new String[]{String.valueOf(id)}, null,null,null);
           excluir = true;
           while(cursor.moveToNext()){
               this.id = cursor.getInt(cursor.getColumnIndex("ID"));
               nomePessoa = cursor.getString(cursor.getColumnIndex("Nome"));
               emailPessoa = cursor.getString(cursor.getColumnIndex("Email"));
               senhaPessoa = cursor.getString(cursor.getColumnIndex("Senha"));
                excluir = false;
           }

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           if ((cursor != null) && (! cursor.isClosed()))
               cursor.close();
           if (sqLiteDatabase != null)
               sqLiteDatabase.close();
           if (dbHelper != null)
               dbHelper.close();
       }

   }
    /**
   public String validadorLogin(String email, String senha){
       DbHelper dbHelper = null;
       SQLiteDatabase db;
       db = dbHelper.getReadableDatabase();

       Cursor c = db.rawQuery("SELECT * FROM Pessoas WHERE Email=? AND Senha=?", new String[email, senha]);
       if(c.getCount()>0){
           return "OK";
       }
       return "ERRO";
   } **/
}
