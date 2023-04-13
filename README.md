# Проект по автоматизации тестирования сайта Drom.ru
## :receipt: Содержание:

- Реализованные проверки
- Запуск тестов
- Allure-отчет
- Интеграция с Allure TestOps

## :mag_right: Реализованные проверки

Автоматизированные тесты
- ✓ Проверка запроса поиска всех автомобилей (GET)
- ✓ Добавление объявления о продаже автомобиля в избранное (POST)
- ✓ Удаление объявления о продаже автомобиля из избранного (POST)
- ✓ Переход к заполнению формы подачи объявления (GET)
- ✓ Ошибка при переходе к заполнению формы подачи объявления (GET)
- ✓ Проверка запроса удаления пользователя (DELETE)

## :arrow_forward: Запуск тестов

###  Локальный запуск :
Пример командной строки:
```bash
gradle clean test
```
Получение отчёта:
```bash
allure serve build/allure-results
```

###  Удаленный запуск (в Jenkins):
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/017-July_Shk-jenkins_diplom_api/">проект</a>

![This is an image](/images/screens/jenkins.png)

2. Выбрать пункт **Собрать сейчас**
3. Результат запуска сборки можно посмотреть в отчёте Allure

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/017-July_Shk-jenkins_diplom_api/3/allure/">Allure report</a>

###  Главное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/allure.png">
</p>

###  Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/allure2.png">
</p>


## <img src="images/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/22201">Allure TestOps</a>
### Общий список всех кейсов
<p align="center">
<img title="Allure Graphics" src="images/screens/testops_tests.png">
</p>

### Dashboard с общими результатами тестирования
<p align="center">
<img title="Allure Graphics" src="images/screens/testops_dashboard.png">
</p>

