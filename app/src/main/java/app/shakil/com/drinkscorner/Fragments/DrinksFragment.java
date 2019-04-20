package app.shakil.com.drinkscorner.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import app.shakil.com.drinkscorner.Adapters.RecyclerViewAdapterDrinks;
import app.shakil.com.drinkscorner.Model.Item;
import app.shakil.com.drinkscorner.R;

public class DrinksFragment extends Fragment {

    private RecyclerView recyclerViewDrinks;
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerViewAdapterDrinks recyclerViewAdapterDrinks;
    private List<Item> drinksItemList;

    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drinks, container, false);
        init(view);
        insertData();
        recyclerViewAdapterDrinks=new RecyclerViewAdapterDrinks(drinksItemList);
        recyclerViewDrinks.setLayoutManager(linearLayoutManager);
        recyclerViewDrinks.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDrinks.setAdapter(recyclerViewAdapterDrinks);
        return view;
    }

    private void insertData() {
        drinksItemList.add(new Item(R.drawable.drinks,"Mango lassi","Some of India's lucky workers have migrated into " +
                "the air-conditioned confines of its call centers and IT offices.",10.9,4.1));
        drinksItemList.add(new Item(R.drawable.drinks,"Red Bull","OK, Red Bull is an acquired taste even on a good day. " +
                "But nothing else in the history of drinks and beverages has made deadlines more hittable than this energy drink.",10.9,4.1));
        drinksItemList.add(new Item(R.drawable.drinks,"Yakult, Japan","Drinking a carton of bacteria is hardly one of the " +
                "world's most marketable activities, however friendly they might claim to be.",10.9,4.1));
        drinksItemList.add(new Item(R.drawable.drinks,"Guinness, Ireland","When you're talking Guinness, perfection is 119.5 seconds." +
                " That's how long it takes for a perfect pint of this ruby red (not black) nectar to be poured according to brand owner Diageo.",10.9,4.1));
        drinksItemList.add(new Item(R.drawable.drinks,"Pina colada, Puerto Rico","Just looking at the drink brings you closer to a beach and sipping " +
                "this mixture of coconut milk, pineapple juice and rum will send you directly to a hammock between palm trees in the Caribbean.",10.9,4.1));
        drinksItemList.add(new Item(R.drawable.drinks,"Cendol, Indonesia","Strictly speaking this is more of a watery dessert than a drink, and is served" +
                " in a bowl, but at least that way you get to take bigger gulps.",10.9,4.1));
    }

    public void init(View view){
        recyclerViewDrinks=view.findViewById(R.id.recyclerViewItemXML);
        linearLayoutManager=new LinearLayoutManager(getContext());
        drinksItemList=new ArrayList<>();
    }

}
