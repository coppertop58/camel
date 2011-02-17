/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jasypt;

import junit.framework.TestCase;

/**
 * @version 
 */
public class JasyptPropertiesParserTest extends TestCase {

    public void testJasyptPropertiesParser() throws Exception {
        JasyptPropertiesParser parser = new JasyptPropertiesParser();
        parser.setPassword("secret");

        assertEquals("foo", parser.parsePropertyValue("foo"));
        assertEquals("tiger", parser.parsePropertyValue("ENC(bsW9uV37gQ0QHFu7KO03Ww==)"));
    }

    public void testJasyptPropertiesParserSys() throws Exception {
        System.setProperty("myfoo", "secret");

        JasyptPropertiesParser parser = new JasyptPropertiesParser();
        parser.setPassword("sys:myfoo");

        assertEquals("foo", parser.parsePropertyValue("foo"));
        assertEquals("tiger", parser.parsePropertyValue("ENC(bsW9uV37gQ0QHFu7KO03Ww==)"));

        System.clearProperty("myfoo");
    }

}
