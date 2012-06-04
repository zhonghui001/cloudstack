// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.network.element;

import com.cloud.deploy.DeployDestination;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.InsufficientNetworkCapacityException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.network.vpc.Vpc;
import com.cloud.vm.ReservationContext;

/**
 * @author Alena Prokharchyk
 */
public interface VpcProvider extends NetworkElement{
    /**
     * Start vpc element as specified
     * @param vpc fully specified vpc configuration.
     * @throws InsufficientNetworkCapacityException TODO
     */
    boolean implementVpc(Vpc vpc, DeployDestination dest, ReservationContext context) 
            throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException;

    /**
     * @param vpc
     * @return
     * @throws ConcurrentOperationException
     * @throws ResourceUnavailableException
     */
    boolean shutdownVpc(Vpc vpc) throws ConcurrentOperationException, ResourceUnavailableException;
    
    boolean createPrivateGateway();
        
    boolean createVpnGateway();
    
    boolean deletePrivateGateway();
        
    boolean deleteVpnGateway();
}
