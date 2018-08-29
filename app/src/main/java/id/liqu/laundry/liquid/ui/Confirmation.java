package id.liqu.laundry.liquid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import id.liqu.laundry.liquid.R;

public class Confirmation extends AppCompatActivity {

    FirebaseAuth mAuth;
    String name;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance().getReference();

        final Order order4 = (Order) getIntent().getSerializableExtra("datak");
       // order4.Status = "Order Terkirim";

        TextView nama = (TextView) findViewById(R.id.detail_orderNama2);
        TextView alamat = (TextView) findViewById(R.id.detail_orderalamat);
        TextView berat = (TextView) findViewById(R.id.detail_orderberat);
        TextView harga = (TextView) findViewById(R.id.detail_orderharga);

        name = user.getDisplayName();
        nama.setText(name);
        alamat.setText(order4.getLocation());
        berat.setText(order4.getBerat()+" Kg");
        harga.setText("Rp."+order4.getHarga());

        Button confirm = (Button) findViewById(R.id.Confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order Ord = new Order();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                Ord.setDateP(order4.getDateP());
                Ord.setTimeP(order4.getTimeP());
                Ord.setLocation(order4.getLocation());
                Ord.setNotes(order4.getNotes());
                Ord.setDateD(order4.getDateD());
                Ord.setTimeD(order4.getTimeD());
                Ord.setStatus("order dikirim");
                Ord.setLatitude(order4.getLatitude());
                Ord.setLongitude(order4.getLongitude());
                Ord.setHarga(order4.getHarga());
                Ord.setBerat(order4.getBerat());

                String key = database.child("order").push().getKey();
                Map<String,Object> post = Ord.toMap();

                Map<String,Object> child = new HashMap<>();
                child.put("/order/"+uid+"/"+key,post);
                database.updateChildren(child).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Snackbar.make(findViewById(R.id.Confirm_btn), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                        startActivity(new Intent(Confirmation.this, MainActivity.class));
                        Toast.makeText(Confirmation.this, "Order Terkirim", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

