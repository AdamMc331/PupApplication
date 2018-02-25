package nyc.c4q.pupapplication.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.pupapplication.R;
import nyc.c4q.pupapplication.model.Dogs;

/**
 * Created by AmyRivera on 2/25/18.
 */

public class DogAdapter extends RecyclerView.Adapter<DogViewHolder> {

    public DogAdapter(List<Dogs> breedList) {
        this.breedList = breedList;
    }

    private List<Dogs> breedList;


    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_item_view, parent, false);
        return new DogViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(DogViewHolder holder, int position) {
        Dogs user = breedList.get(position);
        holder.onBind(user);

    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }
}
