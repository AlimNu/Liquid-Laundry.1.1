package id.liqu.laundry.liquid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import id.liqu.laundry.liquid.R;

/**
 * Created by fathy on 23/03/2018.
 */

public class PricingActivity extends AppCompatActivity {

    Button button, submitharga;
    TextInputEditText berat;
    TextView cost;
    int i=0, harga;
    FirebaseAuth mAuth;
    String name,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricing);
        harga= 0;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        TextView nama = (TextView) findViewById(R.id.price_name);
        TextView email = (TextView) findViewById(R.id.price_email);

        name = user.getDisplayName();
        address = user.getEmail();

        nama.setText(name);
        email.setText(address);


        button =  (Button) findViewById(R.id.plus_btn);
        cost = (TextView) findViewById(R.id.harga);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berat = (TextInputEditText) findViewById(R.id.berat);
                i = i +1;
                berat.setText(""+i);

                cost.setText(""+hitungHarga(i));


            }
        });

        button =  (Button) findViewById(R.id.minus_btn);
        cost = (TextView) findViewById(R.id.harga);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berat = (TextInputEditText) findViewById(R.id.berat);
                i = i-1;
                berat.setText(""+i);
                cost.setText(""+hitungHarga(i));
            }
        });
        final Order order3 = (Order) getIntent().getSerializableExtra("data1");


        submitharga = (Button) findViewById(R.id.submitharga);
        submitharga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PricingActivity.this, Confirmation.class);
                Order der = new Order(
                        order3.getDateP(),
                        order3.getDateP(),
                        order3.getLocation(),
                        order3.getNotes(),
                        order3.getDateD(),
                        order3.getTimeD(),
                        order3.getLatitude(),
                        order3.getLongitude(),
                        order3.harga = Integer.parseInt(cost.getText().toString()),
                        order3.harga= Integer.parseInt(berat.getText().toString())
                );
                Log.d("order:",der.toString());
                i.putExtra("datak",der);
                startActivity(i);
            }
        });


    }


    public int hitungHarga(int i){
        int total = 5000 * i;
        return total;
    }

}
