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

package com.torodb.backend.derby;

import static com.torodb.backend.ErrorHandler.Context.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.torodb.backend.AbstractErrorHandler;

/**
 *
 */
@Singleton
public class DerbyErrorHandler extends AbstractErrorHandler {
    
    @Inject
    public DerbyErrorHandler() {
        super(
                rule("40001"), 
                rule("40P01"),
                /**
                 * Schema '?' already exists.
                 */
                rule("X0Y68", CREATE_SCHEMA),
                /**
                 * Table/View '?' already exists in Schema '?'.
                 * Column '?' already exists in Table/View '"?"."?"'.
                 */
                rule("X0Y32", CREATE_TABLE, ADD_COLUMN)
        );
    }
}
