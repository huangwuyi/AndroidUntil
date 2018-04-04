package com.cnhtc.cold.androidbasehelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInfo {
    /*
    * 验证手机号是否符合规定
    * */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
