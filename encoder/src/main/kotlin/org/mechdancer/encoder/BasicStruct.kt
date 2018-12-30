package org.mechdancer.encoder

/**
 * 基本结构
 */
enum class BasicStruct(val encode: StructDescription) {
    B(StructDescription("b", listOf())),   // 布尔
    I1(StructDescription("i1", listOf())), // 整型 1字节
    I2(StructDescription("i2", listOf())), // 整型 2字节
    I4(StructDescription("i4", listOf())), // 整型 1字节
    I8(StructDescription("i8", listOf())), // 整型 4字节
    IV(StructDescription("iv", listOf())), // 整型 变长
    U1(StructDescription("u1", listOf())), // 无符号整型 1字节
    U2(StructDescription("u2", listOf())), // 无符号整型 2字节
    U4(StructDescription("u4", listOf())), // 无符号整型 4字节
    U8(StructDescription("u8", listOf())), // 无符号整型 8字节
    UV(StructDescription("uv", listOf())), // 无符号整型 变长
    F4(StructDescription("f4", listOf())), // 实型 4字节
    F8(StructDescription("f8", listOf())), // 实型 8字节
    S(StructDescription("s", listOf()));   // 字符串
}
