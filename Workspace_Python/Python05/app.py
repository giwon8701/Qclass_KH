# -*- coding:utf-8 -*-

from flask import Flask, render_template
from bs4 import BeautifulSoup
import requests
import json

app = Flask(__name__)


@app.route('/')
def root():
    return render_template('index.html')


def naverMovieCrawling():
    # naver 영화에서 영화제목과 별점을 가지고 와서
    # {'movies':[{'title':제목, 'star': 별점}, ...]} 형태의 json 객체로 리턴하자
    pass


if __name__ == '__main__':
    app.run(host='localhost', port='8282')