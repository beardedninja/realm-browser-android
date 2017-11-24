package com.nikoyuwono.realmbrowser.sample;

import android.app.Application;

import com.nikoyuwono.realmbrowser.sample.model.Product;
import com.nikoyuwono.realmbrowser.sample.model.User;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by nyuwono on 12/7/15.
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("sample.realm")
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User user = realm.createObject(User.class);
                        user.setName("Bobby Robert");
                        user.setAge(36);
                        Product product = realm.createObject(Product.class);
                        product.setName("BobProduct");
                        product.setPrice(399);
                    }
                }).schemaVersion(1).deleteRealmIfMigrationNeeded().build();

        Realm.setDefaultConfiguration(config);
    }

}