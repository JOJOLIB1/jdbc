package learn.blob;

import org.junit.Test;
import util.JDBCUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-22
 * Time: 17:05
 */
public class BlobUpdateSelect {
    // 16号的图片导入
    @Test
    public void readBlob() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FileOutputStream os = null;
        InputStream is = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select photo from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,16);
            rs = ps.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(1);
                is = blob.getBinaryStream();
                os = new FileOutputStream("pic.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    os.write(bytes,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection,rs);
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    @Test
    public void writeBlob() throws Exception {
        PreparedStatement ps = null;
        Connection connection = null;
        FileInputStream fis = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into customers(photo) values(?)";
            ps = connection.prepareStatement(sql);
            fis = new FileInputStream(new File("pic.jpg"));
            ps.setBlob(1,fis);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection);
            if (fis != null) {
                fis.close();
            }
        }
    }
}
