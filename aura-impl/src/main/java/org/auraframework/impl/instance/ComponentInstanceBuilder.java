/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.auraframework.impl.instance;

import java.util.Map;

import org.auraframework.annotations.Annotations.ServiceComponent;
import org.auraframework.def.ComponentDef;
import org.auraframework.impl.root.component.ComponentDefImpl;
import org.auraframework.impl.root.component.ComponentImpl;
import org.auraframework.instance.Component;
import org.auraframework.instance.InstanceBuilder;
import org.auraframework.throwable.quickfix.QuickFixException;

/**
 * Provide an interface for an injectable builder of an instance.
 */
@ServiceComponent
public class ComponentInstanceBuilder implements InstanceBuilder<Component, ComponentDef> {
    /**
     * Get the class that this builder knows how to instantiate.
     */
    @Override
    public Class<?> getDefinitionClass() {
        return ComponentDefImpl.class;
    }

    /**
     * Get an instance of the given def.
     */
    @Override
    public Component getInstance(ComponentDef def, Map<String, Object> attributes) throws QuickFixException {
        return new ComponentImpl(def.getDescriptor(), attributes);
    }
}

