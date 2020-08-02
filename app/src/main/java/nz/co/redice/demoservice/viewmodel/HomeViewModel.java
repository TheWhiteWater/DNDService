package nz.co.redice.demoservice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import nz.co.redice.demoservice.repo.Repository;
import nz.co.redice.demoservice.repo.local.entity.EntryModel;
import nz.co.redice.demoservice.utils.PrefHelper;
import nz.co.redice.demoservice.utils.ServiceHelper;

public class HomeViewModel extends AndroidViewModel {

    private final SavedStateHandle savedStateHandle;
    private Repository mRepository;
    private ServiceHelper mServiceHelper;
    private PrefHelper mPrefHelper;


    @ViewModelInject
    public HomeViewModel(@NonNull Application application,
                         Repository repository, ServiceHelper serviceHelper,
                         PrefHelper prefHelper,
                         @Assisted SavedStateHandle savedStateHandle) {
        super(application);
        mRepository = repository;
        this.savedStateHandle = savedStateHandle;
        mServiceHelper = serviceHelper;
        mServiceHelper.startService(application);
        mServiceHelper.doBindService(application);
        mPrefHelper = prefHelper;
    }


    public LiveData<EntryModel> getTimesForSelectedDate(Long date) {
        return mRepository.getSelectedDate(date);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        mServiceHelper.doUnbindService(getApplication());
    }

    public LiveData<Integer> getDatabaseSize() {
        return mRepository.getDatabaseSize();
    }

    public void fillUpDaBase() {
        mRepository.requestStandardAnnualCalendar(mPrefHelper.getLatitude(), mPrefHelper.getLongitude());
    }

    public LiveData<EntryModel> updateEntry(EntryModel model) {
        mRepository.updateSelectedEntry(model);
        return mRepository.getSelectedDate(model.getDate());
    }
}
