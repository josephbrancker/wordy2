package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    static java.util.List<String> list;
    static String word;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        List wordy = new List();
        word = wordy.get_random_word();
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        binding.textView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(66 == keyEvent.getKeyCode()){
                    EditText input = view.findViewById(R.id.textView);
                    String userword = input.getText().toString();
                    userword = userword.replace("\n", "");
                    if(userword.equalsIgnoreCase(word)){
                        Toast myWin = Toast.makeText(getActivity(), "You Win!", Toast.LENGTH_SHORT);
                        myWin.show();
                        List wordy = new List();
                        word = wordy.get_random_word();
                    }
                    else{
                        Toast myLose = Toast.makeText(getActivity(), "You Lose!", Toast.LENGTH_SHORT);
                        myLose.show();
                        List wordy = new List();
                        word = wordy.get_random_word();
                        Log.d("word", word);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}