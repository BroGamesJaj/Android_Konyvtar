package hu.petrik.konyvtar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class KonyvAdapter extends BaseAdapter {
    private List<Konyv> konyvek;
    private Context context;

    public KonyvAdapter(List<Konyv> konyvek, Context context) {
        this.konyvek = konyvek;
        this.context = context;
    }

    @Override
    public int getCount() {
        return konyvek.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_of_books_items, viewGroup, false);
        TextView cimTextView = view.findViewById(R.id.cimTextView);

        Button torlesButton = view.findViewById(R.id.torlesButton);
        cimTextView.setText(konyvek.get(i).getCim());

        torlesButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tényleg szeretné törölni?");

            builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    konyvek.remove(i); // Remove the item
                    notifyDataSetChanged(); // Notify the adapter to refresh
                }
            });
            builder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        });
        return view;
    }
}
