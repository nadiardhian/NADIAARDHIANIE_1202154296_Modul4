package com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.nadiardhian.nadiaardhianie_1202154296_modul4.R;

import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {
    ListView listMhs; //mendeklarasikan variabel yang dibutuhkan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa); //layout yang digunakan adalah activity_list_nama_mahasiswa
        setTitle("AsyncTask"); //set title pada tampilan layar
        listMhs = (ListView) findViewById(R.id.listView); //memanggil atribut yang ada di layout
    }
    public void mulai(View view) { //method saat button ditekan
        new getData(listMhs).execute(); //proses asynctask dimulai dengan get data listmhs
    }
    class getData extends AsyncTask<String, Integer, String> { //subclass assynctask
        ListView listMhs; //deklarasikan kembali listview dengan nama yang sama dengan diatas
        ArrayAdapter adapter; //deklarasikan adapter untuk menampung data yang akan ditampilkan
        ArrayList<String> listNama; //deklarasikan nama array dengan tipe data string
        ProgressDialog dialog; //deklarasi dialog yang akan dimunculkan untuk loading data


        public getData(ListView listMhs) { //constructor saat asynctask diinisialisasi
            this.listMhs = listMhs; //get data listmhs
            dialog = new ProgressDialog(ListNamaMahasiswa.this); //dialog akan di proses di dalam class listnamamahasiswa
            listNama = new ArrayList<>(); //list nama akan ditampilkan dengan menggunakan arrray
        }

        @Override
        protected void onPreExecute() { //method ketika proses asynctask belum dimulai
            super.onPreExecute();
            dialog.setTitle("Loading Data"); //menampilkan proses dialog dengan judul loading data
            dialog.setIndeterminate(true);
            dialog.setProgress(0); //progres atau persentasi pada dialog paling kecil adalah 0 atau 0%
            dialog.setMax(100); //progres atau persentasi pada dialog paling kecil adalah 100 atau 100%
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() { //jika dialog dibatalkan akan muncul toast ini
                @Override
                public void onClick(DialogInterface dialogInterface, int i) { //onclick untuk menampilkan dialog
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            dialog.show(); //dialog ditampilkan
        }
        @Override
        protected String doInBackground(String... strings) { //method saat proses asynctask dijalankan
            adapter = new ArrayAdapter<>(ListNamaMahasiswa.this, android.R.layout.simple_list_item_1, listNama); //membuat adapter

            String[] mhs = getResources().getStringArray(R.array.namaMhs); //menyimpan array pada sebuah variabel lalu get data dengan id
            for (int a = 0; a < mhs.length; a++) { //perulangan untuk menyimpan array
                final long persen = 100L * a / mhs.length; //persen terakhir yang ditampilkan adalah 100
                final String nama = mhs[a]; //mhs diinisiasikan dengan array a
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() { //jika dijalankan
                            dialog.setMessage((int) persen+"% - Adding "+nama); //dialog yang ditampilkan adalah jumlah persen dan nama mahasiswa
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mhs[a]); //list ditampilkan dengan data yang ditampung oleh array a
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {  //method sesudah asynctask sudah dijalankan
            super.onPostExecute(s);
            listMhs.setAdapter(adapter); //data yang menampung list
            dialog.dismiss(); //menghilangkan dialog
        }
    }
}
