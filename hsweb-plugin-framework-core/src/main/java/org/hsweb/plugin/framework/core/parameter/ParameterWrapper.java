/*
 * Copyright 2015-2016 http://hsweb.me
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.hsweb.plugin.framework.core.parameter;

import org.hsweb.commons.StringUtils;

/**
 * @author zhouhao
 * @TODO
 */
public interface ParameterWrapper {
    Object get();

    default Object get(Object defaultValue) {
        if (get() == null) return defaultValue;
        else return get();
    }

    default boolean isTrue() {
        return StringUtils.isTrue(get());
    }

    default boolean isNull() {
        return null == get();
    }

    default boolean isEmpty() {
        if (isNull()) return false;
        return "".equals(get());
    }

    default boolean isNullOrEmpty() {
        return isNull() || isEmpty();
    }

    default String stringValue() {
        Object val = get();
        return val == null ? null : val.toString();
    }

    default int intValue() {
        return StringUtils.toInt(get());
    }

    default double doubleValue() {
        return StringUtils.toDouble(get());
    }

    default double longValue() {
        return StringUtils.toLong(get());
    }


}
