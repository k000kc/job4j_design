package ru.job4j.ood.dip;

public class ProgrammManager {

    /**
     * Нарушение DIP, используем класс DBConnector напрямую в качестве поля,
     * если захотим использовать другое подключение к бд придется переписывать класс,
     * В качестве поля должна использоваться абстакция,
     * в которую сможем подставить подходящую реализацию подключения к БД
     */
    public DBConnector connector;

    public ProgrammManager(DBConnector connector) {
        /*
         * Нарушение DIP, создаем объект Logger напрямую,
         * если будет необходимо использовать другой логгер придется изменять класс.
         * Необходимо использовать абстрактный Logger.
         */
        Logger logger = new Logger();
        this.connector = connector;
        logger.log("Connection completed");
        /*
         * Нарушение DIP, создаем объект EmailSender напрямую,
         * если будет необходимо использовать другой метод уведомления придется изменять класс.
         * Необходимо использовать абстрактный EmailSender.
         */
        EmailSender sender = new EmailSender();
        sender.send("123@mail.ru", "connect DB", "connected for DB - ok");
    }
}
