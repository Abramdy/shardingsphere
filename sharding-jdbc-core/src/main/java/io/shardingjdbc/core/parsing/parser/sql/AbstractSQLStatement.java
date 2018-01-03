/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.core.parsing.parser.sql;

import io.shardingjdbc.core.constant.SQLType;
import io.shardingjdbc.core.parsing.parser.context.condition.Conditions;
import io.shardingjdbc.core.parsing.parser.context.table.Tables;
import io.shardingjdbc.core.parsing.parser.token.SQLToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * SQL statement abstract class.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
@Getter
@ToString
public abstract class AbstractSQLStatement implements SQLStatement {
    
    private final SQLType type;
    
    private final Tables tables = new Tables();
    
    private final Conditions conditions = new Conditions();
    
    private final List<SQLToken> sqlTokens = new LinkedList<>();
    
    @Setter
    private int parametersIndex;
    
    @Override
    public final SQLType getType() {
        return type;
    }
    
    @Override
    public int increaseParametersIndex() {
        return ++parametersIndex;
    }
}
