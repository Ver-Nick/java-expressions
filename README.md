<h2>Калькулятор выражений на Java</h2>

Программа позволяет

- считать выражения с тремя переменными
- упрощать их(избавлять от лишних скобок)

<h3>Запуск</h3>
Необходим JDK 17+.

Из корня проекта:

```
javac expression/*.java
java expression/Main
```

Пример работы:

```
calculate x*x+y*y+z*z
x=1.12
y=2.23
z=3.43
17.9922

calculate (2*x+y)/z+32
x=3
y=10
z=8
34.0

simplify (y * (z * (-1 + y)))
y * z * (-1.0 + y)

simplify ((2 / (x - 1)) / 2)
2.0 / (x - 1.0) / 2.0

calculate -(1/3+34/50)*11
x=0
y=0
z=0
-11.146666666666668

calculate qwe
x=0
y=0
z=0
Failed to get input: Unknown sequence: qwe at position 4

```
