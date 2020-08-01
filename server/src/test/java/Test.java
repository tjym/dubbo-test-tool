import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/5/14
 * @Modified:
 * @Description:
 * @Date:
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String endTime="2020-07-06";
        Calendar cal = Calendar.getInstance();
        cal.setTime(sd.parse(endTime));
        cal.add(Calendar.DATE,-7);
        System.out.println(sd.format(cal.getTime()));
    }
}
