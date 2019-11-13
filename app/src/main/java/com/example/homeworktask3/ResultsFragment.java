package com.example.homeworktask3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ResultsFragment extends Fragment {

    private RecyclerView recyclerView;
    //For when I can get the search link working
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public ResultsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final CatAdapter catAdapter = new CatAdapter();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        //Can connect to the generic list of all breeds
        String url = "https://api.thecatapi.com/v1/breeds";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Cat[] catArray = gson.fromJson(response, Cat[].class);
                List<Cat> resultCats = Arrays.asList(catArray);
                AppDatabase db = AppDatabase.getInstance(getContext());
                db.catDao().insertAll(resultCats);
                List<Cat> listCatsFromDatabase = db.catDao().getAll();
                ArrayList<Cat> catsFromDatabase = new ArrayList<Cat>(listCatsFromDatabase);
                catAdapter.setData(catsFromDatabase);
                recyclerView.setAdapter(catAdapter);
                System.out.print("your connection works");
                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Sorry, your search request failed", Toast.LENGTH_SHORT).show();
                System.out.print("your connection does NOT WORK");
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
        return view;
    }
}
