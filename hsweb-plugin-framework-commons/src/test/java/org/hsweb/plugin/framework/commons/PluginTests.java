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
import org.hsweb.plugin.framework.core.PluginInstaller;
import org.hsweb.plugin.framework.core.PluginService;
import org.hsweb.plugin.framework.core.PluginServiceParameter;
import org.hsweb.plugin.framework.core.parameter.ParameterWrapper;
import org.junit.Test;

/**
 * @author zhouhao
 * @TODO
 */
public class PluginTests {
    @Test
    public void testPlugin() throws Exception {
        PluginClassLoader pluginClassLoader = new PluginClassLoader();
        SimplePluginContext simplePluginContext = new SimplePluginContext(pluginClassLoader);
        PluginInstaller installer = new TestPluginInstaller(pluginClassLoader);
        //安装插件
        installer.installPlugin("org.hsweb", "plugin-test", "0.1");
        //加载插件
        Class<Plugin> pluginClass = pluginClassLoader.loadPlugin("org.hsweb", "plugin-test", "0.1");
        Plugin plugin = pluginClass.newInstance();
        plugin.init(simplePluginContext);

        //运行插件
        PluginService pluginService = plugin.start();
        Object result = pluginService.doService(var -> () -> var + "参数值");
        System.out.println(result);

        plugin.destroy();
    }
}
