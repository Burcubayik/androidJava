package com.example.todoapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.R;
import com.example.todoapp.databinding.CardTasarimBinding;
import com.example.todoapp.entity.YapilacakIsler;
import com.example.todoapp.fragment.AnasayfaFragmentDirections;
import com.example.todoapp.viewmodel.AnasayfaFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YapilacakIslerAdapter extends RecyclerView.Adapter<YapilacakIslerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<YapilacakIsler> yapilacaklarListesi;
    private AnasayfaFragmentViewModel viewModel;

    public YapilacakIslerAdapter(Context mContext, List<YapilacakIsler> yapilacaklarListesi, AnasayfaFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.yapilacaklarListesi = yapilacaklarListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        YapilacakIsler yapilacakIs = yapilacaklarListesi.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.setYapilacakIsNesnesi(yapilacakIs);

        t.satirCard.setOnClickListener(view ->{
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(yapilacakIs);
            Navigation.findNavController(view).navigate(gecis);

        });
        t.imageViewSilResim.setOnClickListener(view ->{
            Snackbar.make(view,yapilacakIs.getYapilacak_is()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",v1 ->{
                       viewModel.sil(yapilacakIs.getId());
                    }).show();

        });
    }

    @Override
    public int getItemCount() {
        return yapilacaklarListesi.size();
    }

}
