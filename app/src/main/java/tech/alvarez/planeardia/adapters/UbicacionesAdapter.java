package tech.alvarez.planeardia.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tech.alvarez.planeardia.R;
import tech.alvarez.planeardia.model.Lugar;

public class UbicacionesAdapter extends ArrayAdapter<Lugar> {

    public UbicacionesAdapter(Context context, List<Lugar> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_lugar, parent, false);
        }
//datos.get(i).getNombre()+" "+
//datos.get(i).getDireccion()+" "+
// datos.get(i).getTelefono()+" "+
// datos.get(i).getWebsite()+" "+
// datos.get(i).getFecha()+" "+
// datos.get(i).getLatitud()+" "+
// datos.get(i).getLongitud()+" ";
        TextView nombreTextView = (TextView) convertView.findViewById(R.id.nombreTextView);
        TextView descripcionTextView = (TextView) convertView.findViewById(R.id.descripcionTextView);
        TextView telefonoTextView = (TextView) convertView.findViewById(R.id.telefonoTextView);
        TextView websiteTextView = (TextView) convertView.findViewById(R.id.websiteTextView);
        TextView fechaTextView=(TextView) convertView.findViewById(R.id.fechaTextView);
        TextView latitudTextView=(TextView) convertView.findViewById(R.id.latitudTextView);
        TextView longitudTextView=(TextView) convertView.findViewById(R.id.longitudTextView);

        Lugar u = getItem(position);

        nombreTextView.setText(u.getNombre());
        descripcionTextView.setText(u.getDireccion());
        telefonoTextView.setText(u.getTelefono());
        websiteTextView.setText(u.getWebsite());
        fechaTextView.setText(u.getFecha().toString());
        latitudTextView.setText((Double.toString(u.getLatitud())));
        longitudTextView.setText(Double.toString(u.getLongitud()));


        return convertView;
    }
}
