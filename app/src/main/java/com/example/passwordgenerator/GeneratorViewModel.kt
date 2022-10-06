package com.example.passwordgenerator

import androidx.lifecycle.ViewModel

class GeneratorViewModel : ViewModel() {
    private val lowerCase = "abcdefghijklmnopqrstuvwxyz"
    private val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val numbers = "0123456789"
    private val symbols = "!&#*^@%"

    fun generate(
        lowerCase: Boolean,
        upperCase: Boolean,
        numbers: Boolean,
        symbols: Boolean,
        length: Int
    ): String {
        var possibleLetters = ""
        while (possibleLetters.length < length) {
            if (lowerCase) possibleLetters += this.lowerCase.getRandomLetters((1..10).random())
            if (upperCase) possibleLetters += this.upperCase.getRandomLetters((1..10).random())
            if (numbers) possibleLetters += this.numbers.getRandomLetters((1..10).random())
            if (symbols) possibleLetters += this.symbols.getRandomLetters((1..10).random())
        }
        return possibleLetters.getRandomLetters(length)
    }

    fun checkIfCopyIsEnable(
        password: String
    ): Boolean = password.isNotEmpty()

    fun checkIfGenerateIsEnable(
        lowerCase: Boolean,
        upperCase: Boolean,
        numbers: Boolean,
        symbols: Boolean,
        length: Int
    ): Boolean = length > Constants.minLength && (lowerCase || upperCase || numbers || symbols)

    private fun String.getRandomLetters(
        length: Int
    ): String = this.toList()
        .shuffled()
        .take(length)
        .joinToString()
        .replace(", ", "")
        .trim()
}