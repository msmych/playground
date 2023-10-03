import { describe, expect, test } from "bun:test";
import argumentsLength from "./leet-2703";

describe('2703', () => {
    test('case1', () => {
        expect(argumentsLength(5)).toBe(1)
    })

    test('case2', () => {
        expect(argumentsLength({}, null, "3")).toBe(3)
    })
})
