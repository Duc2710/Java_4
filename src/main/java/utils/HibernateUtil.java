package utils;

import entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DB_JAVA4;encrypt=true;trustServerCertificate=true");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonCT.class);
        conf.addAnnotatedClass(KichThuoc.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(SPChiTiet.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}