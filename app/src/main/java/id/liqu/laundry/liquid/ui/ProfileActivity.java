package id.liqu.laundry.liquid.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import de.hdodenhof.circleimageview.CircleImageView;
import id.liqu.laundry.liquid.R;

/**
 * Created by fathy on 23/03/2018.
 */

public class ProfileActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth mAuth;
    String as, ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();



        CircleImageView foto = (CircleImageView) findViewById(R.id.icon);
        TextInputEditText nama = (TextInputEditText) findViewById(R.id.profile_name);
        TextInputEditText email = (TextInputEditText) findViewById(R.id.profile_email);

        FirebaseUser user = mAuth.getCurrentUser();

        Uri url = user.getPhotoUrl();
         as = user.getDisplayName();
         ad = user.getEmail();

        Picasso.with(this).load(url).into(foto);
        nama.setText(as);
        email.setText(ad);




    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();



        if (id == R.id.profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        else if (id == R.id.laundry) {


        } else if (id == R.id.logout){
            Hawk.deleteAll();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
