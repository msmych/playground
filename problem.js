'use strict';
const {Builder, By, until, promise} = require('selenium-webdriver');
const {existsSync, mkdirSync, writeFileSync} = require('fs');

class Problem {
    
    constructor({url, title, diff, tags, text}) {
        if (!url) {
            throw new Error('url missing');
        }
        this.url = url;
        if (!title) {
            throw new Error('title missing');
        }
        this.title = title;
        if (!diff) {
            throw new Error('diff missing');
        } else if (!['easy', 'medium', 'hard'].includes(diff)) {
            throw new Error(`Unknown diff ${diff}`);
        }
        this.diff = diff;
        this.tags = tags;
        if (!text) {
            throw new Error('text missing');
        }
        this.text = text;
    }

    format() {
        throw new Error('Use subclasses instead');
    }

    get fileName() {
        return this.url.substring(this.url.indexOf('/problems/') + '/problems/'.length).split('/')[0];
    }
}

class JsonProblem extends Problem {

    format() {
        return JSON.stringify(this, null, 2);
    }

    get fileName() {
        return `${super.fileName}.json`;
    }
}

class HtmlProblem extends Problem {

    format() {
        return `<h1><a href="${this.url}">${this.title}</a></h1>\n` + 
            `<h1><code style="color: ${this.diffColor}">${this.diff}</code></h1>\n` + 
            `<h3><code>${this.tags.join(' | ')}</code></h3>\n` + 
            `${this.text}`;
    }

    get fileName() {
        return `${super.fileName}.html`;
    }

    get diffColor() {
        switch (this.diff) {
            case 'easy': return 'green';
            case 'medium': return 'brown';
            case 'hard': return 'red';
        }
    }
}

function createProblem(problemData, type) {
    switch (type) {
        case 'json': return new JsonProblem(problemData);
        case 'html': return new HtmlProblem(problemData);
        default: return new Problem(problemData);
    }
}

const titleLocator = By.css("div[data-cy='question-title']");
const diffLocator = By.css("div[diff]");
const tagLocator = By.className('tag__2PqS');
const textLocator = By.css(".question-content__JfgR > div");

(async function init() {
    console.log('Creating driver');
    const driver = await new Builder().forBrowser('safari').build();
    const url = process.argv[2];
    console.log(`Opening ${url}`);
    await driver.get(url);
    console.log(`Waiting for page to load`);
    await driver.wait(until.elementLocated(titleLocator));
    const problemData = { url: url };
    await driver.findElement(titleLocator).getText()
        .then(title => problemData.title = title);
    await driver.findElement(diffLocator).getAttribute('diff')
        .then(diff => problemData.diff = diff);
    await promise.map(driver.findElements(tagLocator), tag => tag.getText())
        .then(tags => problemData.tags = tags);
    await driver.findElement(textLocator).getAttribute('innerHTML')
        .then(text => problemData.text = text);
    const problem = createProblem(problemData, 'html');
    console.log(problem);
    if (!existsSync(`./${problem.title}`)) {
        console.log(`Creating directory ${problem.title}`);
        mkdirSync(`./${problem.title}`);
    }
    console.log(`Writing to file ${problem.fileName}`);
    writeFileSync(`./${problem.title}/${problem.fileName}`, problem.format());
    console.log('Done');
})()

