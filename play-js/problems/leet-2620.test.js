import { describe, expect, test } from "bun:test";
import createCounter from "./leet-2620";

describe('2620', () => {
    test('case1', () => {
        const counter = createCounter(10)

        expect(counter()).toBe(10)
        expect(counter()).toBe(11)
        expect(counter()).toBe(12)
    })

    test('case2', () => {
        const counter = createCounter(-2)

        expect(counter()).toBe(-2)
        expect(counter()).toBe(-1)
        expect(counter()).toBe(0)
        expect(counter()).toBe(1)
        expect(counter()).toBe(2)
    })
})
