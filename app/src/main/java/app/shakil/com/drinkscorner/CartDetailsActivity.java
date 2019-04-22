package app.shakil.com.drinkscorner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import app.shakil.com.drinkscorner.Adapters.CartRecyclerViewAdapter;

public class CartDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCartDetails;
    private RecyclerView.LayoutManager layoutManager;
    private CartRecyclerViewAdapter cartRecyclerViewAdapter;
    private ArrayList<String> titleList;
    private SaveCartDetails saveCartDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);
        init();
        titleList=saveCartDetails.getItemTitle();
        for (int start=0;start<titleList.size();start++){
            Log.v("Title : ",""+titleList.get(start));
        }
        cartRecyclerViewAdapter =new CartRecyclerViewAdapter(titleList,getApplicationContext());
        recyclerViewCartDetails.setLayoutManager(layoutManager);
        recyclerViewCartDetails.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCartDetails.setAdapter(cartRecyclerViewAdapter);
    }
    public void init(){
        recyclerViewCartDetails =findViewById(R.id.cartDetailsRecyclerView);
        saveCartDetails=new SaveCartDetails(getApplicationContext());
        layoutManager=new LinearLayoutManager(getApplicationContext());
        titleList=new ArrayList<>();
    }
}
