package tech.reliab.course.latishevai.bank.service.exceptions;

public class BadUserRatingException extends Exception {
    public BadUserRatingException(Integer bankRating, double userRating) {
        super("Кредитный рейтинг пользователя недостаточно высок для выдачи кредита (рейтинг банка - "
                + bankRating + "; кредитный рейтинг пользователя - " + userRating + ")");
    }
}