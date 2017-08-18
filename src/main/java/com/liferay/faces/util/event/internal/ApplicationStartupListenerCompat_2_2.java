/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
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

import javax.faces.context.ExternalContext;


/**
 * This class provides a compatibility layer that isolates differences related to JSF 2.2.
 *
 * @author  Neil Griffin
 */
public abstract class ApplicationStartupListenerCompat_2_2 extends ApplicationStartupListenerCompat {

	/**
	 * This method is only needed in a JSF 2.2 environment so the return value isn't particularly meaningful in a JSF
	 * 2.1 environment.
	 */
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
}
