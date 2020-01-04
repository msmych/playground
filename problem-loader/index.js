'use strict';
const {Builder, By, until, promise} = require('selenium-webdriver');
const {createProblem} = require('./problem');
const fs = require('fs');

const titleLocator = By.css("div[data-cy='question-title']");
const diffLocator = By.css("div[diff]");
const tagLocator = By.className('tag__2PqS');
const textLocator = By.css(".question-content__JfgR > div");

(async function loadProblem() {
    console.log('Creating driver');
    const driver = await new Builder().forBrowser('safari').build();
    const url = process.argv[2];
    console.log(`Opening ${url}`);
    await driver.get(url);
    console.log(`Waiting for page to load`);
    await driver.wait(until.elementLocated(titleLocator));
    const problemData = { url: url };
    console.log('Getting problem title');
    await driver.findElement(titleLocator).getText()
        .then(title => problemData.title = title);
    console.log('Getting problem difficulty');
    await driver.findElement(diffLocator).getAttribute('diff')
        .then(diff => problemData.diff = diff);
    console.log('Getting problem tags');
    await promise.map(driver.findElements(tagLocator), tag => tag.getText())
        .then(tags => problemData.tags = tags);
    console.log('Getting problem text');
    await driver.findElement(textLocator).getAttribute('innerHTML')
        .then(text => problemData.text = text);
    const problem = createProblem(problemData, 'html');
    console.log(problem);
    if (!fs.existsSync(`./../${problem.title}`)) {
        console.log(`Creating directory ${problem.title}`);
        fs.mkdirSync(`./../${problem.title}`);
    }
    console.log(`Writing to file ${problem.fileName}`);
    fs.writeFileSync(`./../${problem.title}/${problem.fileName}`, problem.format());
    console.log('Done');
})()

