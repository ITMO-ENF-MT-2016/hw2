Домашнее задание
================
Практическое задание по курсу Параллельное Программирование на кафедре ВМ, факультета ЕН, 2016 год.
Исследование performance проблем в многопоточной среде с помощью JMH.

Необходимое ПО
--------------
1. Java SDK 7 или более поздняя:
   http://www.oracle.com/technetwork/java/javase/downloads/index.html

2. Apache Maven 3.x:
   http://maven.apache.org/download.cgi

Описание
--------
Задание включает в себя следующие основные исходные файлы:

* src/main/java/ru/ifmo/pp/jmh/FalseSharing содержит пример бенчмарка, позволяющий проанализировать проблему
  false sharing.

* pom.xml содержит описание проекта для системы сборки Maven. Используейте его, чтобы создать проект в вашей
  любимой среде разработки. Рекомендуется IntelliJ IDEA. Используя операцию File | Import Project... и указав
  месторасположение файла pom.xml, вы создадите проект для выполнения задания.

Задание
-------
1. Необходимо написать несколько бенчмарков:
    1. Бенчмарк, показывающий false sharing problem 
        * https://en.wikipedia.org/wiki/False_sharing
    2. Бенчмарк, показывающий насколько дорогой доступ к volatile по сравнению с доступом к не volatile
        * как будет меняться время доступа в зависимости от количества потоков?
        * как будет меняться время доступа в зависимости от того, разделяется ли переменная между потоками? 
          (см. `@State(Scope.Thread|Scope.Benchmark)`)
    3. Бенчмарк, сравнивающий различные методы синхронизации: `volatile`, `synchronized`, `ReentrantLock`
        * требуется создать класс с полем типа `long` и использовать различные методы синхронизации для доступа к нему
        * как будет меняться время доступа в зависимости от количества потоков?
        * как будет меняться время доступа в зависимости от того, разделяется ли переменная между потоками? 
          (см. `@State(Scope.Group|Scope.Shared)`)
    4. Бенчмарк, сравнивающий различные реализации отображения (Map) из стандартной библиотеки, 
       корректно работающие в многопоточной среде: 
       `ConcurrentSkipListMap`, `ConcurrentHashMap`, `Collections.synchronizedWith(..)`
       * как будет меняться время доступа в зависимости от количества потоков?
       * как будет меняться время доступа в зависимости от количества значений?

2. При написании необходимо использовать библиотеку JMH (Java Microbenchmark Harness). 
   Все измерения должны быть в наносекундах (`TimeUnit.NANOSECONDS`)

3. Для каждого из бенчмарков следует предоставить отчетные данные с объяснением выявлыенного эффекта.
   Отчеты должны быть написаны в Markdown и находиться в корне проекта в файле `<benchmark_name>.md`.
   В начале отчета должна содержаться информация о железе, на котором запускались бенчмарки.
   
4. Во время защиты вы должы быть в состоянии объяснить выявленные эффекты на вашей платформе (скорее всего это x86).

5. Код должен быть отформатирован в сотвеетсвевии со стандартным Java стилем используя 4 пробела для выравнивания
   кода. Следуйте стилю, в котором написан класс FalseSharing. Плохо отформатированный код не будет проверяться.

Сборка и запуск бенчмарков
------------------------
Для сборки проекта используйте команду `mvn package`. В результате сборке сгенерируется `target/banchmarks.jar`, 
который запускает написанные бенчмарки. Используйте команду `java -jar target/benchmarks.jar` для запуска.

Порядок сдачи
-------------
1. Сдавать задание нужно в виде форка и пулл-реквеста,
   в описании укажите ФИО и номер группы.
   Подробнее про пулл-реквесты можно почитать тут:
   http://habrahabr.ru/post/125999/ и https://help.github.com/articles/using-pull-requests.

2. Если задание выполнено неверно, то это будет написано в комментариях к пулл-реквесту.
   Сдавать задание на проверку можно несколько раз.

3. После того, как будет сдано верное решение, его нужно защитить во время практического занятия.
   В рамках защиты будет задано несколько вопросов по вашему коду и работе в целом.

Система оценивания и баллы
--------------------------
Максимум за задание 10 баллов.
За каждый вид ошибок снимается по одному баллу. Баллы выставляются только после защиты.

Например, если за две попытки сдачи допущено три ошибки, и две из них имеют общий корень, то снимается 2 балла. В итоге получаем 8 баллов.

Ссылка на таблицу с баллами: https://goo.gl/LRqkYq
