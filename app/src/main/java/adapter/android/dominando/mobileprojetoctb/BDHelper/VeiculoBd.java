package adapter.android.dominando.mobileprojetoctb.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.basicas.Veiculo;



public class VeiculoBd extends SQLiteOpenHelper {

    private static final String DATABASE = "banco";
    private static final int VERSION = 1;

    public VeiculoBd(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String veiculo = "CREATE TABLE veiculos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placaVeiculo TEXT NOT NULL," +
                "fabricanteVeiculo TEXT NOT NULL, modeloVeiculo TEXT NOT NULL, chassiVeiculo TEXT NOT NULL," +
                "anoFabricacaoVeiculo INTEGER, kilometragemVeiculo INTEGER, capTanqueVeiculo INTEGER);";
        db.execSQL(veiculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String veiculo = "DROP TABLE IF EXISTS veiculos";
        db.execSQL(veiculo);
    }

    public void salvarVeiculo(Veiculo veiculo){
        ContentValues values = new ContentValues();

        values.put("placaVeiculo", veiculo.getPlaca());
        values.put("fabricanteVeiculo", veiculo.getFabricante());
        values.put("modeloVeiculo", veiculo.getModelo());
        values.put("chassiVeiculo", veiculo.getChassi());
        values.put("anoFabricacaoVeiculo", veiculo.getAnoDeFabricacao());
        values.put("kilometragemVeiculo", veiculo.getKilometragem());
        values.put("capTanqueVeiculo", veiculo.getCapacidadeDoTanque());

        getWritableDatabase().insert("veiculos", null, values);
    }

    public void alterarVeiculo(Veiculo veiculo){
        ContentValues values = new ContentValues();

        values.put("placaVeiculo", veiculo.getPlaca());
        values.put("fabricanteVeiculo", veiculo.getFabricante());
        values.put("modeloVeiculo", veiculo.getModelo());
        values.put("chassiVeiculo", veiculo.getChassi());
        values.put("kilometragemVeiculo", veiculo.getKilometragem());

        String [] args = {veiculo.getId().toString()};
        getWritableDatabase().update("veiculos", values, "id=?", args);
    }

    public void deteltarVeiculo(Veiculo veiculo){
        String [] args = {veiculo.getId().toString()};
        getWritableDatabase().delete("veiculos", "id=?", args);
    }

    public ArrayList<Veiculo> getLista(){
        String [] columns = {"id", "placaVeiculo", "fabricanteVeiculo", "modeloVeiculo", "chassiVeiculo","anoFabricacaoVeiculo","kilometragemVeiculo","capTanqueVeiculo"};
        Cursor cursor = getWritableDatabase().query("veiculos", columns, null, null, null, null, null, null);
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        while (cursor.moveToNext()){

            Veiculo veiculo = new Veiculo();
            veiculo.setId(cursor.getLong(0));
            veiculo.setPlaca(cursor.getString(1));
            veiculo.setFabricante(cursor.getString(2));
            veiculo.setModelo(cursor.getString(3));
            veiculo.setChassi(cursor.getString(4));
            veiculo.setKilometragem(cursor.getInt(5));

            veiculos.add(veiculo);
        }
            return veiculos;
    }
}
