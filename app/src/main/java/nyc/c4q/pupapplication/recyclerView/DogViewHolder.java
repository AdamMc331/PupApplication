package nyc.c4q.pupapplication.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.pupapplication.R;
import nyc.c4q.pupapplication.model.Dogs;

/**
 * Created by AmyRivera on 2/25/18.
 */

public class DogViewHolder extends ViewHolder {


    private TextView terrier;
    private TextView spaniel;
    private TextView retriever;
    private TextView poodle;

    public DogViewHolder(View itemView) {
        super(itemView);

        terrier=(TextView)itemView.findViewById(R.id.terrier);
        spaniel=(TextView)itemView.findViewById(R.id.spaniel);
        retriever=(TextView)itemView.findViewById(R.id.retriever);
        poodle=(TextView)itemView.findViewById(R.id.poodle);
    }

    public void onBind(Dogs user) {
    }
}
