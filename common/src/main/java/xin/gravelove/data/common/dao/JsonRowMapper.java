package xin.gravelove.data.common.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class JsonRowMapper implements RowMapper<JSONObject> {

    @Override
    public JSONObject mapRow(ResultSet rs, int i) throws SQLException {
        JSONObject jsonObject = new JSONObject();
        String key = null;
        Object obj = null;
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int j = 0; j <= count; j++) {
            key = JdbcUtils.lookupColumnName(rsmd,i);
            obj = JdbcUtils.getResultSetValue(rs,i);
            try{
                jsonObject.put(key,obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}
