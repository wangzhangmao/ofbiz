/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.ofbiz.context;

import static org.ofbiz.api.authorization.BasicPermissions.Admin;

import java.security.AccessControlException;
import java.security.Permission;
import java.util.List;
import java.util.ListIterator;

import org.ofbiz.entity.AccessController;
import org.ofbiz.api.authorization.PermissionsIntersection;
import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.security.AuthorizationManager;
import org.ofbiz.security.OFBizSecurity;
import org.ofbiz.service.ExecutionContext;
import org.ofbiz.service.ServicePermission;

/**
 * An implementation of the AuthorizationManager interface that uses the OFBiz database
 * for authorization data storage.
 */
public class AuthorizationManagerImpl<E> extends OFBizSecurity implements AuthorizationManager {

    // Right now this class is being used as a test jig for the various classes
    // it will be working with. The actual implementation will occur once the
    // entities are defined and in place.

    public static final String module = AuthorizationManagerImpl.class.getName();
    
    protected Permission testPermission = null;
    protected Permission getTestPermission(ExecutionContext executionContext) {
    	if (this.testPermission == null) {
    		// Build test permissions
    		this.testPermission = new PermissionsIntersection("TestPermissions",
    				UtilMisc.toList(new ServicePermission("securityRedesignTest", executionContext),
    						Admin));
    	}
		return this.testPermission;
    }

    public AuthorizationManagerImpl() {
    }

	public void assignGroupPermission(String userGroupId, String artifactId,
			Permission permission) {
		// TODO Auto-generated method stub
		
	}

	public void assignGroupToGroup(String childGroupId, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	public void assignUserPermission(String userLoginId, String artifactId,
			Permission permission) {
		// TODO Auto-generated method stub
		
	}

	public void assignUserToGroup(String userLoginId, String userGroupId) {
		// TODO Auto-generated method stub
		
	}

	public void createUser(String userLoginId, String password) {
		// TODO Auto-generated method stub
		
	}

	public String createUserGroup(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteGroupFromGroup(String childGroupId, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteGroupPermission(String userGroupId, String artifactId,
			Permission permission) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(String userLoginId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserFromGroup(String userLoginId, String userGroupId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserGroup(String userGroupId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserPermission(String userLoginId, String artifactId,
			Permission permission) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(String userLoginId, String password) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserGroup(String userGroupId, String description) {
		// TODO Auto-generated method stub
		
	}

	public AccessController<E> getAccessController(org.ofbiz.api.context.ExecutionContext executionContext) {
		return new AccessControllerImpl<E>((ExecutionContext) executionContext, this.getTestPermission((ExecutionContext) executionContext));
	}

}
