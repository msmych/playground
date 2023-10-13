import { describe, expect, test } from "bun:test";
import TimeLimitedCache from "./leet-2622";

describe('2622', async () => {
    test('case1', async () => {
        const tlc = new TimeLimitedCache()

        expect(tlc.set(1, 42, 100)).toBeFalse()

        await new Promise(res => setTimeout(res, 50))

        expect(tlc.get(1)).toBe(42)

        expect(tlc.count()).toBe(1)

        await new Promise(res => setTimeout(res, 100))

        expect(tlc.get(1)).toBe(-1);
    })
})