# prueba-falabella
Prueba Falabella

Ambos proyectos estan configurados para correr en los mismos endpoint y con los mismos request
## http://localhost:8080/prueba/codificar

```
request:
{
    "fuente": "Falabella es el mejor retail"
}
```
```
response:
{
  "respuesta":"8/4(F2'8}0;2)a5!1_7+la5]7{b1#4}e6&1$4;l2%9}l4_3-0.6#a0[4^ 9'1{e3'l7_7; 7^m2{7(e7[3.6(j7-4#8$4@o1#6&8+r9-4] 6%4{4%r4!1!2;e8/4;7/ta1)8+9}3[i4#4;8#l6&"
}
```
## http://localhost:8080/prueba/decodificar

```
request:
{
    "fuente": "8/4(F2'8}0;2)a5!1_7+la5]7{b1#4}e6&1$4;l2%9}l4_3-0.6#a0[4^ 9'1{e3'l7_7; 7^m2{7(e7[3.6(j7-4#8$4@o1#6&8+r9-4] 6%4{4%r4!1!2;e8/4;7/ta1)8+9}3[i4#4;8#l6&"
}
```
```
response:
{
   "respuesta": "Falabella es el mejor retail"
}
```

Para la prueba Python
## http://localhost:5000/prueba/id/{numero id}

```
response:
{
    "respuesta": "AABA000"
}
```
## http://localhost:5000/prueba/patente/{patente}

```
response:
{
    "respuesta": 134153
}
```


