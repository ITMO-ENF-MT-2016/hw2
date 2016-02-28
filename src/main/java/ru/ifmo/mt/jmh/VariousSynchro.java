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
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(5)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class VariousSynchro {

    @State(Scope.Thread)
    public static class StateVolatile {
        volatile long x;
    }

    @Benchmark
    @Group("volatileThread")
    public long reader(StateVolatile s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileThread")
    public void writer(StateVolatile s) {
        s.x++;
    }


    @State(Scope.Thread)
    public static class StateSynchro {
        long x;

        synchronized long getX() {
            return x;
        }

        synchronized void incX() {
            x++;
        }
    }

    @Benchmark
    @Group("synchronizedThread")
    public long reader(StateSynchro s) {
        return s.getX();
    }

    @Benchmark
    @Group("synchronizedThread")
    public void writer(StateSynchro s) {
        s.incX();
    }


    @State(Scope.Thread)
    public static class StateLock {
        long x;
        Lock lock = new ReentrantLock();

        long getX() {
            lock.lock();
            try {
                return x;
            } finally {
                lock.unlock();
            }
        }

        void incX() {
            lock.lock();
            try {
                x++;
            } finally {
                lock.unlock();
            }
        }
    }

    @Benchmark
    @Group("lockThread")
    public long reader(StateLock s) {
        return s.getX();
    }

    @Benchmark
    @Group("lockThread")
    public void writer(StateLock s) {
        s.incX();
    }

    //==========

    @State(Scope.Benchmark)
    public static class StateVolatileShared {
        volatile long x;
    }

    @Benchmark
    @Group("volatileShared")
    public long reader(StateVolatileShared s) {
        return s.x;
    }

    @Benchmark
    @Group("volatileShared")
    public void writer(StateVolatileShared s) {
        s.x++;
    }


    @State(Scope.Benchmark)
    public static class StateSynchroShared {
        long x;

        synchronized long getX() {
            return x;
        }

        synchronized void incX() {
            x++;
        }
    }

    @Benchmark
    @Group("synchronizedShared")
    public long reader(StateSynchroShared s) {
        return s.getX();
    }

    @Benchmark
    @Group("synchronizedShared")
    public void writer(StateSynchroShared s) {
        s.incX();
    }


    @State(Scope.Benchmark)
    public static class StateLockShared {
        long x;
        Lock lock = new ReentrantLock();

        long getX() {
            lock.lock();
            try {
                return x;
            } finally {
                lock.unlock();
            }
        }

        void incX() {
            lock.lock();
            try {
                x++;
            } finally {
                lock.unlock();
            }
        }
    }

    @Benchmark
    @Group("lockShared")
    public long reader(StateLockShared s) {
        return s.getX();
    }

    @Benchmark
    @Group("lockShared")
    public void writer(StateLockShared s) {
        s.incX();
    }


    //==========

    @State(Scope.Benchmark)
    public static class StateWorkLock {
        Lock lock = new ReentrantLock();

        void work() {
            lock.lock();
            try {
                Blackhole.consumeCPU(10);
            } finally {
                lock.unlock();
            }
        }
    }

    @Benchmark
    @Group("justLock")
    public void work(StateWorkLock s) {
        s.work();
    }


    @State(Scope.Benchmark)
    public static class StateWorkSynchro {
        synchronized void work() {
            Blackhole.consumeCPU(10);
        }
    }

    @Benchmark
    @Group("justSynchro")
    public void work(StateWorkSynchro s) {
        s.work();
    }

}