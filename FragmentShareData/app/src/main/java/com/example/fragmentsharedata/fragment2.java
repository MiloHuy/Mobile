package com.example.fragmentsharedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class fragment2 extends Fragment {
    View view;
    ItemViewModel viewModel;
    EditText editText;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment2,container,false);
        editText = view.findViewById(R.id.fragment2Data);
        button = view.findViewById(R.id.sendData2btn);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.setData(editText.getText().toString());
            }
        });
    }
}
