/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.backend.converters.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TimestampSqlBinding implements SqlBinding<Timestamp> {
    public static final TimestampSqlBinding INSTANCE = new TimestampSqlBinding();

    @Override
    public Timestamp get(ResultSet resultSet, int columnIndex) throws SQLException {
        Timestamp value = resultSet.getTimestamp(columnIndex);
        if (resultSet.wasNull()) {
            return null;
        }
        return value;
    }

    @Override
    public void set(PreparedStatement preparedStatement, int parameterIndex, Timestamp value) throws SQLException {
        preparedStatement.setTimestamp(parameterIndex, value);
    }
}
