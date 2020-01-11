const {existsSync, mkdirSync, writeFileSync} = require('fs');

class JavaSolution {

    constructor(signature) {
        this.signature = signature;
    }

    get template() {
        return `class Solution {\n` + 
        `    public ${this.signature} {\n` +
        `        return 0;\n` +
        `    }\n` +
        `\n` + 
        `    // java Solution.java\n` +
        `    public static void main(String... args) {\n` +
        `        Solution solution = new Solution();\n` +
        `    }\n` + 
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
    if (process.argv.length <= 2) {
        return;
    }
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

module.exports = createSolution;