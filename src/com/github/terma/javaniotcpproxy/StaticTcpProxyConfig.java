/*
Copyright 2012 Artem Stasuk

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.github.terma.javaniotcpproxy;

/**
 * TCP proxy configuration.
 */
public class StaticTcpProxyConfig implements TcpProxyConfig {

    private final int localPort;
    private final String remoteHost;
    private final int remotePort;
    private final String logPath;
    private final boolean logRequest;
    private final boolean logResponse;
    private int workerCount;

    public StaticTcpProxyConfig(int localPort, String remoteHost, int remotePort) {
        this(localPort, remoteHost, remotePort, null, false, false, 0);
    }

    public StaticTcpProxyConfig(int localPort, String remoteHost, int remotePort, String logPath, boolean logRequest, boolean logResponse) {
        this(localPort, remoteHost, remotePort, logPath, logRequest, logResponse, 0);
    }

    public StaticTcpProxyConfig(int localPort, String remoteHost, int remotePort, String logPath, boolean logRequest, boolean logResponse, int workerCount) {
        this.localPort = localPort;
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
        this.logPath = logPath;
        this.logRequest = logRequest;
        this.logResponse = logResponse;
        this.workerCount = workerCount;
    }

    /**
     * @return - local port which TCP proxy will be listening, should be 0..64000
     */
    @Override
    public int getLocalPort() {
        return localPort;
    }

    /**
     * @return - remote port on which TCP proxy will send all traffic from incoming
     *         connections
     */
    @Override
    public int getRemotePort() {
        return remotePort;
    }

    /**
     * @return - remote host on which TCP proxy will send all traffic from incoming
     *         connections
     */
    @Override
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     * @return - count of worker (thread) which TCP proxy will use for processing
     *         incoming client connection, should more 0
     */
    @Override
    public int getWorkerCount() {
        return workerCount;
    }

    @Override
    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    @Override
    public String getLogPath() {
        return logPath;
    }

    @Override
    public boolean logRequest() {
        return logRequest;
    }

    @Override
    public boolean logResponse() {
        return logResponse;
    }

}
