package ru.mirea.ishutin.mobile_store.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.databinding.ActivityMainBinding;
import ru.mirea.ishutin.mobile_store.presentation.recViews.AllProductsRecyclerAdapter;
import ru.mirea.ishutin.mobile_store.presentation.viewModel.MainActivityViewModel;
import ru.mirea.ishutin.mobile_store.presentation.viewModel.MainActivityViewModelFactory;

public class ProductsFragment extends Fragment {

    private MainActivityViewModel viewModel;

    private RecyclerView allProductsRecycler;
    private AllProductsRecyclerAdapter allProductsRecyclerAdapter;
    private List<Product> allProducts;

    private void setupAllProducts(List<Product> productList) {
        allProducts.clear();
        allProducts.addAll(productList);
        allProductsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this, new MainActivityViewModelFactory(requireContext()))
                .get(MainActivityViewModel.class);

        allProductsRecycler = view.findViewById(R.id.products_recycler);
        allProductsRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false));

        allProducts = new ArrayList<>();
        allProductsRecyclerAdapter = new AllProductsRecyclerAdapter(allProducts);
        allProductsRecycler.setAdapter(allProductsRecyclerAdapter);

        viewModel.getProductsLiveData().observe(getViewLifecycleOwner(), products -> {
            setupAllProducts(products);
        });
        viewModel.getAllProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_products, container, false);
    }
}