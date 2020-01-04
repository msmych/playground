'use strict';

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
        return `<h1><a href="${this.url}">${this.title}</a></h1>` + 
            `<h1><code style="color: ${this.diffColor}">${this.diff}</code></h1>` + 
            `<h3><code>${this.tags.join(' | ')}</code></h3>` + 
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

module.exports = {createProblem};