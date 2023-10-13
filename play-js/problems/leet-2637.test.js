import { describe, expect, test } from "bun:test";
import timeLimit from "./leet-2637";

describe('2637', async () => {
    test('case1', async () => {
        const fn = async (n) => {
            await new Promise(res => setTimeout(res, 100));
            return n * n;
        };
        expect(async () => await timeLimit(fn, 50)(5)).toThrow("Time Limit Exceeded")
    })

    test('case2', async () => {
        const fn = async (n) => {
            await new Promise(res => setTimeout(res, 100));
            return n * n;
        };
        expect(await timeLimit(fn, 150)(5)).toBe(25)
    })

    test('case3', async () => {
        const fn = async (a, b) => {
            await new Promise(res => setTimeout(res, 120));
            return a + b;
        }
        expect(await timeLimit(fn, 150)(5, 10)).toBe(15)
    })

    test('case4', async () => {
        const fn = async () => {
            throw "Error";
        }
        expect(async () => await timeLimit(fn, 1000)()).toThrow("Error")
    })
})