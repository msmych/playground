import { describe, expect, test } from "bun:test";
import addTwoPromises from "./leet-2723";

describe('2723', async () => {
    test('case1', async () => {
        const promise1: Promise<number> = new Promise(resolve => setTimeout(() => resolve(2), 20))
        const promise2: Promise<number> = new Promise(resolve => setTimeout(() => resolve(5), 60))

        expect(await addTwoPromises(promise1, promise2)).toBe(7)
    })

    test('case2', async () => {
        const promise1: Promise<number> = new Promise(resolve => setTimeout(() => resolve(10), 50))
        const promise2: Promise<number> = new Promise(resolve => setTimeout(() => resolve(-12), 30))

        expect(await addTwoPromises(promise1, promise2)).toBe(-2)
    })
})
