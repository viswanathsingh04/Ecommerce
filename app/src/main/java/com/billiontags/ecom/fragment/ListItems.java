package com.billiontags.ecom.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billiontags.ecom.R;
import com.billiontags.ecom.adapter.Item_list_adapter;
import com.billiontags.ecom.inter.ApiInterface;
import com.billiontags.ecom.model.Data;
import com.billiontags.ecom.model.GetItems;
import com.billiontags.ecom.utility.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by VPS on 02-02-2018.
 */

public class ListItems extends Fragment {
    RecyclerView recycler;
    List<Data> data;
    Item_list_adapter item_list_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.list_items, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        data = new ArrayList<>();
        LoadData();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(layoutManager);
        item_list_adapter = new Item_list_adapter(getActivity(), data);
        recycler.setAdapter(item_list_adapter);

    }

    private void LoadData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.AppUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMax(100);
        progressDoalog.setMessage("loading....");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        Call<GetItems> call = apiInterface.GetLifeStyle();
        Log.d("tag1", "message");
        call.enqueue(new Callback<GetItems>() {
            @Override
            public void onResponse(@NonNull Call<GetItems> call, @NonNull Response<GetItems> response) {
                Log.d("tag2", response.message());
                if (response.isSuccessful()) {
                    GetItems sd = response.body();
                    Log.d("maindata", String.valueOf(sd));
                    progressDoalog.dismiss();

                    try {
                        List<Data> sampleData = fetchResults(response);
                        if (sampleData != null && sampleData.size() > 0) {
                            for (Data ghg : sampleData) {
                                data.add(ghg);
                            }
                            item_list_adapter.notifyDataSetChanged();
                        }
                        progressDoalog.dismiss();
                        System.out.println("Ecomm-ArraySize" + data.size());
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetItems> call, Throwable t) {
                t.getStackTrace();
                progressDoalog.dismiss();
                Log.v("Ecomm", "No Response!");
            }
        });
    }

    /**
     * @param response extracts List<{@link Data>} from response
     * @return
     */
    private List<Data> fetchResults(Response<GetItems> response) {
        GetItems sample_data = response.body();
        sample_data.getData().getClass().getName();
        return sample_data.getData();
    }
}
