package nz.co.redice.azansilenttime.repo;

import android.annotation.SuppressLint;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import nz.co.redice.azansilenttime.repo.local.EventDao;
import nz.co.redice.azansilenttime.repo.local.entity.FridaySchedule;
import nz.co.redice.azansilenttime.repo.local.entity.RegularSchedule;
import nz.co.redice.azansilenttime.repo.remote.AzanService;

public class Repository {

    private final EventDao mDao;
    private AzanService mAzanService;

    @Inject
    public Repository(AzanService newsService, EventDao dao) {
        mAzanService = newsService;
        mDao = dao;
    }

    public AzanService getAzanService() {
        return mAzanService;
    }

    public void insertRegularEntry(RegularSchedule entry) {
        mDao.insertEntry(entry);
    }

    public void deletePrayerCalendar() {
        Completable.fromAction(mDao::deleteCalendar)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public RegularSchedule getRegularEntry(Long value) {
        return mDao.getSelectedRegularEntry(value);
    }

    public void updateRegularEntry(RegularSchedule model) {
        mDao.updateEntry(model)
                .subscribeOn(Schedulers.computation())
                .subscribe();
    }


    public FridaySchedule getFridayEntry(Long value) {
        return mDao.getSelectedFridayEntry(value);
    }


    @SuppressLint("CheckResult")
    public void updateFridayEntry(FridaySchedule fridaySchedule) {
        Observable.just(fridaySchedule)
                .subscribeOn(Schedulers.io())
                .subscribe(s -> mDao.updateFridayEntry(fridaySchedule));
    }

    @SuppressLint("CheckResult")
    public void insertFridayEntry(FridaySchedule fridaySchedule) {
        Observable.just(fridaySchedule)
                .subscribeOn(Schedulers.io())
                .subscribe(mDao::insertFridayEntry);
    }

    public Observable<List<RegularSchedule>> selectTwoDaysForAlarmSetting(Long startDate, Long endDate) {
        return mDao.getTwoDaysForAlarmSetting(startDate, endDate);
    }

    public Observable<List<FridaySchedule>> selectTwoFridaysForAlarmSetting(Long startDate, Long endDate) {
        return mDao.getTwoFridaysForAlarmSetting(startDate, endDate);
    }

}