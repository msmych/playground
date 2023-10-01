import { describe, expect, test } from "bun:test";
import sleep from '../../problems/leet-2621'

describe('2621', async () =>  {
    test('case1', async () => {
        const t = Date.now()

        expect(await sleep(100).then(() => Date.now() - t)).toBeGreaterThanOrEqual(100)
    })

    test('case2', async () => {
        const t = Date.now()

        expect(await sleep(200).then(() => Date.now() - t)).toBeGreaterThanOrEqual(200)
    })
})
