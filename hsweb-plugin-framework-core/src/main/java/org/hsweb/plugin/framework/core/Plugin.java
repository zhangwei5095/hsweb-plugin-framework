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

package org.hsweb.plugin.framework.core;

import org.hsweb.plugin.framework.core.exception.PluginException;

/**
 * 核心插件接口,实现此接口以进行插件开发
 *
 * @author zhouhao
 */
public interface Plugin {

    /**
     * 获取插件描述
     *
     * @return {@link PluginDescription}
     */
    PluginDescription getDescription();

    /**
     * 初始化插件,在插件被加载后调用
     *
     * @param context 插件上下文，插件内部可调用执行其他工作
     */
    void init(PluginContext context) throws PluginException;

    /**
     * 销毁插件
     */
    void destroy() throws PluginException;

    /**
     * 插件开始服务，调用此方法后，插件将开始进行工作，并返回{@link PluginService}服务类进行功能服务
     *
     * @return
     */
    <T extends PluginService> T start() throws PluginException;

    /**
     * 停止插件服务
     *
     * @return
     */
    int stop() throws PluginException;
}
