package com.cx.springboot.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 年
     * 可以通过DateUtil.now().get(DateUtil.YEAR_FIELD)来获取当前时间的年
     */
    private static final int YEAR_FIELD = Calendar.YEAR;

    /**
     * 月
     * 可以通过DateUtil.now().get(DateUtil.MONTH_FIELD)来获取当前时间的年
     */
    private static final int MONTH_FIELD = Calendar.MONTH;

    /**
     * 日
     * 可以通过DateUtil.now().get(DateUtil.DAY_FIELD)来获取当前时间的年
     */
    private static final int DAY_FIELD = Calendar.DATE;

    /**
     * 小时 <p>可以通过DateTime.now().get(DateTime.HOUR_FIELD)来获取当前时间的小时</p>
     */
    public static final int HOUR_FIELD = java.util.Calendar.HOUR_OF_DAY;

    /**
     * 分钟 <p>可以通过DateTime.now().get(DateTime.MINUTE_FIELD)来获取当前时间的分钟</p>
     */
    public static final int MINUTE_FIELD = java.util.Calendar.MINUTE;

    /**
     * 秒
     * <p>可以通过DateTime.now().get(DateTime.SECOND_FIELD)来获取当前时间的秒</p>
     */

    public static final int SECOND_FIELD = java.util.Calendar.SECOND;

    /**
     * 毫秒 <p>可以通过DateTime.now().get(DateTime.MILLISECOND_FIELD)来获取当前时间的毫秒</p>
     */
    public static final int MILLISECOND_FIELD = java.util.Calendar.MILLISECOND;

    /**
     * 日历类
     */
    private Calendar c;


    /**
     * 获取一个DateUtil,此DateUtil尚未初始化,表示的时间是1970-1-1 00:00:00.000
     * 要获取当前系统时间，请用DateUtil.now()
     */
    public DateUtil() {
        c = Calendar.getInstance();
        c.clear();
    }


    /**
     * 设置时间
     *
     * @param date 传入一个时间对象，将会被转换为DateUtil类型
     */
    public DateUtil(Date date) {
        c = Calendar.getInstance();
        c.setTime(date);
    }


    /**
     * 设置时间
     *
     * @param calendar 传入一个日历对象,将会被转换为DateUtil类型
     */
    public DateUtil(Calendar calendar) {
        this.c = calendar;
    }

    /**
     * 用来设置时间,时间的基数是1970-1-1 00:00:00.000
     * 比如 new DateUtil(1000) 则表示1970-1-1 00:00:01.000
     * 用负数表示基础时间以前的时间
     *
     * @param milliseconds 毫秒
     */
    public DateUtil(long milliseconds) {
        c = Calendar.getInstance();
        c.setTimeInMillis(milliseconds);
    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static DateUtil now() {
        Calendar calendar = Calendar.getInstance();
        return new DateUtil(calendar);
    }


    /**
     * 转换为Date类型
     *
     * @return
     */
    public Date toDate() {
        return c.getTime();
    }

    /**
     * 转换成日历对象
     *
     * @return
     */
    public Calendar toCalendar() {
        return c;
    }

    /**
     * 转换成 java.sql.Date(yyyy-MM-dd)日期
     *
     * @return
     */
    public java.sql.Date toSqlDate() {
        return new java.sql.Date(c.getTimeInMillis());
    }

    /**
     * 转换为java.sql.Time(hh:mm:ss)时间
     *
     * @return
     */
    public Time toSqlTime() {
        return new Time(c.getTimeInMillis());
    }

    /**
     * 转换为java.sql.Timestamp(时间戳)
     *
     * @return java.sql.Timestamp时间戳
     */
    public Timestamp toSqlTimestamp() {
        return new Timestamp(c.getTimeInMillis());
    }

    /**
     * 解析时间
     * 根据DateUtil中的DEFAULT_TIME_FORMAT规则转换为HH:mm:ss格式
     *
     * @param time
     * @return
     */
    public static DateUtil parseTime(String time) throws ParseException {
        try {
            return DateUtil.parseDateTime(time, DateUtil.DEFAULT_TIME_FORMAT);
        } catch (ParseException e) {
            return DateUtil.parseDateTime(time, DateUtil.DEFAULT_TIME_FORMAT);
        }
    }

    /**
     * 解析日期
     * 根据DateUtil中的DEFAULT_DATE_FORMAT规则转换为yyyy-MM-dd格式
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static DateUtil parseDate(String date) throws ParseException {
        return DateUtil.parseDateTime(date, DateUtil.DEFAULT_DATE_FORMAT);
    }

    /**
     * 字符串 转换为时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date stringParseDate1(String date) throws ParseException {
        return parseDate(date).toDate();
    }

    /**
     * 解析日期时间
     * 根据DateUtil中的DEFAULT_DATE_TIME_FORMAT_PATTERN规则转换为yyyy-MM-dd
     *
     * @param dateTime
     * @return
     */
    public static DateUtil parseDateTime(String dateTime) {
        DateUtil result = null;
        //尝试按yyyy-MM-dd HH:mm:ss分析
        try {
            result = DateUtil.parseDateTime(dateTime, DateUtil.DEFAULT_DATETIME_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        //尝试按yyyy-MM-dd 分析
        if (null == result) {
            try {
                result = DateUtil.parseDateTime(dateTime, DateUtil.DEFAULT_DATE_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        //尝试按HH:mm:ss分析
        if (null == result) {
            try {
                result = DateUtil.parseDate(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        if (null == result) {
            result = DateUtil.parseDateTime(dateTime);
        }
        return result;
    }

    /**
     * 用指定的pattern分析字符串
     *
     * @param dateTime 字符串格式日期时间
     * @param format   日期解析规则
     * @return 日期时间对象
     * @throws ParseException
     * @see java.text.SimpleDateFormat
     */
    public static DateUtil parseDateTime(String dateTime, String format) throws ParseException {
        SimpleDateFormat fmt = (SimpleDateFormat) DateFormat.getInstance();
        fmt.applyPattern(format);
        return new DateUtil(fmt.parse(dateTime));
    }


    /**
     * 转换为DEFAULT_DATE_FORMAT(yyyy-MM-dd)格式字符串
     *
     * @return
     */
    public String toDateString() {
        return toDateTimeString(DateUtil.DEFAULT_DATE_FORMAT);
    }

    /**
     * 转换为DEFAULT_TIME_FORMAT(HH:mm:ss)格式字符串
     *
     * @return
     */
    public String toTimeString() {
        return toDateTimeString(DateUtil.DEFAULT_TIME_FORMAT);
    }

    /**
     * 转换为DEFAULT_DATETIME_FORMAT(yyyy-MM-dd HH:mm:ss)格式字符串
     *
     * @return
     */
    public String toDateTimeString() {
        return toDateTimeString(DateUtil.DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 使用日期转换pattern
     *
     * @param pattern 日期解析规则
     * @return
     */
    public String toDateTimeString(String pattern) {
        SimpleDateFormat fmt = (SimpleDateFormat) DateFormat.getDateInstance();
        fmt.applyPattern(pattern);
        return fmt.format(c.getTime());
    }

    /**
     * 获取DateTime所表示时间的某个度量的值
     *
     * @param field int 取值为:<br> DateTime.YEAR_FIELD -- 返回年份<br>
     *              DateTime.MONTH_FIELD -- 返回月份,一月份返回1,二月份返回2,依次类推<br> DateTime.DAY_FIELD --
     *              返回当前的天(本月中的)<br> DateTime.HOUR_FIELD -- 返回小时数(本天中的),24小时制<br>
     *              DateTime.MINUTE_FIELD -- 返回分钟数(本小时中的)<br> DateTime.SECOND_FIELD --
     *              返回秒数(本分钟中的)<br> DateTime.MILLISECOND_FIELD -- 返回毫秒数(本秒中的)
     * @return int field对应的值
     */
    public int get(int field) {
        //月份需要+1(月份从0开始)
        if (DateUtil.MONTH_FIELD == field) {
            return c.get(field) + 1;
        } else {
            return c.get(field);
        }
    }

    /**
     * 返回自 1970-1-1 0:0:0 至此时间的毫秒数
     *
     * @return long 毫秒数
     */
    public long getTimeInMillis() {
        return c.getTimeInMillis();
    }


    /**
     * 设置field字段的值
     *
     * @param field int 取值为:<br> DateTime.YEAR_FIELD -- 年份<br>
     *              DateTime.MONTH_FIELD -- 月份,一月份从1开始<br> DateTime.DAY_FIELD --
     *              当前的天(本月中的)<br> DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制<br>
     *              DateTime.MINUTE_FIELD -- 分钟数(本小时中的)<br> DateTime.SECOND_FIELD --
     *              秒数(本分钟中的)<br> DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param value
     */
    public void set(int field, int value) {
        //月份需要-1(月份从0开始)
        if (DateUtil.MONTH_FIELD == field) {
            c.set(field, value - 1);
        } else {
            c.set(field, value);
        }
    }


    /**
     * 设置DateTime日期的年/月/日
     *
     * @param year  年
     * @param month 月
     * @param day   日
     */

    public void set(int year, int month, int day) {

        set(DateUtil.YEAR_FIELD, year);

        set(DateUtil.MONTH_FIELD, month);

        set(DateUtil.DAY_FIELD, day);

    }


    /**
     * 设置DateTime日期的年/月/日/小时
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @param hour  小时
     */
    public void set(int year, int month, int day, int hour) {
        set(year, month, day);
        set(DateUtil.HOUR_FIELD, hour);
    }


    /**
     * 设置DateTime日期的年/月/日/小时/分钟
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分钟
     */
    public void set(int year, int month, int day, int hour, int minute) {
        set(year, month, day, hour);
        set(DateUtil.MINUTE_FIELD, minute);
    }


    /**
     * 设置DateTime日期的年/月/日/小时/分钟/秒
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     */
    public void set(int year, int month, int day, int hour, int minute, int second) {
        set(year, month, day, hour, minute);
        set(DateUtil.SECOND_FIELD, second);
    }


    /**
     * 设置DateTime日期的年/月/日/小时/分钟/秒/毫秒
     *
     * @param year        年
     * @param month       月
     * @param day         日
     * @param hour        小时
     * @param minute      分钟
     * @param second      秒
     * @param milliSecond 毫秒
     */
    public void set(int year, int month, int day, int hour, int minute, int second, int milliSecond) {
        set(year, month, day, hour, minute, second);
        set(DateUtil.MILLISECOND_FIELD, milliSecond);
    }


    /**
     * 对field值进行相加 <p>add() 的功能非常强大，add 可以对 DateTime 的字段进行计算。<br>
     * <p>
     * 如果需要减去值，那么使用负数值就可以了，如 add(field, -value)。<br>
     * <p>
     * 或者调用DateTime.reduce(int,int)进行日期相减</p>
     *
     * @param field  int 取值为:<br>   DateTime.YEAR_FIELD -- 年份<br>
     *               <p>
     *               DateTime.MONTH_FIELD -- 月份,一月份从1开始<br>
     *               <p>
     *               DateTime.DAY_FIELD -- 当前的天(本月中的)<br>
     *               <p>
     *               DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制<br>
     *               <p>
     *               DateTime.MINUTE_FIELD -- 分钟数(本小时中的)<br>
     *               <p>
     *               DateTime.SECOND_FIELD -- 秒数(本分钟中的)<br>
     *               <p>
     *               DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param amount 数量(如果数量小于0则为相减)
     */

    public void add(int field, int amount) {

        c.add(field, amount);

    }


    /**
     * 对field值进行相减 <p>对add() 的功能进行封装，add 可以对 Calendar 的字段进行计算。<br>
     * <p>
     * 如果需要减去值，那么使用负数值就可以了，如 add(field, -value)。<br>
     * <p>
     * 详细用法参见Calendar.add(int,int)</p>
     *
     * @param field  int 取值为:<br>   DateTime.YEAR_FIELD -- 年份<br>
     *               <p>
     *               DateTime.MONTH_FIELD -- 月份,一月份从1开始<br>
     *               <p>
     *               DateTime.DAY_FIELD -- 当前的天(本月中的)<br>
     *               <p>
     *               DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制<br>
     *               <p>
     *               DateTime.MINUTE_FIELD -- 分钟数(本小时中的)<br>
     *               <p>
     *               DateTime.SECOND_FIELD -- 秒数(本分钟中的)<br>
     *               <p>
     *               DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param amount 数量(如果数量小于0则为相加)
     */
    public void reduce(int field, int amount) {
        c.add(field, -amount);

    }


    /**
     * 判断此 DateTime 表示的时间是否在指定 Object 表示的时间之后，返回判断结果。 <p>此方法等效于：compareTo(when)
     * <p>
     * > 0<br> 当且仅当 when 是一个 DateTime 实例时才返回 true。否则该方法返回 false。
     *
     * @param when 要比较的 Object
     * @return 如果此 DateTime 的时间在 when 表示的时间之后，则返回 true；否则返回 false。
     */

    public boolean after(Object when) {

        if (when instanceof DateUtil) {

            return c.after(((DateUtil) when).c);

        }

        return c.after(when);

    }


    /**
     * 判断此 DateTime 表示的时间是否在指定 Object 表示的时间之前，返回判断结果。 <p>此方法等效于：compareTo(when)
     * <p>
     * < 0<br> 当且仅当 when 是一个 DateTime 实例时才返回 true。否则该方法返回 false。</p>
     *
     * @param when 要比较的 Object
     * @return 如果此 Calendar 的时间在 when 表示的时间之前，则返回 true；否则返回 false。
     */

    public boolean before(Object when) {

        if (when instanceof DateUtil) {

            return c.before(((DateUtil) when).c);

        }
        return c.before(when);

    }


    /**
     * 创建并返回此对象的一个副本
     *
     * @return 日期时间对象
     */

    @Override

    public Object clone() {

        return new DateUtil((Calendar) c.clone());

    }


    /**
     * 返回该此日历的哈希码
     *
     * @return 此对象的哈希码值。
     * @see Object
     */
    @Override
    public int hashCode() {
        return c.hashCode();
    }


    /**
     * 时间转换为字符串
     *
     * @param date   时间
     * @param format 格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 时间转化为 YYYY-MM-DD HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static String dateToDateTime(Date date) {
        return dateToString(date, DateUtil.DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 时间转化为 YYYY-MM-DD格式
     *
     * @param date
     * @return
     */
    public static String dateToDateString(Date date) {
        return dateToString(date, DateUtil.DEFAULT_DATE_FORMAT);
    }

    /**
     * 时间转化为 HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static String dateToTimeString(Date date) {
        return dateToString(date, DateUtil.DEFAULT_TIME_FORMAT);
    }


    public static void main(String[] args) {
        String s = DateUtil.dateToDateTime(new Date());
        System.out.println(s);
        try {
            Date date = DateUtil.parseDate("2018-09-26").toDate();
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
