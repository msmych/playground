import { describe, expect, test } from "bun:test";
require('./leet-2631')

describe('2631', () => {
    test('case1', () => {
        const array = [
            { "id": "1" },
            { "id": "1" },
            { "id": "2" }
        ]
        const fn = function (item) {
            return item.id;
        }

        expect(array.groupBy(fn)).toEqual({
            "1": [{ "id": "1" }, { "id": "1" }],
            "2": [{ "id": "2" }]
        })
    })
    test('case2', () => {
        const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        const fn = function (n) {
            return String(n > 5);
        }

        expect(array.groupBy(fn)).toEqual({
            "true": [6, 7, 8, 9, 10],
            "false": [1, 2, 3, 4, 5]
        })
    })
    test('case3', () => {
        const array = [
            [1, 2, 3],
            [1, 3, 5],
            [1, 5, 9]
        ]
        const fn = function (list) {
            return String(list[0]);
        }

        expect(array.groupBy(fn)).toEqual({
            "1": [[1, 2, 3], [1, 3, 5], [1, 5, 9]]
        })
    })
})