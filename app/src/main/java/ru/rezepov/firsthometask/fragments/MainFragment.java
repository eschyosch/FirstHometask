package ru.rezepov.firsthometask.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import ru.rezepov.firsthometask.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Button button;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        editText1 = (EditText) view.findViewById(R.id.editText3);
        editText2 = (EditText) view.findViewById(R.id.editText4);
        textView = (TextView) view.findViewById(R.id.textView2);
        button = (Button) view.findViewById(R.id.button);

        editText1.addTextChangedListener(watcher);
        editText2.addTextChangedListener(watcher);
        textView.addTextChangedListener(watcher);
        button.setClickable(false);
        return view;
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            if (!editText1.getText().toString().equals("")
                    && !editText2.getText().toString().equals("")
                    && !textView.getText().toString().equals(getResources().getString(R.string.init_text))){
                button.setClickable(true);
            } else {
                button.setClickable(false);
            }
        }
    };
}
