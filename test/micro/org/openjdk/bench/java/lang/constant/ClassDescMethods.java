/*
 * Copyright (c) 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.openjdk.bench.java.lang.constant;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.util.concurrent.TimeUnit;

/**
 * Test various operations on
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 5, time = 1)
@Fork(3)
@State(Scope.Thread)
public class ClassDescMethods {

    @Benchmark
    public String packageName() {
        return ConstantDescs.CD_Object.packageName();
    }

    @Benchmark
    public String displayName() {
        return ConstantDescs.CD_Object.displayName();
    }

    @Benchmark
    public void arrayType(Blackhole bh) {
        bh.consume(ConstantDescs.CD_Object.arrayType());
        bh.consume(ConstantDescs.CD_boolean.arrayType());
    }

    @Benchmark
    public void arrayType1(Blackhole bh) {
        bh.consume(ConstantDescs.CD_Object.arrayType(1));
        bh.consume(ConstantDescs.CD_boolean.arrayType(1));
    }

    @Benchmark
    public void arrayType2(Blackhole bh) {
        bh.consume(ConstantDescs.CD_Object.arrayType(2));
        bh.consume(ConstantDescs.CD_boolean.arrayType(2));
    }
}
