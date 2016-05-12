/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.util.event.internal;

import java.util.EventObject;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import com.liferay.faces.util.config.ApplicationConfig;
import com.liferay.faces.util.event.PostConstructApplicationConfigEvent;


/**
 * This class isolates differences between JSF1 <> JSF 2 in order to minimize diffs across branches.
 *
 * @author  Neil Griffin
 */
public abstract class ApplicationStartupListenerCompat implements SystemEventListener {

	public abstract void processSystemEvent(EventObject systemEvent);

	public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
		processSystemEvent(systemEvent);
	}

	protected void publishEvent(Application application, FacesContext facesContext,
		ApplicationConfig applicationConfig) {

		application.publishEvent(facesContext, PostConstructApplicationConfigEvent.class, ApplicationConfig.class,
			applicationConfig);
	}

	protected String getApplicationContextPath(ExternalContext externalContext) {

		String applicationContextPath = null;

		try {
			applicationContextPath = externalContext.getRequestContextPath();
		}
		catch (UnsupportedOperationException e) {
			// MyFaces does not support this feature during startup. However, this is OK since the value is only needed
			// in a JSF 2.2 environment. For more information, see
			// ApplicationStartupListenerCompat_2_2#getApplicationContextPath(ExternalContext) and
			// ExternalContextCompat_2_2_Impl#getApplicationContxtPath()
		}

		return applicationContextPath;
	}

	public boolean isListenerForSource(Object source) {
		return ((source != null) && (source instanceof Application));
	}
}