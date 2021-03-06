package nz.co.redice.azansilenttime.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import nz.co.redice.azansilenttime.repo.local.AppDatabase;
import nz.co.redice.azansilenttime.repo.local.EventDao;


@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "database" )
                .fallbackToDestructiveMigration()
                .build();
    }


    @Provides
    @Singleton
    EventDao provideDao(AppDatabase database) {
        return  database.getDao();
    }
}
