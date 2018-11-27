package com.example.professor.intentsnativas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        //Solicita as permissões
        String[] permissoes = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_CONTACTS
        };
        PermissionUtils.validate(this, 0, permissoes);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Uri uri;
        Intent intent;
        try {
            switch (position) {
                case 0:
                    uri = Uri.parse("tel:12345678");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                    break;
                case 1:
                    uri = Uri.parse("tel:12345678");
                    intent = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(intent);
                    /*
                    try {
                        startActivity(intent);
                    } catch (SecurityException e) {
                        Toast.makeText(this, "Permissão negada!", Toast.LENGTH_SHORT).show();
                    }*/
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
                    intent = new Intent("com.example.tads.TADS");
                    startActivity(intent);
                    break;
                case 10:
                    uri = Uri.parse("mobile://tads/android");
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
        }catch (Exception e){
            Toast.makeText(this,"Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Permissão negada!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
