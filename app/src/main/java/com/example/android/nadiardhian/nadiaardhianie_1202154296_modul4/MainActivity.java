package com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout yang akan digunakan bernama activity_main
        setTitle("AsyncTask"); //dengan judul aplikasi asynctask
    }
    //method saat button ditekan
    public void mahasiswa(View view) { //pada file xml berikan android on click dengan nama yang sama dengan disini
        Intent i = new Intent(this, ListNamaMahasiswa.class); //untuk berpindah ke class list nama mahasiswa
        startActivity(i); //memulai activity
    }
    //method saat button ditekan
    public void gambar(View view) { //pada file xml berikan android on click dengan nama yang sama dengan disini
        Intent intent = new Intent(this, PencariGambar.class); //untuk berpindah ke class pencari gambar
        startActivity(intent); //memulai activity
    }
}
