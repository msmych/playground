import { describe, test, expect } from "bun:test"
import compose from "../../problems/leet-2629"

describe('2629', () => {
    test('case 1', () => {
        expect(compose([x => x + 1, x => x * x, x => 2 * x])(4)).toBe(65)
    })
    test('case 2', () => {
        expect(compose([x => 10 * x, x => 10 * x, x => 10 * x])(1)).toBe(1000)
    })
    test('case 3', () => {
        expect(compose([])(42)).toBe(42)
    })
})
