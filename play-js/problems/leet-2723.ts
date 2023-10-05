type P = Promise<number>

async function addTwoPromises(promise1: P, promise2: P): P {
    return promise1.then(r1 => promise2.then(r2 => r1 + r2))
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */

export default addTwoPromises;
