# -*- coding:utf-8 -*-

from pymongo import MongoClient


client = MongoClient('localhost', 27017)
db = client.test
score = db.score

res01 = score.delete_one({'name': '김태리'})
print(res01.deleted_count)  # 삭제된 갯수

# midterm 이라는 field가 존재하는 document 들 삭제
res02 = score.delete_many({'midterm': {'$exists': True}})
print(res02)
print(res02.deleted_count)
