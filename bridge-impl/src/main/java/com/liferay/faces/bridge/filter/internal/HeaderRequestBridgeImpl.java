/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.bridge.filter.internal;

import java.util.Map;
import javax.portlet.HeaderRequest;
import javax.portlet.PortalContext;
import javax.portlet.filter.HeaderRequestWrapper;


/**
 * @author  Neil Griffin
 */
public class HeaderRequestBridgeImpl extends HeaderRequestWrapper {

	// Private Data Members
	private PortalContext portalContext;

	public HeaderRequestBridgeImpl(HeaderRequest headerRequest, PortalContext portalContext) {
		super(headerRequest);
		this.portalContext = portalContext;
	}

	@Override
	public Object getAttribute(String name) {
		return RequestAttributeUtil.getAttribute(getRequest(), name);
	}

	@Override
	public String getParameter(String name) {
		return RequestParameterUtil.getPortlet2_0Parameter(name, this);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return RequestParameterUtil.getPortlet2_0ParameterMap(super.getParameterMap());
	}

	@Override
	public String[] getParameterValues(String name) {
		return RequestParameterUtil.getPortlet2_0ParameterValues(name, this);
	}

	@Override
	public PortalContext getPortalContext() {
		return portalContext;
	}

	@Override
	public Map<String, String[]> getPrivateParameterMap() {
		return RequestParameterUtil.getPortlet2_0ParameterMap(super.getPublicParameterMap());
	}

	@Override
	public Map<String, String[]> getPublicParameterMap() {
		return RequestParameterUtil.getPortlet2_0ParameterMap(super.getPrivateParameterMap());
	}
}
