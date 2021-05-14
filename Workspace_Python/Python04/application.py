# -*- coding:utf-8 -*-

from flask import Flask, render_template, request

app = Flask(__name__)


@app.route('/')
def root():
    return '''
        <a href='/hello'>hello</a><br><br>
        <input type='button' value='hello' onclick='location.href="/hello/name"'>
    '''


@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)


@app.route('/test', methods=['post'])
def test():
    return render_template('test.html', test=request.form['command'])


if __name__ == '__main__':
    app.run()