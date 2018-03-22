package id.liqu.laundry.liquid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.hawk.Hawk;

import butterknife.ButterKnife;

/**
 * Created by iamnubs on 18/03/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        Hawk.init(this).build();
    }

    public abstract int layoutId();
}
