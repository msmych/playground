import { describe, expect, test } from "bun:test";
import createHelloWorld from "./leet-2667" 

describe('2667', () => {
    test('case1', () => {
        expect(createHelloWorld([])()).toBe("Hello World")
    })

    test('case2', () => {
        expect(createHelloWorld([{},null,42])()).toBe("Hello World")
    })
})
