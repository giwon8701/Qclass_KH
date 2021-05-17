# -*- coding:utf-8 -*-

from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.test
score = db.score

aggre = score.aggregate([
    {'$match': {'kor': {'$gt': 70}}},
    {'$group': {'_id': 'kors', 'sum': {'$sum': '$kor'}}}
])

print(aggre)
print(list(aggre))