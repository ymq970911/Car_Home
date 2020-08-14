package com.autohome.server.convert;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @program: ZtkOpen
 * @description:
 * @author: ztk
 * @create: 2020-08-07 18:25
 **/

@MappedTypes({JsonObject.class})
public class JsonTypeHandler extends BaseTypeHandler<Object> {
    private static final Gson gson = new Gson();
    private final Class javaType;

    public JsonTypeHandler(Class javaType) {
        this.javaType = javaType;
    }

    public Class getJavaType() {
        return javaType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement
            , int i, Object o, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,gson.toJson(o));
    }

    public Object toJsonObject(String jsonStr) {
        if (!StringUtils.isEmpty(jsonStr)) {
            return gson.fromJson(jsonStr, getJavaType());
        }
        return null;
    }


    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return toJsonObject(resultSet.getString(s));
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return toJsonObject(resultSet.getString(i));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return toJsonObject(callableStatement.getString(i));
    }
}
