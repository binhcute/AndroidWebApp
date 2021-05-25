package com.example.myapplication.Bottom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Login.LoginActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    public static String USER_NAME = "username";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView txtUser_Login;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String UserName;
    private static final int LOGIN_REQUEST = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = sharedPreferences.edit();
    }

    public void UserLogin(View view){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivityForResult(intent,LOGIN_REQUEST);
    }
    public void UserLogout(View view){
        txtUser_Login.setText("Đăng Nhập");
        txtUser_Login.setEnabled(true);
        editor.clear();
        editor.commit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View item = inflater.inflate(R.layout.fragment_user,container,false);
        txtUser_Login = item.findViewById(R.id.txt_DangNhap);
        Bundle bundle = getArguments();
        if(bundle != null) {
            String userName = bundle.getString(MainActivity.USER_NAME);
            Log.d("TEST_USER",userName);
            editor.putString(USER_NAME,userName);
            editor.commit();
        }
        if(sharedPreferences != null && sharedPreferences.getString(USER_NAME,"").length() > 0){
            String userName = sharedPreferences.getString(USER_NAME,"");
            Log.d("TEST_USER",userName);
            txtUser_Login.setText(userName);
            txtUser_Login.setEnabled(false);
        }
        // Inflate the layout for this fragment
        return item;
    }

    
}