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

package org.hsweb.plugin.framework.commons;

import org.hsweb.commons.ClassUtils;
import org.hsweb.plugin.framework.core.Plugin;
import org.hsweb.plugin.framework.core.PluginLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @TODO
 */
public class PluginClassLoader implements PluginLoader {
    private ClassLoader loader;

    public PluginClassLoader() {
        loader = this.getClass().getClassLoader();
    }

    public PluginClassLoader(ClassLoader loader) {
        this.loader = loader;
    }

    private Map<String, String> plugin2class = new HashMap<>();

    public void addMapping(String groupId, String artifactId, String version, String className) {
        String key = groupId.concat(artifactId).concat(version);
        plugin2class.put(key, className);
    }

    @Override
    public Class<Plugin> loadPlugin(String groupId, String artifactId, String version) {
        String key = groupId.concat(artifactId).concat(version);
        String className = plugin2class.get(key);
        try {
            Class pluginClass = loader.loadClass(className);
            if (ClassUtils.instanceOf(pluginClass, Plugin.class)) {
                return pluginClass;
            }
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

}
