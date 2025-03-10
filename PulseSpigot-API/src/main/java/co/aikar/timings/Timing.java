/*
 * This file is licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Daniel Ennis <http://aikar.co>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.aikar.timings;

/**
 * Provides an ability to time sections of code within the Minecraft Server
 */
@Deprecated // PulseSpigot
public interface Timing extends AutoCloseable {
    /**
     * Starts timing the execution until {@link #stopTiming()} is called.
     */
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    public void startTiming();

    /**
     * <p>Stops timing and records the data. Propagates the data up to group handlers.</p>
     *
     * Will automatically be called when this Timing is used with try-with-resources
     */
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    public void stopTiming();

    /**
     * Starts timing the execution until {@link #stopTiming()} is called.
     *
     * But only if we are on the primary thread.
     */
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    public void startTimingIfSync();

    /**
     * <p>Stops timing and records the data. Propagates the data up to group handlers.</p>
     *
     * <p>Will automatically be called when this Timing is used with try-with-resources</p>
     *
     * But only if we are on the primary thread.
     */
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    public void stopTimingIfSync();

    /**
     * Stops timing and disregards current timing data.
     */
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    public void abort();

    /**
     * Used internally to get the actual backing Handler in the case of delegated Handlers
     *
     * @return TimingHandler
     */
    TimingHandler getTimingHandler();

    @Override
    @io.papermc.paper.annotation.DoNotUse // PulseSpigot
    void close();
}
