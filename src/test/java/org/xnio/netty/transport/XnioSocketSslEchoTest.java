/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */
package org.xnio.netty.transport;

import java.util.List;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.SslContext;
import io.netty.testsuite.transport.TestsuitePermutation;
import io.netty.testsuite.transport.socket.SocketSslEchoTest;

/**
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 * @author Flavia Rainone
 */
public class XnioSocketSslEchoTest extends SocketSslEchoTest {
    public XnioSocketSslEchoTest(
    		SslContext serverCtx, SslContext clientCtx, Renegotiation renegotiation,
            boolean serverUsesDelegatedTaskExecutor, boolean clientUsesDelegatedTaskExecutor,
            boolean autoRead, boolean useChunkedWriteHandler, boolean useCompositeByteBuf) {
        super(serverCtx, clientCtx, renegotiation, serverUsesDelegatedTaskExecutor, clientUsesDelegatedTaskExecutor,
        		autoRead, useChunkedWriteHandler, useCompositeByteBuf);
    }

    @Override
    protected List<ByteBufAllocator> newAllocators() {
        return XnioTestsuiteUtils.newAllocators(super.newAllocators());
    }

    @Override
    protected List<TestsuitePermutation.BootstrapComboFactory<ServerBootstrap, Bootstrap>> newFactories() {
        return XnioTestsuiteUtils.newFactories();
    }
}
