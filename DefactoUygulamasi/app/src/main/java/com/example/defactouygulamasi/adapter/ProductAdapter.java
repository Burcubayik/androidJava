package com.example.defactouygulamasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.defactouygulamasi.databinding.CardTasarimBinding;
import com.example.defactouygulamasi.entity.Product;

import java.util.ConcurrentModificationException;
import java.util.List;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Product> productList;

    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu( CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Product product = productList.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.imageViewUrunResim.setImageResource
                (mContext.getResources().getIdentifier(product.getPictureName(),"drawable",mContext.getPackageName()));
        t.textViewFiyat.setText(String.valueOf(product.getPrice() + "₺" ));

        if(product.getName().length()>19){

            t.textViewUrunBaslik.setText(product.getName().substring(0,19)+"...");
        }
        else
        {
            t.textViewUrunBaslik.setText(product.getName());
        }

        if(product.getColorAmount()==0){
            t.textViewRenkSayisi.setText("");
            t.imageView2.setVisibility(View.INVISIBLE);
        }
        else {
            t.textViewRenkSayisi.setText("+" + product.getColorAmount());
        }


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



}
