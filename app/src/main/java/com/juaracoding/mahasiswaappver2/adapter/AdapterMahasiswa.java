package com.juaracoding.mahasiswaappver2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracoding.mahasiswaappver2.R;
import com.juaracoding.mahasiswaappver2.model.MahasiswaModel;

import java.util.List;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.ViewHolder> {

    Context context;
    List<MahasiswaModel> mahasiswaData;

    public AdapterMahasiswa(Context context, List<MahasiswaModel> mahasiswaData) {
        this.context = context;
        this.mahasiswaData = mahasiswaData;
    }

    @NonNull
    @Override
    public AdapterMahasiswa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahasiswa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMahasiswa.ViewHolder holder, int position) {
        holder.txtNik.setText(mahasiswaData.get(position).getNik());
        holder.txtNama.setText(mahasiswaData.get(position).getNama());
        holder.txtAlamat.setText(mahasiswaData.get(position).getAlamat());
        holder.txtTanggal.setText(mahasiswaData.get(position).getTanggal());
    }

    @Override
    public int getItemCount() {
        return mahasiswaData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView txtNama, txtTanggal, txtAlamat, txtNik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNik = itemView.findViewById(R.id.txtNik);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtTanggal = itemView.findViewById(R.id.txtTanggal);
        }
    }

}
