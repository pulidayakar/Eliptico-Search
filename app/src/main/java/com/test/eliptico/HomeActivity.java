package com.test.eliptico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.test.eliptico.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    public static final String CITY_NAME = "city_name";
    private String cityName;
    private CityViewModel viewModel;
    ActivityHomeBinding binding;
    private List<FeaturedList> list;
    private MyCityListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        if(getIntent() != null)
            cityName = getIntent().getStringExtra(CITY_NAME);
        initAdapter();
        viewModel = new ViewModelProvider(this, new CityViewModelFactory(cityName)).get(CityViewModel.class);
        binding.progressBar.setVisibility(View.VISIBLE);
        viewModel.getListMutableLiveData().observe(this, featuredLists -> {
            if (featuredLists != null && featuredLists.size()>0){
               list = featuredLists;
               if (adapter != null)
                   adapter.setList(list);
            }else
                showErrorMessage();
            binding.progressBar.setVisibility(View.GONE);
        });
    }

    private void initAdapter() {
        adapter = new MyCityListAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvList.setLayoutManager(linearLayoutManager);
        binding.rvList.setAdapter(adapter);
    }

    private void showErrorMessage(){
        Snackbar.make(binding.root, "Sorry... no data found. Please search with other location",3000).show();
    }
}