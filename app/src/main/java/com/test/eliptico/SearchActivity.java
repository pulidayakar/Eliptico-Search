package com.test.eliptico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.test.eliptico.databinding.ActivitySearchBinding;

import java.util.Objects;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.btnSearch.setOnClickListener(v -> {
            String input = Objects.requireNonNull(binding.tvInput.getText()).toString();
            if (TextUtils.isEmpty(input)) {
                Snackbar.make(binding.root, "Please enter city name", 3000).show();
                return;
            }
            if (RetrofitUtils.checkConnection(this))
                startActivity(new Intent(SearchActivity.this, HomeActivity.class).putExtra(HomeActivity.CITY_NAME, input));
            else Snackbar.make(binding.root, "Please check your network connection", 3000).show();
        });
    }
}