/*
 * Copyright 2016 leon chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.impl.LInsertCommand;
import com.moilioncircle.redis.replicator.cmd.impl.LInsertType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class LInsertParserTest {
    @Test
    public void parse() throws Exception {
        LInsertParser parser = new LInsertParser();
        LInsertCommand cmd = parser.parse("LINSERT mylist BEFORE World There".split(" "));
        assertEquals("mylist", cmd.getKey());
        assertEquals(LInsertType.BEFORE, cmd.getlInsertType());
        assertEquals("World", cmd.getPivot());
        assertEquals("There", cmd.getValue());
        System.out.println(cmd);

        cmd = parser.parse("LINSERT mylist AFTER World There".split(" "));
        assertEquals("mylist", cmd.getKey());
        assertEquals(LInsertType.AFTER, cmd.getlInsertType());
        assertEquals("World", cmd.getPivot());
        assertEquals("There", cmd.getValue());

        System.out.println(cmd);
    }

}