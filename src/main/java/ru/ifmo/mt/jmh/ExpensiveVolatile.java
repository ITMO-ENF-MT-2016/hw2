/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package ru.ifmo.mt.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(5)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class ExpensiveVolatile {

    @State(Scope.Thread)
    public static class StateInt {
        int x;
    }

    @Benchmark
    @Group("justIntThread")
    public int reader(StateInt s) {
        return s.x;
    }

    @Benchmark
    @Group("justIntThread")
    public void writer(StateInt s) {
        s.x++;
    }


    @State(Scope.Thread)
    public static class StateVolatileInt {
        volatile int x;
    }

    @Benchmark
    @Group("volatileIntThread")
    public int reader(StateVolatileInt s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileIntThread")
    public void writer(StateVolatileInt s) {
        s.x++;
    }


    //=============


    @State(Scope.Benchmark)
    public static class StateIntShared {
        int x;
    }

    @Benchmark
    @Group("justIntShared")
    public int reader(StateIntShared s) {
        return s.x;
    }

    @Benchmark
    @Group("justIntShared")
    public void writer(StateIntShared s) {
        s.x++;
    }


    @State(Scope.Benchmark)
    public static class StateVolatileIntShared {
        volatile int x;
    }

    @Benchmark
    @Group("volatileIntShared")
    public int reader(StateVolatileIntShared s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileIntShared")
    public void writer(StateVolatileIntShared s) {
        s.x++;
    }

    //=============

    @State(Scope.Thread)
    public static class StateLong {
        long x;
    }

    @Benchmark
    @Group("justLongThread")
    public long reader(StateLong s) {
        return s.x;
    }

    @Benchmark
    @Group("justLongThread")
    public void writer(StateLong s) {
        s.x++;
    }


    @State(Scope.Thread)
    public static class StateVolatileLong {
        volatile long x;
    }

    @Benchmark
    @Group("volatileLongThread")
    public long reader(StateVolatileLong s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileLongThread")
    public void writer(StateVolatileLong s) {
        s.x++;
    }


    //=============


    @State(Scope.Benchmark)
    public static class StateLongShared {
        long x;
    }

    @Benchmark
    @Group("justLongShared")
    public long reader(StateLongShared s) {
        return s.x;
    }

    @Benchmark
    @Group("justLongShared")
    public void writer(StateLongShared s) {
        s.x++;
    }


    @State(Scope.Benchmark)
    public static class StateVolatileLongShared {
        volatile long x;
    }

    @Benchmark
    @Group("volatileLongShared")
    public long reader(StateVolatileLongShared s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileLongShared")
    public void writer(StateVolatileLongShared s) {
        s.x++;
    }

}