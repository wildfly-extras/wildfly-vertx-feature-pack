/*
 * Copyright (C) 2020 RedHat
 *
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
 */
package org.wildfly.extension.vertx;

import static org.wildfly.extension.vertx.AbstractVertxOptionsResourceDefinition.VERTX_OPTIONS_CAPABILITY;

import java.util.ArrayList;
import java.util.List;

import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.operations.validation.ModelTypeValidator;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

public abstract class VertxAttributes {

    public static final SimpleAttributeDefinition OPTION_NAME = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_OPTION_NAME, ModelType.STRING)
        .setRequired(false)
        .setAllowExpression(true)
        .setCapabilityReference(VERTX_OPTIONS_CAPABILITY.getName())
        .setRestartAllServices()
        .build();

    public static final SimpleAttributeDefinition CLUSTERED = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_CLUSTERED, ModelType.BOOLEAN)
      .setRequired(false)
      .setAllowExpression(true)
      .setRestartAllServices()
      .setValidator(new ModelTypeValidator(ModelType.BOOLEAN, true))
      .setDefaultValue(ModelNode.FALSE)
      .build();

    public static final SimpleAttributeDefinition JGROUPS_CHANNEL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_JGROUPS_CHANNEL, ModelType.STRING)
      .setRequired(false)
      .setAllowExpression(true)
      .setRestartAllServices()
      .setValidator(new ModelTypeValidator(ModelType.STRING, true))
      .build();

    public static final SimpleAttributeDefinition FORKED_CHANNEL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_FORKED_CHANNEL, ModelType.BOOLEAN)
      .setRequired(false)
      .setAllowExpression(true)
      .setRestartAllServices()
      .setValidator(new ModelTypeValidator(ModelType.BOOLEAN, true))
      .setDefaultValue(ModelNode.FALSE)
      .build();

    public static final SimpleAttributeDefinition JGROUPS_STACK_FILE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_JGROUPS_STACK_FILE, ModelType.STRING)
      .setRequired(false)
      .setAllowExpression(true)
      .setRestartAllServices()
      .setValidator(new ModelTypeValidator(ModelType.STRING, true))
      .build();

    private static final List<AttributeDefinition> ATTRS = new ArrayList<>();
    static {
        ATTRS.add(OPTION_NAME);
        ATTRS.add(CLUSTERED);
        ATTRS.add(JGROUPS_CHANNEL);
        ATTRS.add(FORKED_CHANNEL);
        ATTRS.add(JGROUPS_STACK_FILE);
    }

    static List<AttributeDefinition> getSimpleAttributes() {
        return ATTRS;
    }

}
