package tech.alvarez.planeardia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tech.alvarez.planeardia.adapters.UbicacionesAdapter;
import tech.alvarez.planeardia.db.Database;
import tech.alvarez.planeardia.model.Lugar;

public class ListadoActivity  extends  AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        cargarDatos();
    }

    private void cargarDatos() {
        // Carga los datos desde la base de datos y los coloca en la lista.
        ArrayList<Lugar> datos = Database.obtenerUbicaciones(this);
        /*String cad="";
        for(int i=0;i<datos.size();i++)
          cad=cad+datos.get(i).getNombre()+" "+datos.get(i).getDireccion()+" "+datos.get(i).getTelefono()+" "+datos.get(i).getWebsite()+" "+datos.get(i).getFecha()+" "+datos.get(i).getLatitud()+" "+datos.get(i).getLongitud()+" ";
        Toast.makeText(this,cad, Toast.LENGTH_SHORT).show();*/
        UbicacionesAdapter ubicacionesAdapter = new UbicacionesAdapter(this, datos);
        ListView lugareslistView = (ListView) findViewById(R.id.listView);
        lugareslistView.setAdapter(ubicacionesAdapter);
    }



}
