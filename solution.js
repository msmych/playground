const {existsSync, mkdirSync, writeFileSync} = require('fs');
const JavaSolution = require('./java-solution');

function createSolution(lang, signature, args) {
    switch (lang) {
        case 'java': return new JavaSolution(signature, args);
        default: throw new Error(`Unknown lang ${lang}`);
    }
}

(function init() {
    generateSolution(process.argv[2], process.argv[3], process.argv[4], process.argv.slice(5, process.argv.length));
})()

function generateSolution(lang, signature, title, args) {
    if (!existsSync(title)) {
        console.log(`Creating directory ${title}`);
        mkdirSync(title);
    }
    const solution = createSolution(lang, signature, args);
    console.log(`Writing to file ${title}`);
    writeFileSync(`${title}/${solution.fileName}`, solution.template);
    console.log('Done');
}
