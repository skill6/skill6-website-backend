package cn.skill6.common.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式化助手
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年2月28日 上午11:23:56
 */
public class DateFormat {
  /** 获取当前格式化时间 */
  public static String formatNowDate() {
    String dateFormat = "yyyy-MM-dd HH:mm:ss";

    return formatNowDate(dateFormat);
  }

  /**
   * 根据格式获取时间( yyyy MM dd HH mm ss 等顺序可变 )
   *
   * @param dateFormat
   */
  public static String formatNowDate(String dateFormat) {
    SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
    Date date = new Date();
    String formatDate = dateFormater.format(date);

    return formatDate;
  }

  /** 获取 yyyy-MM-dd 格式的时间 */
  public static String formatDateYMD() {
    String dateFormat = "yyyy-MM-dd";

    return formatDateYMD(dateFormat);
  }

  /**
   * 获取只含年月日格式的时间( yyyy MM dd 等顺序可变 )
   *
   * @param dateFormat
   */
  public static String formatDateYMD(String dateFormat) {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    String dateString = formatter.format(currentTime);

    return dateString;
  }

  /** 从当日0时0分0秒到当前时间的毫秒数 */
  public static Long secondsTodayTotal() {
    Calendar calendar = Calendar.getInstance();

    calendar.setTime(new Date());
    Long zeroSeconds = calendar.getTime().getTime();

    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    Long todaySeconds = zeroSeconds - calendar.getTime().getTime();

    return todaySeconds;
  }

  /** 获取当前日期数字格式,如20171020为2017年10月20日 */
  public static String dateNumberFormat() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    return sdf.format(new Date());
  }
}
