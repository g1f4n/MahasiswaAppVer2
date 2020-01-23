package com.juaracoding.mahasiswaappver2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.juaracoding.mahasiswaappver2.activity.AddMahasiswa;
import com.juaracoding.mahasiswaappver2.adapter.AdapterMahasiswa;
import com.juaracoding.mahasiswaappver2.model.MahasiswaModel;
import com.juaracoding.mahasiswaappver2.service.APIClient;
import com.juaracoding.mahasiswaappver2.service.APIInterfacesRest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listMahasiswa;
    ImageButton btnAdd;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMahasiswa = findViewById(R.id.listMahasiswa);
        btnAdd = findViewById(R.id.btnAdd);

        callMahasiswaAll();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddMahasiswa.class);

            }
        });

    }

    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;
    public void callMahasiswaAll(){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<List<MahasiswaModel>> call3 = apiInterface.getMahasiswaAll();
        call3.enqueue(new Callback<List<MahasiswaModel>>() {
            @Override
            public void onResponse(Call<List<MahasiswaModel>> call, Response<List<MahasiswaModel>> response) {
                progressDialog.dismiss();
                List<MahasiswaModel> data = response.body();
                //Toast.makeText(LoginActivity.this,userList.getToken().toString(),Toast.LENGTH_LONG).show();
                if (data !=null) {

                    AdapterMahasiswa adapter = new AdapterMahasiswa(MainActivity.this, data);

                    listMahasiswa.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    listMahasiswa.setItemAnimator(new DefaultItemAnimator());
                    listMahasiswa.setAdapter(adapter);


                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<MahasiswaModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });

    }

}
