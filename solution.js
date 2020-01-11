'use strict';
const {existsSync, mkdirSync, writeFileSync} = require('fs');

class JavaSolution {

    constructor(signature) {
        this.signature = signature;
    }

    get template() {
        return `class Solution {\n` + 
        `    public ${this.signature} {\n\n    }\n\n` + 
        `    public static void main(String... args) {\n\n    }\n` + 
        `}`
    }

    get fileName() {
        return 'Solution.java';
    }
}

function createSolution(lang, signature) {
    switch (lang) {
        case 'java': return new JavaSolution(signature);
        default: throw new Error(`Unknown lang ${lang}`);
    }
}

(function init() {
    generateSolution(process.argv[2], process.argv[3], process.argv[4]);
})()

function generateSolution(title, lang, signature) {
    if (!existsSync(title)) {
        console.log(`Creating directory ${title}`);
        mkdirSync(title);
    }
    const solution = createSolution(lang, signature);
    console.log(`Writing to file ${title}`);
    writeFileSync(`${title}/${solution.fileName}`, solution.template);
    console.log('Done');
}