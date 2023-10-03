import { describe, expect, test } from "bun:test";
import once from "./leet-2666";

describe('2666', () => {
    test('case1', () => {
        const fn = (a,b,c) => (a + b + c)
        const onceFn = once(fn)
        expect(onceFn(1,2,3)).toBe(6)
        expect(onceFn(2,3,6)).toBeUndefined()
    })

    test('case2', () => {
        const fn = (a,b,c) => (a * b * c)
        const onceFn = once(fn)
        expect(onceFn(5,7,4)).toBe(140)
        expect(onceFn(2,3,6)).toBeUndefined()
        expect(onceFn(4,6,8)).toBeUndefined()
    })
})
