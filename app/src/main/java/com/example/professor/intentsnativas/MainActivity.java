package com.example.professor.intentsnativas;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acoes, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Uri uri;
        Intent intent;
        switch (position){
            case 0:
                uri = Uri.parse("tel:12345678");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case 1:
                uri = Uri.parse("tel:12345678");
                intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
                break;
            case 2:
                uri = Uri.parse("sms:12345678");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Ola");
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Compartilhar");
                intent.putExtra(Intent.EXTRA_TEXT, "Mensagem");
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent);
                break;
            case 6:
                uri = Uri.parse("content://com.android.contacts/contacts");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 7:
                uri = Uri.parse("content://com.android.contacts/contacts/1");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 8:
                uri = Uri.parse("content://com.android.contacts/contacts");
                intent = new Intent(Intent.ACTION_PICK, uri);
                startActivity(intent);
                break;
            case 9:
                intent = new Intent("com.example.professor.TESTE");
                startActivity(intent);
                break;
            case 10:
                uri = Uri.parse("teste://tads/android");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case 11:
                uri = Uri.parse("http://www.foz.ifpr.edu.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            default:
                finish();
        }
    }
}
