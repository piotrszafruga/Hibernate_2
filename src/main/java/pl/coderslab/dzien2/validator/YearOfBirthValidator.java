package pl.coderslab.dzien2.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class YearOfBirthValidator implements ConstraintValidator<YearOfBirth, Integer> {

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        return currentYear - yearOfBirth >= 18;
    }

    @Override
    public void initialize(YearOfBirth constraintAccotation) {

    }
}
