/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.flinkx.rdb.outputformat;

import com.dtstack.flinkx.rdb.DatabaseInterface;
import com.dtstack.flinkx.outputformat.RichOutputFormatBuilder;
import com.dtstack.flinkx.rdb.type.TypeConverterInterface;

import java.util.List;
import java.util.Map;

/**
 * @Company: www.dtstack.com
 * @author sishu.yss
 */
public class JdbcOutputFormatBuilder extends RichOutputFormatBuilder {

    private JdbcOutputFormat format;

    public JdbcOutputFormatBuilder() {
        super.format = format = new JdbcOutputFormat();
    }

    public void setUsername(String username) {
        format.username = username;
    }

    public void setPassword(String password) {
        format.password = password;
    }

    public void setDriverName(String driverName) {
        format.driverName = driverName;
    }

    public void setDBUrl(String dbURL) {
        format.dbURL = dbURL;
    }

    public void setPreSql(List<String> preSql) {
        format.preSql = preSql;
    }

    public void setPostSql(List<String> postSql) {
        format.postSql = postSql;
    }

    public void setUpdateKey(Map<String,List<String>> updateKey) {
        format.updateKey = updateKey;
    }

    public void setDatabaseInterface(DatabaseInterface databaseInterface) {
        format.databaseInterface = databaseInterface;
    }

    public void setMode(String mode) {
        format.mode = mode;
    }

    public void setTable(String table) {
        format.table = table;
    }

    public void setColumn(List<String> column) {
        format.column = column;
    }

    public void setFullColumn(List<String> fullColumn) {
        format.fullColumn = fullColumn;
    }

    public void setTypeConverter(TypeConverterInterface typeConverter ){
        format.typeConverter = typeConverter;
    }

    @Override
    protected void checkFormat() {
        if (format.username == null) {
            LOG.info("Username was not supplied separately.");
        }
        if (format.password == null) {
            LOG.info("Password was not supplied separately.");
        }
        if (format.dbURL == null) {
            throw new IllegalArgumentException("No dababase URL supplied.");
        }
        if (format.driverName == null) {
            throw new IllegalArgumentException("No driver supplied");
        }
    }

}
