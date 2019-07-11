package ylzl.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

/**
 * @program: itcaststore
 * @description: c3p0连接池工具类
 * @author: Leo
 * @create: 2019-07-08 20:54
 **/
public class C3P0Utils {
    //创建数据源
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    /**
     * 返回数据源
     * @return
     */
    public static DataSource getDataSource() {
        return cpds;
    }
}