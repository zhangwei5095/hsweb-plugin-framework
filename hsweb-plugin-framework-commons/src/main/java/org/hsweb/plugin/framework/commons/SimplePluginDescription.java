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

import org.hsweb.plugin.framework.core.PluginDescription;

/**
 * @author zhouhao
 * @TODO
 */
public class SimplePluginDescription implements PluginDescription {
    private String groupId;
    private String artifactId;
    private String version;
    private String name;
    private String tag;
    private String author;
    private String comment;
    private String signature;

    public SimplePluginDescription(String groupId, String artifactId, String version, String name, String tag, String author, String comment, String signature) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.name = name;
        this.tag = tag;
        this.author = author;
        this.comment = comment;
        this.signature = signature;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public String getArtifactId() {
        return artifactId;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public String getComment() {
        return comment;
    }
}
