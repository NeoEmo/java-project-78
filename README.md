### Hexlet tests and linter status:
[![Actions Status](https://github.com/NeoEmo/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/NeoEmo/java-project-78/actions)

### SonarQube test and linter status:
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=NeoEmo_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=NeoEmo_java-project-78)

### Описание

Данный проект-библиотека предоставляет собой валидатор данных. Доступно 3 вида данных: Строки, цифры,
и любая коллекция ввида "Ключ - значение" (например, Map). Но ничего не мешает её подключить в другом проекте
и реаливать от BaseSchema новую схему и создать класс-наследник Validator, который будет реализовавать данную схему.
Библиотека построена на принципах **Builder-паттерна** и **Fluent Interface**, что позволяет настраивать правила 
валидации в цепочке вызовов.

### Состав библиотеки
1) BaseSchema - абстрактный класс схем.
2) Validator - класс.
3) Классы-наследники BaseSchema (Map/Number/StringSchema).

### Возможности библиотеки 
1) MapSchema:
    a) required() - обязательное присутсвие данных, не должны быть null.
    b) sizeof(int size) - установка размера библиотеки, не пройдут по размеру больше и меньше.
    с) shape(Map<String, BaseSchema>) - проверка нескольких схем в формате Map 
    (Хороший пример лежит в MapSchemaTest, а именно shapeSchemaTest()).
2) StringSchema:
    a) required() - обязательное присутсвие данных, не должно быть null или isEmpty().
    b) minLength(int lengthOf) - минимальная длинна строки.
    с) contains(String str) - проверка на содержание в строке какого-нибудь слова\строки\буквы итд.
3) NumberSchema:
    a) required() - обязательное пристутсвие данных, не должно быть null.
    b) positive() - проверка на то, чтобы число было положительным
    c) range(int min, int max) - проверка значений по какого-нибудь диапозону значений.

### Примеры работы

Примеры работы базовых схем в библиотеке можете посмотреть в тестах библиотеки, главное, что вам нужно будет знать,
что AssertFalse проверяет на то, что isValid() выдает false (проверка значения не пройдена).
a AssertTrue проверяет на то, что isValid() выдаёт true (проверка значения пройдена).
