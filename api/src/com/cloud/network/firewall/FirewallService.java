// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.firewall;

import java.util.List;

import org.apache.cloudstack.api.command.user.firewall.ListFirewallRulesCmd;

import com.cloud.exception.NetworkRuleConflictException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.network.rules.FirewallRule;
import com.cloud.user.Account;
import com.cloud.utils.Pair;

public interface FirewallService {
    FirewallRule createIngressFirewallRule(FirewallRule rule) throws NetworkRuleConflictException;

    FirewallRule createEgressFirewallRule(FirewallRule rule) throws NetworkRuleConflictException;

    Pair<List<? extends FirewallRule>, Integer> listFirewallRules(ListFirewallRulesCmd cmd);

    /**
     * Revokes a firewall rule
     *
     * @param ruleId
     *            the id of the rule to revoke.
     * @return
     */
    boolean revokeIngressFirewallRule(long ruleId, boolean apply);
    boolean revokeEgressFirewallRule(long ruleId, boolean apply);

    boolean applyEgressFirewallRules(FirewallRule rule, Account caller) throws ResourceUnavailableException;

    boolean applyIngressFirewallRules(long ipId, Account caller) throws ResourceUnavailableException;

    FirewallRule getFirewallRule(long ruleId);

    boolean revokeRelatedFirewallRule(long ruleId, boolean apply);

    FirewallRule updateIngressFirewallRule(long ruleId, String customId, Boolean forDisplay);
    FirewallRule updateEgressFirewallRule(long ruleId, String customId, Boolean forDisplay);

    boolean applyIngressFwRules(long ipId, Account caller) throws ResourceUnavailableException;
    boolean revokeIngressFwRule(long ruleId, boolean apply);
}
