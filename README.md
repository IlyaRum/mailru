# тестовый проект - mailru

## Описание
Тест делает следующее: 
1. Логинится на сайте mail.ru: вводит логин/пароль, которые были предварительно указаны в файле config.properties для LOGIN/PASSWORD соответственно.
2. Пишет письмо с содержанием, которое указано в TEXTBODY.
3. Отправляет письмо на адресс TOEMAIL. 
4. Проверки доставки письма нет, только отправка.

## Установка
1. Загрузите копию проекта на локальном компьютере для тестирования.
2. Извлечь архив проекта в каталог, например, mailru-master.
3. Зайти в mailru-master и найти файл config.properties. Нужно открыть его в влюбом текстовом редакторе и ввести корректные логин/пароль вместо you_login/you_pass.
4. Открыть cmd и указать каталог mailru-master.
## Билд проекта
Ввести команду: mvn compile
## Запуск теста
ввести: mvn test

## Log теста 
```
>mvn test
-------------------------------------------------------
T E S T S
-------------------------------------------------------
Running ru.selenium.test.MailRuTest
Configuring TestNG with: org.apache.maven.surefire.testng.conf.TestNG652Configurator@16f77cc
Starting ChromeDriver 2.33.506120 (e3e53437346286c0bc2d2dc9aa4915ba81d9023f) on port 12494
Only local connections are allowed.
-------------
LOGIN: you_login
PASSWORD: you_pass
TOEMAIL: irumyancev@mail.ru
TEXTBODY: Hello!!! How are you?
-------------
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.148 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 30.678 s
[INFO] Finished at: 2017-12-17T20:04:10+03:00
[INFO] Final Memory: 8M/20M
[INFO] ------------------------------------------------------------------------
```



