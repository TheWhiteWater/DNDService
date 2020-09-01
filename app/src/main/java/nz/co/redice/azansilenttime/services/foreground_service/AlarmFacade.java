package nz.co.redice.azansilenttime.services.foreground_service;

import androidx.core.app.NotificationCompat;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.subjects.BehaviorSubject;
import nz.co.redice.azansilenttime.services.alarm_service.AlarmService;
import nz.co.redice.azansilenttime.services.alarm_service.AlarmServiceImpl;
import nz.co.redice.azansilenttime.services.audio_service.AudioService;
import nz.co.redice.azansilenttime.services.audio_service.AudioServiceImpl;
import nz.co.redice.azansilenttime.services.notification_service.NotificationService;
import nz.co.redice.azansilenttime.services.notification_service.NotificationServiceImpl;

@Singleton
public class AlarmFacade {

    private AlarmService mAlarmService;
    private NotificationService mNotificationService;
    private AudioService mAudioService;

    @Inject
    public AlarmFacade(AlarmServiceImpl alarmService,
                       NotificationServiceImpl notificationService,
                       AudioServiceImpl audioService) {
        mAlarmService = alarmService;
        mNotificationService = notificationService;
        mAudioService = audioService;
        mAlarmService.registerNewAlarmListener(mNotificationService);
    }


    public void getSchedulesFromNextTwoDaysStartingFrom(LocalDate now) {
        mAlarmService.getSchedulesFromNextTwoDaysStartingFrom(now);
    }

    public void getSchedulesFromNextTwoFridaysStartingFrom(LocalDate now) {
        mAlarmService.getSchedulesFromNextTwoFridaysStartingFrom(now);
    }

    public BehaviorSubject<String> getNextAlarmTimeBehaviorSubject() {
        return mNotificationService.getNextAlarmTextTimeBehaviorSubject();
    }

    public NotificationCompat.Builder getNotificationBuilder() {
        return mNotificationService.getNotificationBuilder();
    }

    public void scheduleWakeUpAlarm() {
        mAlarmService.scheduleWakeUpAlarm();
    }

    public void turnAudioServicesOn() {
        mAudioService.turnAudioServicesOn();
    }

    public void turnAudioServicesOff() {
        mAudioService.turnAudioServicesOff();
    }



}
