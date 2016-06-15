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
package com.liferay.faces.util.jsp;

import javax.el.ELContext;
import javax.faces.FacesWrapper;
import javax.servlet.jsp.PageContext;

import com.liferay.faces.util.factory.FactoryExtensionFinder;


/**
 * This factory provides methods for creating a JavaServer Pages (JSP) {@link PageContext} which outputs content to a
 * {@link String}. This provides the ability to run the lifecycle of a JSP tag so that the JSP tag markup is captured in
 * a String rather than written as output from a JSP.
 *
 * @author  Kyle Stiemann
 */
public abstract class PageContextFactory implements FacesWrapper<PageContextFactory> {

	/**
	 * Returns an instance of {@link PageContext} from the {@link PageContextFactory} found by the {@link
	 * FactoryExtensionFinder}.
	 */
	public static PageContext getStringPageContextInstance(ELContext elContext, PageContext pageContext) {

		PageContextFactory stringPageContextFactory = (PageContextFactory) FactoryExtensionFinder.getFactory(
				PageContextFactory.class);

		return stringPageContextFactory.getStringPageContext(elContext, pageContext);
	}

	/**
	 * Returns an instance of {@link PageContext} which renders tag output to a String. Pass the {@link PageContext} to
	 * {@link javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.PageContext)} before calling {@link
	 * javax.servlet.jsp.tagext.Tag#doStartTag()} or similar methods to render tag output to a String. Call {@link
	 * PageContext#getOut()#toString()} to obtain the tag output as a string.
	 *
	 * @param  elContext    The {@link ELContext} associated with the current {@link javax.faces.context.FacesContext}.
	 * @param  pageContext  The {@link PageContext} on with the String page context is going to be created
	 */
	public abstract PageContext getStringPageContext(ELContext elContext, PageContext pageContext);
}
