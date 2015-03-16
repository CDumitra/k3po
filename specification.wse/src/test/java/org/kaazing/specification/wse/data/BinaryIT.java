/*
 * Copyright 2014, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaazing.specification.wse.data;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class BinaryIT {

    private final K3poRule k3po = new K3poRule()
            .setScriptRoot("org/kaazing/specification/wse/data/binary");

    private final TestRule timeout = new DisableOnDebug(
            new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "echo.payload.length.0/request",
        "echo.payload.length.0/response" })
    public void shouldEchoFrameWithPayloadLength0() throws Exception {
        k3po.join();
    }

    @Test
    @Specification({
        "echo.payload.length.127/request",
        "echo.payload.length.127/response" })
    public void shouldEchoFrameWithPayloadLength127() throws Exception {
        k3po.join();
    }

    @Test
    @Specification({
        "echo.payload.length.128/request",
        "echo.payload.length.128/response" })
    public void shouldEchoFrameWithPayloadLength128() throws Exception {
        k3po.join();
    }

    @Test
    @Specification({
        "echo.payload.length.65535/request",
        "echo.payload.length.65535/response" })
    public void shouldEchoFrameWithPayloadLength65535() throws Exception {
        k3po.join();
    }

    @Test
    @Specification({
        "echo.payload.length.65536/request",
        "echo.payload.length.65536/response" })
    public void shouldEchoFrameWithPayloadLength65536() throws Exception {
        k3po.join();
    }
}
