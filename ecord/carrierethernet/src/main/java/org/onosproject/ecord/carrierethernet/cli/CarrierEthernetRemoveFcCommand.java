/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.ecord.carrierethernet.cli;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.ecord.carrierethernet.app.CarrierEthernetManager;

/**
 * CLI command for removing an installed Carrier Ethernet Forwarding Construct.
 */
@Command(scope = "onos", name = "ce-fc-remove",
        description = "Carrier Ethernet service removal command.")
public class CarrierEthernetRemoveFcCommand extends AbstractShellCommand {

    @Argument(index = 0, name = "argFcId", description = "Forwarding Construct ID", required = true, multiValued = false)
    String argFcId = null;

    @Override
    protected void execute() {
        CarrierEthernetManager ceManager = get(CarrierEthernetManager.class);
        ceManager.removeFc(argFcId);
    }
}
