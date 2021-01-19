# java-automation
All tasks in one of Java Automation course stage 1 and 2

List of tasks:

STAGE1
-fundamentals(main)
-classes(main)
-cleancode(main/test)
-collections(main)

STAGE2
-errorAndExceptions(main)
-------------------------------
task description:
В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. 
У каждого студента есть несколько учебных предметов по которым он получает оценки. 
Необходимо реализовать иерархию студентов, групп и факультетов.

Посчитать средний балл по всем предметам студента
Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
Посчитать средний балл по предмету для всего университета
Релизовать следующие исключения:

Оценка ниже 0 или выше 10
Отсутсвие предметов у студента (должен быть хотя бы один)
Отсутствие студентов в группе
Отсутствие групп на факультете
Отсутствие факультетов в университете
-------------------------------
-javaIO(main)
-------------------------------
task description:
Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies". Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F. Пример:

Amon Amarth
    |-----2004 - Fate Of Norns
    |       01 - An Ancient Sign Of Coming Storm.mp3
    |       02 - Where Death Seems To Dwell.mp3
    |       03 - The Fate Of Norns.mp3
    |       04 - The Pursuit Of Vikings.mp3
    |       05 - Valkyries Ride.mp3
    |       06 - The Beheading Of A King.mp3
    |       07 - Arson.mp3
    |       08 - Once Sealed In Blood.mp3
    |
    |-----2016 - Jomsviking
    |       01 First Kill.mp3
    |       02 Wanderer.mp3
    |       03 On A Sea Of Blood.mp3
    |       04 One Against All.mp3
    |       05 Raise Your Horns.mp3
    |       06 The Way Of Vikings.mp3
    |       07 At Dawn’s First Light.mp3
    |       08 One Thousand Burning Arrows.mp3
    |       09 Vengeance Is My Name.mp3
    |       10 A Dream That Cannot Be (feat. Doro Pesch).mp3
    |       11 Back On Northern Shores.mp3
    |       12 Death In Fire 2016.mp3
    |       13 Death In Fire (Live).mp3
    |
    |-----2019 - Berserker
            01 Fafner's Gold.mp3
            02 Crack the Sky.mp3
            03 Mjölner, Hammer of Thor.mp3
            04 Shield Wall.mp3
            05 Valkyria.mp3
            06 Raven's Flight.mp3
            07 Ironside.mp3
            08 The Berserker at Stamford Bridge.mp3
            09 When Once Again We Can Set Our Sails.mp3
            10 Skoll and Hati.mp3
            11 Wings of Eagles.mp3
            12 Into the Dark.mp3


Если в качестве параметра в программу передается не путь к директории, 
а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:

Количество папок
Количество файлов
Среднее количество файлов в папке
Среднюю длинну названия файла
-------------------------------
-threads(main)
-------------------------------
task description:
Тоннель. В горах существует два железнодорожных тоннеля, 
по которым поезда могут двигаться в обоих направлениях. 
По обоим концам тоннеля собралось много поездов. 
-------------------------------
-webdriver(main/test)
-------------------------------
I Can Win
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
* Код: "Hello from WebDriver"
* Paste Expiration: "10 Minutes"
* Paste Name / Title: "helloweb"
-------------------------------
Bring It On  
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
* Код:
git config --global user.name  "New Sheriff in Town"
git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
git push origin master --force
* Syntax Highlighting: "Bash"
* Paste Expiration: "10 Minutes"
* Paste Name / Title: "how to gain dominance among developers"
3. Сохранить paste и проверить следующее:
* Заголовок страницы браузера соответствует Paste Name / Title
* Синтаксис подвечен для bash
* Проверить что код соответствует введенному в пункте 2
-------------------------------
-------------------------------
-framework(test)
-------------------------------
task description:
Задача - построить фреймворк для автоматизации Hardcore  задания из курса WebDriver.

Что должно быть в итоговом фреймворке:

webdrivermanager для управления коннекторам к браузерам
Page Object / Page Factory для абстракций страниц
Модель для бизнес-объектов необходимых сущностей
properties файлы с тестовыми данным для разных окружений (как минимум 2)
xml suites для smoke тестов и всех тестов
При падении теста должен быть сделан скриншот с датой и временем
Фреймворк должен иметь возможность запуска с Jenkins и параметризацией браузера, 
тест suite, environment. Результаты тестов должны быть на графике джобы, 
скриншоты должны быть заархивированны как артефакты


notes to "framework" task->
parameters to start mvn project:
-Dbrowser={param1}
-Denvironmnet={param2}
-Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml

param1: chrome | firefox | edge
param2: qa | dev

example:
mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml clean test
-----------------------------------

