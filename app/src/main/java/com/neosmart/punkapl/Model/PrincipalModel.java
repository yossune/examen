package com.neosmart.punkapl.Model;

import android.widget.Toast;

import com.neosmart.punkapl.Conexion.Config;
import com.neosmart.punkapl.Interface.JsonBeer;
import com.neosmart.punkapl.Interface.PrincipalInter;

import java.security.Principal;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yossune Arvez on 15,mayo,2022
 * <p>
 * Brentec
 */
public class PrincipalModel implements PrincipalInter.Model {

private PrincipalInter.Presenter presenter;

    public PrincipalModel(PrincipalInter.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void ReadData() {
        System.out.println("*********** ReadData");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new Config().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        JsonBeer beer = retrofit.create(JsonBeer.class);
        Call<List<Cerveza>> call = beer.getBeer();
        System.out.println("*********** Call<List<Cerveza>>" );
        call.enqueue(new Callback<List<Cerveza>>() {
            @Override
            public void onResponse(Call<List<Cerveza>> call, Response<List<Cerveza>> response) {
              System.out.println("***********"+ response.message());

                if (response.isSuccessful()){

                    presenter.MostrarList(response.code()+"",response.body());
                }else {
                    presenter.MostrarList(response.code()+"",response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Cerveza>> call, Throwable t) {
                System.out.println("*********** onFailure . " + t.getMessage());

              //  presenter.MostrarList(t.getMessage()+"",response.body());
            }
        });
        System.out.println("*********** fin");


    }

}
