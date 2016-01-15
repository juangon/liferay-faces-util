/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.util.application;

import java.util.Map;

import javax.faces.FacesWrapper;
import javax.faces.component.UIComponent;


/**
 * Provides a simple implementation of {@link ResourceDependencyVerifier} that can be subclassed in order to decorate
 * another instance of the same type.
 *
 * @author  Kyle Stiemann
 */
public abstract class ResourceDependencyVerifierWrapper implements ResourceDependencyVerifier,
	FacesWrapper<ResourceDependencyVerifier> {

	protected static String getResourceDependencyId(UIComponent componentResource) {

		String library = null;
		String name = null;

		if (componentResource != null) {

			Map<String, Object> componentResourceAttributes = componentResource.getAttributes();
			library = (String) componentResourceAttributes.get("library");
			name = (String) componentResourceAttributes.get("name");
		}

		return getResourceDependencyId(library, name);
	}

	protected static String getResourceDependencyId(String library, String name) {

		String resourceDependencyId;

		if (library == null) {
			resourceDependencyId = name;
		}
		else if (name == null) {
			resourceDependencyId = library;
		}
		else {
			resourceDependencyId = library + ":" + name;
		}

		return resourceDependencyId;
	}

	/**
	 * @see  {@link ResourceDependencyVerifier#isResourceDependencySatisfied(UIComponent)}
	 */
	@Override
	public boolean isResourceDependencySatisfied(UIComponent componentResource) {
		return getWrapped().isResourceDependencySatisfied(componentResource);
	}
}
