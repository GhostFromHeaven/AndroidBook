package com.gfh.kotlin

import org.apache.commons.codec.binary.Hex
import org.junit.Test
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class TestAes {
    private val IV = "0123456789abcdef".toByteArray()

    private fun getKey(): Key {
        val generator = KeyGenerator.getInstance("AES")
        generator.init(128)
        return generator.generateKey()
    }

    private fun encrypt(data: ByteArray, key: Key, transformation: String): ByteArray {
        val cipher = Cipher.getInstance(transformation)
        key.encoded
        cipher.init(Cipher.ENCRYPT_MODE, key, IvParameterSpec(IV))
        return cipher.doFinal(data)
    }

    private fun decrypt(data: ByteArray, key: Key, transformation: String): ByteArray {
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(IV))
        return cipher.doFinal(data)
    }

    private fun testAes(src: String, transformation: String) {
        val data = src.toByteArray()
        println("data = ${Hex.encodeHexString(data)}, size = ${data.size}")

        val key = getKey()
        val pass = key.encoded
        println("pass = ${Hex.encodeHexString(pass)}, size = ${pass.size}")

        // javax.crypto.IllegalBlockSizeException: Input length not multiple of 16 bytes
        val en = encrypt(data, key, transformation)
        println("en = ${Hex.encodeHexString(en)}, size = ${en.size}")

        val de = decrypt(en, key, transformation)
        println("de = ${Hex.encodeHexString(de)}, size = ${de.size}")

        val de2 = decrypt(en, SecretKeySpec(pass, "AES"), transformation)
        println("de2 = ${Hex.encodeHexString(de)}, size = ${de2.size}")
    }

    @Test
    fun testCbcNoPadding01() {
        testAes("0123", "AES/CBC/NoPadding")
    }

    @Test
    fun testCbcNoPadding02() {
        testAes("0123456789abcdef", "AES/CBC/NoPadding")
    }

    @Test
    fun testCbcPKCS5Padding01() {
        testAes("0123", "AES/CBC/PKCS5Padding")
    }

    @Test
    fun testCbcPKCS5Padding02() {
        testAes("0123456789abcdef", "AES/CBC/PKCS5Padding")
    }

    @Test
    fun testCfbNoPadding01() {
        testAes("0123", "AES/CFB/NoPadding")
    }

    @Test
    fun testCfbNoPadding02() {
        testAes("0123456789abcdef", "AES/CFB/NoPadding")
    }

    @Test
    fun testCfbPKCS5Padding01() {
        testAes("0123", "AES/CFB/PKCS5Padding")
    }

    @Test
    fun testCfbPKCS5Padding02() {
        testAes("0123456789abcdef", "AES/CFB/PKCS5Padding")
    }
}

/**
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
            <version>1.12</version>
        </dependency>
*/
