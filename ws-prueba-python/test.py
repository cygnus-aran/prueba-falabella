import requests

BASE = "http://127.0.0.1:5000/prueba"

response = requests.get(BASE + "/patente/AAAA000")
print(response.json())

response = requests.get(BASE + "/id/26001")
print(response.json())