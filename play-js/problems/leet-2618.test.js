import { describe, expect, test } from "bun:test"
import checkIfInstanceOf from "./leet-2618";

describe('2618', () => {
    test('new Date() is instance of Date', () => {
        expect(checkIfInstanceOf(new Date(), Date)).toBe(true)
    })

    test('Dog is instance of Animal', () => {
        class Animal { };
        class Dog extends Animal { };
        expect(checkIfInstanceOf(new Dog(), Animal)).toBe(true)
    })

    test('Date is not instance Date', () => {
        expect(checkIfInstanceOf(Date, Date)).toBe(false)
    })

    test('5 is instance of Number', () => {
        expect(checkIfInstanceOf(5, Number)).toBe(true)
    })

    test('case5', () => {
        expect(checkIfInstanceOf(5n, Object)).toBe(true)
    })

    test('case6', () => {
        expect(checkIfInstanceOf(Number.NaN, Number)).toBe(true)
    })

    test('case7', () => {
        expect(checkIfInstanceOf([], null)).toBe(false)
    })

    test('case8', () => {
        expect(checkIfInstanceOf([], [])).toBe(false)
    })
})
