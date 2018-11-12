# QATestLab. Lecture №3. Nazarenko Maxim.
В ходе выполнения домашнего задания, в IDE IntelliJ IDEA был создан Maven проект, который использует библиотеки Selenium и Junit для реализации скриптов.

Проект содержит следующие классы: 
- CreateCategoryTest.java, в котором реализован скрипт в виде обычного приложения с использованием метода main().
- DriverManager.java был создан для возможности работы с разными драйверами браузеров: Chrome, Firefox, IE.
- Properties.java хранит константы (данные для входа в админ панель, ссылки).
- AdminLoginPage.java, AdminDashboardPage.java, AdminCategoriesPage.java, классы содержащие описание страниц, которые используются в тестовом сценарие, поскольку проект реализован с помощью шаблона проектирования Page Object.
- EventHandler.java реализует интерфейс WebDriverEventListener и используется для работы с логами.
