package app.shakil.com.drinkscorner.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.shakil.com.drinkscorner.Model.CheeseItem;
import app.shakil.com.drinkscorner.Model.CoffeeItem;
import app.shakil.com.drinkscorner.R;

public class RecyclerViewAdapterCoffee extends RecyclerView.Adapter<RecyclerViewAdapterCoffee.MyViewHolder>{
    private List<CoffeeItem> coffeeItems;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, price,rating;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.chesseIconXML);
            title = view.findViewById(R.id.cheeseItemNameXML);
            description = view.findViewById(R.id.cheeseItemDescriptionXML);
            price =  view.findViewById(R.id.itemPriceXML);
            rating = view.findViewById(R.id.itemRatingXML);
        }
    }


    public RecyclerViewAdapterCoffee(List<CoffeeItem> coffeeItems) {
        this.coffeeItems = coffeeItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blueprint_recyclerview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CoffeeItem coffeeItem = coffeeItems.get(position);
        holder.imageView.setImageResource(coffeeItem.getImage());
        holder.title.setText(coffeeItem.getTitle());
        holder.description.setText(coffeeItem.getDescription());
        holder.price.setText(""+coffeeItem.getPrice()+"$");
        holder.rating.setText(" / "+coffeeItem.getRating());
    }

    @Override
    public int getItemCount() {
        return coffeeItems.size();
    }
}
