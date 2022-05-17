package com.neosmart.punkapl.Interface;

import com.neosmart.punkapl.Model.Cerveza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yossune Arvez on 15,mayo,2022
 * <p>
 * Brentec
 */
public interface JsonBeer {

    // //@GET("beers?page=1&per_page=5") @GET("beers?page=2&per_page=1")
    @GET("beers")
    Call <List<Cerveza>> getBeer ();
}

