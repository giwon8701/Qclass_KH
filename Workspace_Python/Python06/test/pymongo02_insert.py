# -*- coding:utf-8 -*-


from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.test
score = db.score


res01 = score.insert_many([
    {
        'name': '김태리',
        'midterm': {
                'kor': 100,
                'eng': 100,
                'math': 100
            },
        'final': {
                'kor': 90,
                'eng': 100,
                'math': 88
            }
    },
    {
        'name': '차은우',
        'midterm': {
                'kor': 67,
                'eng': 100,
                'math': 78
            },
        'final': {
                'kor': 100,
                'eng': 100,
                'math': 91
            }
    }
])

print(res01.inserted_ids)

res02 = db.score.insert_one({'name': '태연', 'kor': 100, 'eng':59, 'math': 88})
print(res02)
print(res02.inserted_id)