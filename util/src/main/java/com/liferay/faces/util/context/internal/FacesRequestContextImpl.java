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
package com.liferay.faces.util.context.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.faces.util.client.Script;
import com.liferay.faces.util.client.ScriptFactory;
import com.liferay.faces.util.context.FacesRequestContext;
import com.liferay.faces.util.factory.FactoryExtensionFinder;


/**
 * @author  Kyle Stiemann
 */
public class FacesRequestContextImpl extends FacesRequestContext {

	// Private Members
	private List<Script> scripts;

	public FacesRequestContextImpl() {
		scripts = new ArrayList<Script>();
	}

	@Override
	public void addScript(Script script) {
		scripts.add(script);
	}

	@Override
	public void addScript(String script) {

		ScriptFactory scriptFactory = (ScriptFactory) FactoryExtensionFinder.getFactory(ScriptFactory.class);
		scripts.add(scriptFactory.getScript(script));
	}

	@Override
	public void release() {
		scripts = null;
	}

	@Override
	public List<Script> getScripts() {
		return Collections.unmodifiableList(scripts);
	}
}