package nz.co.redice.azansilenttime.services.alarm_service;

public interface OnNewAlarmListener {

    void notifyNewAlarmScheduled(Long timing);
}
