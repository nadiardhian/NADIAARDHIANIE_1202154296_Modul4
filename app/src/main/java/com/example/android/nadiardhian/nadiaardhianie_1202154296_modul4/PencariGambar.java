package com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4.R;
import com.squareup.picasso.Picasso;

public class PencariGambar extends AppCompatActivity {
    ImageView gambar; //deklarasikan imageview dengan nama gambar
    EditText sumber; //deklarasikan sumber untuk menampung link yg akan di link ke internet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar); //layout yang digunakan adalah activity_pencari_gambar
        setTitle("AsyncTask"); //set title pada tampilan

        gambar = (ImageView)findViewById(R.id.ImageView); //get id gambar
        sumber = (EditText)findViewById(R.id.urlText); //get id sumber
    }
    public void cari(View view) { //method saat button ditekan
        Picasso.with(PencariGambar.this).load(sumber.getText().toString()) //loading gambar dari internet ke imageview dengan menggunakan picasso
                .placeholder(R.mipmap.ic_launcher_round) //placeholder atau wadah untuk gambar
                .error(R.mipmap.ic_launcher) //jika error ini placeholdernya
                .into(gambar); //gambar akan ditampilkan
    }
}
