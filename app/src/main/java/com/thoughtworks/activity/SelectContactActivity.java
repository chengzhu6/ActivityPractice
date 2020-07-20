package com.thoughtworks.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class SelectContactActivity extends AppCompatActivity {
    private final static int REQUEST_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);
        findViewById(R.id.select_contact_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSystemContact();
            }
        });
    }

    public void callSystemContact() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CONTACT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Uri contactData = data.getData();
            if (contactData != null) {
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    String username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    TextView contactInfoTV = (TextView) findViewById(R.id.contact_info);
                    contactInfoTV.setText(String.format("%s: %s", username, phoneNumber));
                    cursor.close();
                }
            }
        }
    }
}