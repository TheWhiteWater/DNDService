
package nz.co.redice.demoservice.repo.remote.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("readable")
    @Expose
    public String readable;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("gregorian")
    @Expose
    public Gregorian gregorian;


}