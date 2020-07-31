package nz.co.redice.demoservice.repo.remote.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("1")
    @Expose
    public List<Day> _1 = new ArrayList<>();
    @SerializedName("2")
    @Expose
    public List<Day> _2 = new ArrayList<>();
    @SerializedName("3")
    @Expose
    public List<Day> _3 = new ArrayList<>();
    @SerializedName("4")
    @Expose
    public List<Day> _4 = new ArrayList<>();
    @SerializedName("5")
    @Expose
    public List<Day> _5 = new ArrayList<>();
    @SerializedName("6")
    @Expose
    public List<Day> _6 = new ArrayList<>();
    @SerializedName("7")
    @Expose
    public List<Day> _7 = new ArrayList<>();
    @SerializedName("8")
    @Expose
    public List<Day> _8 = new ArrayList<>();
    @SerializedName("9")
    @Expose
    public List<Day> _9 = new ArrayList<>();
    @SerializedName("10")
    @Expose
    public List<Day> _10 = new ArrayList<>();
    @SerializedName("11")
    @Expose
    public List<Day> _11 = new ArrayList<>();
    @SerializedName("12")
    @Expose
    public List<Day> _12 = new ArrayList<>();

    private List<Day> annualList = new ArrayList<>();

//    public List<Day> getAnnualList() {
//         List<Day> annualList = Stream.of(_1, _2, _3,_4, _5, _6, _7, _8, _9, _10, _11, _12)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//         return annualList;
//    }


    public List<Day> getAnnualList() {
        annualList.addAll(_1);
        annualList.addAll(_2);
        annualList.addAll(_3);
        annualList.addAll(_4);
        annualList.addAll(_5);
        annualList.addAll(_6);
        annualList.addAll(_7);
        annualList.addAll(_8);
        annualList.addAll(_9);
        annualList.addAll(_10);
        annualList.addAll(_11);
        annualList.addAll(_12);
        return annualList;
    }
}
