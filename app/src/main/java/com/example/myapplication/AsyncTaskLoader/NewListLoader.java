package com.example.myapplication.AsyncTaskLoader;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.myapplication.API.NetworkUtils;
import com.example.myapplication.data.model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class NewListLoader extends AsyncTaskLoader<LinkedList<News>> {


    public NewListLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public LinkedList<News> loadInBackground() {
        LinkedList<News> newLinkedList = new LinkedList<>();
        try {
            JSONObject jsonObject = new JSONObject(NetworkUtils.loadListNew());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            Log.d("TEST_JSON",jsonArray.toString());
            if(jsonArray != null && jsonArray.length() > 0){
                for (int i = 0; i < jsonArray.length();i++){
                    JSONObject jsonItem = jsonArray.getJSONObject(i);
                    int IdNews = jsonItem.getInt("IdNews");
                    String Title = jsonItem.getString("Title");
                    Log.d("TEST_LOGg",Title);
                    String Description = jsonItem.getString("Description");
                    News news = new News(IdNews,Title,Description,null,null);
                    newLinkedList.addLast(news);
                }
                return newLinkedList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
