package nz.co.redice.azansilenttime.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import nz.co.redice.azansilenttime.R;
import nz.co.redice.azansilenttime.databinding.ActivityMainBinding;
import nz.co.redice.azansilenttime.services.foreground_service.ServiceHelper;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject ServiceHelper mServiceHelper;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setSupportActionBar(mBinding.toolbar);
        mServiceHelper.startService(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mServiceHelper.doBindService(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mServiceHelper.doUnbindService(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }

    @Override
    public void onBackPressed() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        if (!Objects.requireNonNull(navController.getCurrentDestination()).getLabel().equals("HomeFragment") &&
                !navController.getCurrentDestination().getLabel().equals("LocationFragment")) {
            super.onBackPressed();
        }

    }


}