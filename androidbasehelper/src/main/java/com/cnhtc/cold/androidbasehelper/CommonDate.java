package com.cnhtc.cold.androidbasehelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonDate {
    public String getCommonDateString(String dateString){
        SimpleDateFormat simpleDateFormatPHP=new SimpleDateFormat("MMM dd yyyy hh:mm:ss:SSSa", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormatYMDHMS = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        SimpleDateFormat simpleDateFormatYMDHMSWithCHN=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat simpleDateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date=simpleDateFormatPHP.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMDHMS.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMDHMSWithCHN.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMD.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        date=new Date();
        return simpleDateFormatPHP.format(date);
    }

    public String getCommonDateTimeString(String dateString){
        SimpleDateFormat simpleDateFormatPHP=new SimpleDateFormat("MMM dd yyyy hh:mm:ss:SSSa", Locale.ENGLISH);
        SimpleDateFormat simpleDateFormatYMDHMS = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        SimpleDateFormat simpleDateFormatYMDHMSWithCHN=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat simpleDateFormatYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date=simpleDateFormatPHP.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMDHMS.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMDHMSWithCHN.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date=simpleDateFormatYMD.parse(dateString);
            return simpleDateFormatYMD.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        date=new Date();
        return simpleDateFormatPHP.format(date);
    }
}
