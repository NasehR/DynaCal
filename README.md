# DYNACAL

A Gradle Java-based calendar application. 

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#projectstructure)
- [Commands-Line Arguments](#cli)
    - [Build](#build)
    - [Run](#run)
    - [Test](#test)
    - [PMD](#pmd)
    - [Clean](#clean)


## Introduction

The application reads a specially formatted calendar file, displaying and navigating events within a seven-day period from the current date. The user interface (terminal) is internationalized, supporting various locales. The application dynamically load plugins and run scripts specified in the calendar file, allowing the user to extend functionality. Code quality is ensured via the use of PMD, and the calendar file follows a domain-specific language. The project structure includes Gradle for building, with separate subprojects for the core application, API declarations, and plugins.

## Project Structure
```
.
|-- README.md
|-- build.gradle
|-- settings.gradle
|-- gradle.bat
|-- gradlew
|
|-- api
|   |-- build.gradle
|   |-- saed-pmd-rules.xml
|   |-- src
|       |-- main
|       |   |-- java
|       |       |-- edu.curtin.dynacal.api
|       |           |-- AllDayCalendarEvent.java
|       |           |-- API.java
|       |           |-- ICalendarPlugin.java
|       |           |-- IEvent.java
|       |           |-- IEventHandler.java
|       |           |-- TODOCalendarEvent.java
|       |
|       |-- test
|           |-- java
|               |-- edu.curtin.dynacal.api
|                   |-- AllDayCalendarEventTest.java
|                   |-- TODOCalendarEventTest.java
|
|-- calplugins-notify
|   |-- build.gradle
|   |-- saed-pmd-rules.xml
|   |-- src
|       |-- main
|       |   |-- java
|       |       |-- edu.curtin.dynacal.calplugins.notify
|       |           |-- Notify.java
|       |
|       |-- test
|           |-- java
|               |-- edu.curtin.dynacal.calplugins.notify
|                   |-- NotifyTest.java
|
|-- calplugins-repeat
|   |-- build.gradle
|   |-- saed-pmd-rules.xml
|   |-- src
|       |-- main
|       |   |-- java
|       |       |-- edu.curtin.dynacal.calplugins.repeat
|       |           |-- Repeat.java
|       |           
|       |-- test
|           |-- java
|               |-- edu.curtin.dynacal.calplugins.repeat
|                   |-- RepeatTest.java
|-- application
    |-- build.gradle
    |-- saed-pmd-rules.xml
    |-- calendar.utf8.cal
    |-- calendar.utf16.cal
    |-- calendar.utf32.cal
    |-- src
        |-- main
        |   |-- java
        |   |   |-- edu.curtin.dynacal.app
        |   |   |   |-- controller
        |   |   |   |   |-- CalendarController.java
        |   |   |   |   |-- ExtraController.java
        |   |   |   |
        |   |   |   |-- model
        |   |   |   |   |-- EventsModel.java
        |   |   |   |
        |   |   |   |-- view
        |   |   |       |-- AddDayStrategy.java
        |   |   |       |-- AddMonthStrategy.java
        |   |   |       |-- AddWeekStrategy.java
        |   |   |       |-- AddYearStrategy.java
        |   |   |       |-- IDateStrategy.java
        |   |   |       |-- TakeDayStrategy.java
        |   |   |       |-- TakeMonthStrategy.java
        |   |   |       |-- TakeWeekStrategy.java
        |   |   |       |-- TakeYearStrategy.java
        |   |   |       |-- TerminalView.java
        |   |   |       |-- TodayStrategy.java
        |   |   |       |-- UIView.java
        |   |   |
        |   |   |-- Main.java
        |   |
        |   |-- jj
        |   |   |-- Calendar.jj
        |   |
        |   |-- resources
        |       |-- bundle_en_AU.properties
        |       |-- bundle_en_US.properties
        |       |-- bundle_es_ES.properties
        |
        |-- test
            |-- java
                |-- edu.curtin.dynacal.app
                    |-- controller
                    |   |-- CalendarControllerTest.java
                    |
                    |-- model
                    |   |-- EventsModelTest.java
                    |
                    |-- UTF8Test.java
 
```

## Commands-Line Arguments:
### Build:
```
> ./gradlew :application:build
```

### Run:
```
> ./gradlew :application:run --args="arg[0] arg[1]" 
```
- arg[0] = calendar file name either:
    - calendar.utf8.cal
    - calendar.utf16.cal
    - calendar.utf32.cal
- arg[1] = locale either:
    - 0 = en_AU
    - 1 = en_US
    - 2 = es_ES

#### Sample:
```
> ./gradlew :application:run --args="calendar.utf8.cal 0"
```
- Run the application with:
  - Calendar file : calendar.utf8.cal
  - Locale : en_AU locale.

### Test:
```
> ./gradlew :api:test
> ./gradlew :application:test
> ./gradlew :calplugins-notify:test
> ./gradlew :calplugins-repeat:test
```

### PMD:
```
> ./gradlew :api:check
> ./gradlew :application:check
> ./gradlew :calplugins-notify:check
> ./gradlew :calplugins-repeat:check
```

### Clean:
```
> ./gradlew clean
```