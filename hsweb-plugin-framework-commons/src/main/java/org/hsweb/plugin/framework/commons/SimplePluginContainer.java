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

import org.hsweb.plugin.framework.core.Plugin;
import org.hsweb.plugin.framework.core.PluginContainer;
import org.hsweb.plugin.framework.core.PluginDescription;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhouhao
 * @TODO
 */
public class SimplePluginContainer implements PluginContainer {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String, Plugin> pluginMap = new LinkedHashMap<>();

    @Override
    public <T extends Plugin> T getPlugin(String group, String artifactId, String version) {
        readWriteLock.readLock().lock();
        try {
            return (T) pluginMap.get(getKey(group, artifactId, version));
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public <T extends Plugin> T putPlugin(T plugin) {
        readWriteLock.writeLock().lock();
        try {
            PluginDescription description = plugin.getDescription();
            return (T) pluginMap.put(getKey(description.getGroupId(), description.getArtifactId(), description.getVersion()), plugin);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    private String getKey(String group, String artifactId, String version) {
        return group.concat(artifactId).concat(version);
    }
}
