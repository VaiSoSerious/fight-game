<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 24.08.2023
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Новый персонаж</title>
    <%--Подсвечивание--%>
    <style>
        .highlight:hover {
            background-color: #f5f5f5;
        }
    </style>
    <%--Скрытый текст--%>
    <style>
        .hidden-text {
            display: none;
        }
    </style>
    <%--Равные столбцы--%>
    <style>
        table {
            width: 100%;
            table-layout: fixed;
        }

        table td {
            width: calc(100% / 3);
        }
    </style>


    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="container-fluid">
    <%--Название игры--%>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <br><br>
            <div class="container">
                <h1 align="center" style="color: red">Сдохни или умри!</h1>
            </div>
            <br>
        </div>
        <div class="col-md-2">
            <br><br>
            <div class="panel-body" align="center">Вы вошли как: ${user.name}
                <form action="hello" method="get">
                    <button id="backButton" name="backButton" class="btn btn-danger">Выйти</button>
                </form>
            </div>
        </div>
    </div>
    <hr>
    <%--Текстовый комментарий--%>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-body" align="center">Выбор профессии</div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
        <br><br>
    </div>
    <%--Блок выбора профессии--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td class="highlight" align="center" onmouseover="showText('${backend}')" onmouseout="hideText()">
                        <b>Backend разработчик</b>
                        <br><br>
                        <p>
                            Раса: Люди<br>
                            Фракция: Нейтральная<br>
                            Роль: Поддержка, Скрытность<br>
                        <div align="left">
                            <small>
                                Описание:<br>
                                Backend разработчики принести новую силу и мощь виртуальному миру. Они являются
                                мастерами программирования и владеют магическими данными и технологиями, позволяющими
                                контролировать скрытые аспекты игрового мира. Backend разработчики способны
                                манипулировать и создавать новые функциональности, которые
                                обогащают игровой опыт. Они обладают уникальными способностями в области управления
                                серверами, базами данных и разработки API, что делает их неотъемлемой частью команды
                                разработчиков. Класс Backend разработчика предлагает выбор различных специализаций,
                                каждая из которых придает ему уникальные способности. Вот некоторые из них:<br><br>
                                Специализации:<br>
                                1. <b>Мастер баз данных:</b> Эта специализация позволяет Backend разработчику
                                манипулировать и
                                оптимизировать игровые базы данных. Они способны создавать и изменять таблицы, извлекать
                                и обрабатывать большие объемы информации, а также обеспечивать бесперебойную работу баз
                                данных для лучшего игрового опыта.<br><br>
                                2. <b>API волшебник:</b> Backend разработчик, выбравший эту специализацию, обладает
                                уникальными
                                способностями в создании и управлении API. Они могут
                                разрабатывать интерфейсы и интегрировать различные системы в игре. Такие разработчики
                                могут связываться с внешними сервисами и расширять игровой мир, предоставляя игрокам
                                новые возможности и функции.<br><br>
                                3. <b>Волшебник-оптимизатор:</b> Эти Backend разработчики специализируются на
                                оптимизации
                                производительности игры. Они анализируют и улучшают процессы выполнения, оптимизируют
                                загрузку данных и устраняют баги, которые могут
                                привести к задержкам или плохому игровому опыту. Backend разработчики, подобно другим
                                классам в World of Warcraft, имеют свою уникальную специализацию, древо талантов и
                                арсенал заклинаний, которые позволяют им эффективно выполнять свои задачи в игровом
                                мире. Они являются сильными и ценными союзниками в сражениях и приключениях, добавляя
                                новые возможности и функциональности, чтобы виртуальный мир был более привлекательным и
                                увлекательным для всех игроков.
                            </small>
                        </div>
                        </p>
                    </td>
                    <td class="highlight" align="center" onmouseover="showText('${devops}')" onmouseout="hideText()">
                        <b>Devops инженер</b>
                        <br><br>
                        <p>
                            Раса: Орки<br>
                            Фракция: Нейтральная<br>
                            Роль: Танк, Поддержка<br>
                        <div align="left">
                            <small>
                                Описание:<br>
                                DevOps инженеры - это бравые лидеры и незаменимые защитники виртуального мира
                                World of Warcraft. Они сочетают в себе силу, мастерство боя и умения управления
                                технологическими процессами для обеспечения бесперебойной работы серверов и приложений.
                                Как воины, DevOps инженеры отличаются силой, стойкостью и мастерством в бою. DevOps
                                инженеры обладают уникальными навыками, позволяющими им эффективно оптимизировать и
                                автоматизировать процессы разработки, доставки и эксплуатации программного обеспечения.
                                Они являются надежными защитниками виртуального мира, принимая на себя танковскую роль и
                                обеспечивая стабильность, отказоустойчивость и безопасность систем. Класс DevOps
                                инженера предлагает различные специализации, каждая из которых придает им уникальные
                                способности и умения. Вот некоторые из них:<br><br>
                                Специализации:<br>
                                1. <b>Железный танк:</b> Эта
                                специализация позволяет DevOps инженеру стать непоколебимым защитником, способным
                                выдерживать самые сильные атаки и поглощать урон. Они строят и поддерживают мощные
                                инфраструктурные системы, гарантируя непрерывность и стабильность работы
                                серверов.<br><br>
                                2. <b>Мастер автоматизации:</b> DevOps инженеры, выбравшие эту
                                специализацию, обладают навыками автоматизации и управления проектами. Они создают
                                инструменты и системы, которые оптимизируют процессы разработки и доставки программного
                                обеспечения, гарантируя высокую производительность и эффективность работы
                                команды.<br><br>
                                3. <b>Инженер-бастион:</b> Эта специализация фокусируется на обеспечении безопасности и
                                защите систем. DevOps инженеры этой специализации занимаются мониторингом, обнаружением
                                и противодействием угрозам безопасности, а также разработкой инструментов и методологий
                                для предотвращения атак и вмешательства. DevOps инженеры, подобно воинам, обладают
                                широким арсеналом мощных атак и умений, которые помогают им справляться с любыми
                                вызовами в игровом мире. Они также имеют свою древо талантов, позволяющее им улучшать и
                                расширять свои навыки в соответствии с потребностями команды и игрового процесса. DevOps
                                инженеры являются ценными и незаменимыми союзниками в виртуальном мире World of
                                Warcraft. Их мастерство в бою и умения в управлении технологическими процессами
                                гарантируют, что сервера работают б
                            </small>
                        </div>
                        </p>
                    </td>
                    <td class="highlight" align="center" onmouseover="showText('${frontend}')" onmouseout="hideText()">
                        <b>Frontend разработчик</b>
                        <br><br>
                        <p>
                            Раса: Нежить<br>
                            Фракция: Нейтральная<br>
                            Роль: Урон, Усиление<br>
                        <div align="left">
                            <small>
                                Описание:<br>
                                Frontend разработчик, виртуоз веб-технологий, проникает в игровой мир World of
                                Warcraft со своими неукротимыми навыками и уникальной способностью преобразовывать
                                пользовательский интерфейс. Сходно с разбойником, Frontend разработчикы обладают
                                виртуозной ловкостью, обманчивой скрытностью и способностью наносить урон своими
                                навыками веб-дизайна и программирования. Этот класс способен создавать интуитивные,
                                красочные и эффектные пользовательские интерфейсы, улучшая визуальные элементы игры и
                                усиливая вовлеченность игроков. С их помощью игроки будут иметь полный контроль и
                                гибкость во взаимодействии с виртуальным миром, увеличивая свою эффективность и
                                преимущества в битвах и приключениях. Frontend разработчики мастера в своей области.
                                Совершенствуя свое мастерство, они умеют обходить преграды и безмятежно внедрять
                                изменения в интерфейсе игры. Это позволяет им быть непредсказуемыми и создавать эффекты,
                                которые делают эпические сражения еще захватывающими и впечатляющими. Фронтенд
                                разработчики имеют способность к скрытности, что позволяет им с легкостью обходить
                                системные блокировки или защиты, чтобы внести необходимые изменения. Это позволяет им
                                адаптироваться к новым условиям и быстро анализировать требования пользователей, чтобы
                                создавать кастомизируемые и уникальные пользовательские интерфейсы для каждого игрока.
                                Как разбойник, Frontend разработчики обладают уникальными специализациями и
                                навыками:<br><br>
                                Специализации:<br>
                                1. <b>Мастер графики:</b> Владение этой специализацией позволяет Frontend разработчику
                                создавать
                                потрясающие визуальные эффекты, анимации и дефайсы для интерфейсов игры. Они могут
                                воплотить самые смелые дизайнерские идеи в реалистические и захватывающие графические
                                элементы.<br><br>
                                2. <b>Маэстро адаптивности:</b> Эта специализация фокусируется на создании адаптивных
                                и мобильных пользовательских интерфейсов, которые легко адаптируются для различных
                                устройств и экранов. Фронтенд разработчики этой специализации гарантируют, что игроки
                                могут наслаждаться одинаково комфортным восприятием игры, независимо от
                                платформы.<br><br>
                                3. <b>Реализация замысла:</b> Эта специализация фокусируется на создании интерактивных и
                                интуитивных элементов. Frontend разработчики этой специализации способны создавать
                                сложные игровые механи
                            </small>
                        </div>
                        </p>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div id="hiddenText" class="hidden-text"></div>
        </div>
    </div>
</div>


<script>
    <%--Показать текст--%>

    function showText(text) {
        var hiddenText = document.getElementById('hiddenText');
        hiddenText.textContent = text;
        hiddenText.style.display = 'block';
    }

    // Скрыть текст
    function hideText() {
        var hiddenText = document.getElementById('hiddenText');
        hiddenText.style.display = 'none';
    }
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
        crossorigin="anonymous"></script>
</body>
</html>
