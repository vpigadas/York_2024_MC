package eu.york.york2024mc.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import eu.york.york2024mc.databinding.ActivityMyFragmentBinding;

public class MyFragmentActivity extends AppCompatActivity {

    private ActivityMyFragmentBinding binding;
    private ActViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ActViewModel.class);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //Log.d("VIEWMODEL", String.valueOf(viewModel.getName()));

        viewModel.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.number.setText(String.valueOf(integer));
            }
        });

        FragmentContainerView view = binding.fragmentContainerView;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(view.getId(), FirstFragment.newInstance("vassilis"), "first_fragment");
        fragmentTransaction.commit();

        ViewPager viewPager = binding.fragmentViewPager;
        viewPager.setAdapter(new MViewPagerAdapter(getSupportFragmentManager()));
    }
}