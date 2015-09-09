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
package com.liferay.faces.util.config;

/**
 * This interface provides a representation of a servlet entry from a web-app descriptor.
 *
 * @author  Neil Griffin
 */
public interface ConfiguredServlet {

	/**
	 * Returns the information contained in the multipart-config element of the configured servlet.
	 */
	public MultiPartConfig getMultiPartConfig();

	/**
	 * Returns the value of the servlet-class element of the configured servlet.
	 */
	public String getServletClass();

	/**
	 * Returns the value of the servlet-name element of the configured servlet.
	 */
	public String getServletName();
}
