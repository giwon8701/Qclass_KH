# -*- coding:utf-8 -*-

from pymongo import MongoClient

client = MongoClient('127.0.0.1', 27017)
# client = MongoClient('127.0.0.1', 27017)

db = client.test
# db = client['test']

collection = db.score
# collection = db['score']

result = collection.find()

for res in result:
    print(res)

