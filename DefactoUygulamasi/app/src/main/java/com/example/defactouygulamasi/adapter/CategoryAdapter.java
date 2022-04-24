package com.example.defactouygulamasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defactouygulamasi.databinding.CategoryTasarimBinding;
import com.example.defactouygulamasi.entity.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryTasarimTutucu>{
    private Context mContext;
    private List<Category> categoryList;

    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }
    public class CategoryTasarimTutucu extends RecyclerView.ViewHolder {
        private CategoryTasarimBinding tasarim;

        public CategoryTasarimTutucu(CategoryTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }

    }

    @NonNull
    @Override
    public CategoryTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CategoryTasarimBinding tasarim = CategoryTasarimBinding.inflate(layoutInflater, parent, false);
        return new CategoryTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryTasarimTutucu holder, int position) {
        Category category =  categoryList.get(position);
        CategoryTasarimBinding t = holder.tasarim;
        t.textViewCategoryName.setText(category.getName());


    }

    @Override
    public int getItemCount() { return categoryList.size();    }



}
