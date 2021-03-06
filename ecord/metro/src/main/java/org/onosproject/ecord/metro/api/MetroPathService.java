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
package org.onosproject.ecord.metro.api;

import com.google.common.annotations.Beta;
import org.onlab.util.Bandwidth;
import org.onosproject.event.ListenerService;
import org.onosproject.net.ConnectPoint;
import org.onosproject.net.Link;
import org.onosproject.net.Path;

import java.time.Duration;
import java.util.List;

/**
 * Service to setup metro domain connectivity.
 */
@Beta
public interface MetroPathService extends ListenerService<MetroPathEvent, MetroPathListener> {

    /**
     * Calculates optical path between connect points and sets up connectivity.
     *
     * @param ingress   ingress port
     * @param egress    egress port
     * @param bandwidth required bandwidth. No bandwidth is assured if null.
     * @param latency   required latency. No latency is assured if null.
     * @return ID of created connectivity if successful. null otherwise.
     */
    MetroConnectivityId setupConnectivity(ConnectPoint ingress, ConnectPoint egress,
                                       Bandwidth bandwidth, Duration latency);

    /**
     * Sets up connectivity along given optical path.
     *
     * @param path      path along which connectivity will be set up
     * @param bandwidth required bandwidth. No bandwidth is assured if null.
     * @param latency   required latency. No latency is assured if null.
     * @return true if successful. false otherwise.
     */
    MetroConnectivityId setupPath(Path path, Bandwidth bandwidth, Duration latency);

    /**
     * Removes connectivity with given ID.
     *
     * @param id ID of connectivity
     * @return true if succeed. false if failed.
     */
    boolean removeConnectivity(MetroConnectivityId id);

    /**
     * Returns path assigned to given ID.
     * @param id ID of connectivity
     * @return list of link that compose a path. null if ID is invalid.
     */
    List<Link> getPath(MetroConnectivityId id);
}
