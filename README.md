## Android Telegram client

This project is a clone of [official telegram client](https://github.com/DrKLO/Telegram).

### Tech tricks

To build & run you need to do following tricks:
1. google-services.json -> TMessagesProj\
2. BuildVars.java -> TMessagesProj\src\main\java\org\telegram\messenger\

Install .apk with help of Gradle, choose _version_ carefully!

*Tested on API 23 x86*

### TODO
- [x] Obtain your own api_id for your application
- [ ] Change app name
- [ ] Change app img
- [ ] Study security guidelines
- [x] Add licences


### Инструкция по запуску (У менеджера так и заработало)
1. Установите Android studio, Android SDK и к сдк установите NDK (устанавливаются из студии)
2. Сделать клон клиента. Гит команда: git clone https://github.com/DDHunter13/Mem-bot.git -b telegram_client --recursive
3. Запустить cmd; Перейти в папку <Mem-bot>/TMessageProj; Ввести команду <android SDK path>/ndk-bundle/ndk-build.cmd
4. Скачать файлы google-services.json и BuildVars.java; Скнуть их в пути, указанные выше
4. Запусить студию; Открыть проект; Отключить instatnt run; Собрать проект
5. Сгенерировать APK (Build -> Generate signed Bundle / APK); Выбрать APK, создать новый путь, придумтаь пароль. На выходе выбрать x86 из списка.
6. Собрать APK (Build -> Build Bundle/APK).
7. Запустить эмулятор (Через AVD Manager в студии).
8. Перейти в папку <Mem-bot>\TMessagesProj\x86\release
9. Перетащить .apk файл на эмулятор.
10. Запустить тлегарамм на эмуляторе.
