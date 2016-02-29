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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(5)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
public class VariousMaps {

    @State(Scope.Benchmark)
    public static class StateCSLM0 {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};
    }

    @Benchmark
    @Group("CSLM0")
    public boolean containsKey(StateCSLM0 s) {
        return s.map.containsKey(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("CSLM0")
    public String get(StateCSLM0 s) {
        return s.map.get(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("CSLM0")
    public String put(StateCSLM0 s) {
        return s.map.put(s.r.nextInt(s.strings.length), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("CSLM0")
    public String remove(StateCSLM0 s) {
        return s.map.remove(s.r.nextInt(s.strings.length));
    }

    @State(Scope.Benchmark)
    public static class StateCSLM1000 {
        public static final int N = 1000;
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};

        {
            for (int i = 0; i < N; i++) {
                map.put(i, strings[r.nextInt(strings.length)]);
            }
        }
    }

    @Benchmark
    @Group("CSLM1000")
    public boolean containsKey(StateCSLM1000 s) {
        return s.map.containsKey(s.r.nextInt(StateCSLM1000.N));
    }

    @Benchmark
    @Group("CSLM1000")
    public String get(StateCSLM1000 s) {
        return s.map.get(s.r.nextInt(StateCSLM1000.N));
    }

    @Benchmark
    @Group("CSLM1000")
    public String put(StateCSLM1000 s) {
        return s.map.put(s.r.nextInt(StateCSLM1000.N), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("CSLM1000")
    public String remove(StateCSLM1000 s) {
        return s.map.remove(s.r.nextInt(StateCSLM1000.N));
    }

    //==========

    @State(Scope.Benchmark)
    public static class StateCHM0 {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};
    }

    @Benchmark
    @Group("CHM0")
    public boolean containsKey(StateCHM0 s) {
        return s.map.containsKey(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("CHM0")
    public String get(StateCHM0 s) {
        return s.map.get(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("CHM0")
    public String put(StateCHM0 s) {
        return s.map.put(s.r.nextInt(s.strings.length), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("CHM0")
    public String remove(StateCHM0 s) {
        return s.map.remove(s.r.nextInt(s.strings.length));
    }

    @State(Scope.Benchmark)
    public static class StateCHM1000 {
        public static final int N = 1000;
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};

        {
            for (int i = 0; i < N; i++) {
                map.put(i, strings[r.nextInt(strings.length)]);
            }
        }
    }

    @Benchmark
    @Group("CHM1000")
    public boolean containsKey(StateCHM1000 s) {
        return s.map.containsKey(s.r.nextInt(StateCHM1000.N));
    }

    @Benchmark
    @Group("CHM1000")
    public String get(StateCHM1000 s) {
        return s.map.get(s.r.nextInt(StateCHM1000.N));
    }

    @Benchmark
    @Group("CHM1000")
    public String put(StateCHM1000 s) {
        return s.map.put(s.r.nextInt(StateCHM1000.N), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("CHM1000")
    public String remove(StateCHM1000 s) {
        return s.map.remove(s.r.nextInt(StateCHM1000.N));
    }

    //==========

    @State(Scope.Benchmark)
    public static class StateSM0 {
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};
    }

    @Benchmark
    @Group("SM0")
    public boolean containsKey(StateSM0 s) {
        return s.map.containsKey(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("SM0")
    public String get(StateSM0 s) {
        return s.map.get(s.r.nextInt(s.strings.length));
    }

    @Benchmark
    @Group("SM0")
    public String put(StateSM0 s) {
        return s.map.put(s.r.nextInt(s.strings.length), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("SM0")
    public String remove(StateSM0 s) {
        return s.map.remove(s.r.nextInt(s.strings.length));
    }

    @State(Scope.Benchmark)
    public static class StateSM1000 {
        public static final int N = 1000;
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
        Random r = new Random();
        String[] strings = {"A", "BC", "DEF", "GHIJ", "KLMNO", "PQRSTU", "VWXYZ",
                "a", "aba", "abacaba", "abacabadabacaba", "abacabadabacabaeabacabadabacaba"};

        {
            for (int i = 0; i < N; i++) {
                map.put(i, strings[r.nextInt(strings.length)]);
            }
        }
    }

    @Benchmark
    @Group("SM1000")
    public boolean containsKey(StateSM1000 s) {
        return s.map.containsKey(s.r.nextInt(StateSM1000.N));
    }

    @Benchmark
    @Group("SM1000")
    public String get(StateSM1000 s) {
        return s.map.get(s.r.nextInt(StateSM1000.N));
    }

    @Benchmark
    @Group("SM1000")
    public String put(StateSM1000 s) {
        return s.map.put(s.r.nextInt(StateSM1000.N), s.strings[s.r.nextInt(s.strings.length)]);
    }

    @Benchmark
    @Group("SM1000")
    public String remove(StateSM1000 s) {
        return s.map.remove(s.r.nextInt(StateSM1000.N));
    }
}
