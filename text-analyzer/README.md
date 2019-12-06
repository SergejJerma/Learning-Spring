# Teksto analizatorius

programa analizuoja įvestą tekstą pagal paskutines žodžių raides - atrenkami bei sugrupuojami tik lotyškos abecėlės žodžiai, kurie baigiasi ta pačia raide. 

## Pradžia

Servisas paleidžiamas iš .jar failo
* [analyzer.jar](https://) 
```
java -jar analyzer.jar
```

### Back-end
```
Java SE 11 
Spring Boot 2.2.1
Maven 3.6.1
H2
```
### Front-end
```
FreeMarker
Bootstrap
```

## Programos veikimas

Paleidus programą, atsidaro (http://localhost:8080/) vartotojo interfeisas, kuriame reikia įvesti tekstą analizei bei paspausti myktuką ANALYZE:
pvz, įvedamas tekstas
```
state mate web mate lab 4fun late fatE
```
gaunamas rezultatas
```
Request:
state mate web mate lab 4fun late fatE
Result:
e 5 state mate mate late fatE
b 2 web lab 
```

### Papildoma informacija

* Puslapio navigacijoje vartotojui numatyta galimybė peržiūrėti visą užklausų istoriją, kuri rodoma atskirame lange.

## Testai

Programoje yra paprasti integraciniai testai


