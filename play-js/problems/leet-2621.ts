async function sleep(millis: number): Promise<void> {
    return new Promise(f => setTimeout(f, millis))
}


/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */

export default sleep;
